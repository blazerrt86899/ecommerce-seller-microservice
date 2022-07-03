package com.ecommerce.seller.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.seller.model.ItemInventory;
import com.ecommerce.seller.model.SearchItem;
import com.ecommerce.seller.model.Seller;
import com.ecommerce.seller.repository.ItemRepository;
import com.ecommerce.seller.repository.SellerRepository;
import com.ecommerce.seller.responsemodel.SearchItemResponse;
import com.ecommerce.seller.responsemodel.StockResponse;
import com.ecommerce.seller.responsemodel.UpdateResponse;

@Service
public class ItemInventoryService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	
	public ItemInventory addItems(ItemInventory item) {
		System.out.println("service"+item.getSellerId().getSellerId());
		System.out.println(item.getImage());
		
		Optional<Seller> optionalSeller = sellerRepository.findById(item.getSellerId().getSellerId());
		item.setSellerId(optionalSeller.get());
		//System.out.println("service"+item.getSellerId().getSellerId());
		return itemRepository.save(item);
	}
	
	
	public List<SearchItemResponse> getAllItems(Integer sellerId){
		
		List<SearchItemResponse> viewItemList = new ArrayList<SearchItemResponse>();
		List<ItemInventory> itemList =  itemRepository.findBySellerId(sellerId);
		
		for(ItemInventory item : itemList) {
			SearchItemResponse viewItem = new SearchItemResponse();
			viewItem.setCategoryId(item.getCategory().getCategoryId());
			viewItem.setCategoryName(item.getCategory().getCategoryName());
			viewItem.setItemId(item.getItemId());
			viewItem.setItemName(item.getItemName());
			viewItem.setPrice(item.getItemCost());
			viewItem.setSellerId(item.getSellerId().getSellerId());
			viewItem.setStock(item.getItemStockNumber());
			viewItem.setSubCategoryId(item.getSubcategory().getSubCategoryId());
			viewItem.setSubCategoryName(item.getSubcategory().getSubCategoryName());
			viewItem.setImage(decompressZLib(item.getImage()));
			viewItemList.add(viewItem);
		}
		return viewItemList;
	}
	
	
	public List<SearchItemResponse> getAll(){
		
		List<SearchItemResponse> viewItemList = new ArrayList<SearchItemResponse>();
		List<ItemInventory> itemList =  itemRepository.findAll();
		
		for(ItemInventory item : itemList) {
			SearchItemResponse viewItem = new SearchItemResponse();
			viewItem.setCategoryId(item.getCategory().getCategoryId());
			viewItem.setCategoryName(item.getCategory().getCategoryName());
			viewItem.setItemId(item.getItemId());
			viewItem.setItemName(item.getItemName());
			viewItem.setPrice(item.getItemCost());
			viewItem.setSellerId(item.getSellerId().getSellerId());
			viewItem.setStock(item.getItemStockNumber());
			viewItem.setSubCategoryId(item.getSubcategory().getSubCategoryId());
			viewItem.setSubCategoryName(item.getSubcategory().getSubCategoryName());
			viewItem.setImage(decompressZLib(item.getImage()));
			viewItemList.add(viewItem);
		}
		return viewItemList;
	}
	
	
	public void deleteItem(Integer itemId) {
		itemRepository.deleteById(itemId);
	}
	
	
	public ItemInventory updateItem(UpdateResponse item, Integer itemId) {
		Optional<ItemInventory> optionalItem = itemRepository.findById(itemId);
		
		if(optionalItem.isPresent()) {
			ItemInventory updatedItem = optionalItem.get();
			updatedItem.setItemStockNumber(item.getItemStockNumber());
			//updatedItem.setCategory(item.getCategory());
			updatedItem.setItemDescription(item.getItemDescription());
			//updatedItem.setSellerId(item.getSellerId());
			//updatedItem.setSubcategory(item.getSubcategory());
			updatedItem.setItemName(item.getItemName());
			updatedItem.setItemRemarks(item.getItemRemarks());
			updatedItem.setItemCost(item.getItemCost());
			
			return itemRepository.save(updatedItem);
		}
		
		return null;
	}
	
	public List<SearchItemResponse> searchItem(SearchItem searchItem){
		List<SearchItemResponse> responseItemList = new ArrayList<>();
		List<ItemInventory> itemList = new ArrayList<>();
		 itemList = itemRepository.findByString(searchItem.getSearchString());
		 
		 for(ItemInventory item : itemList ) {
			 SearchItemResponse searchResponse =  new SearchItemResponse(item.getItemId(),item.getSellerId().getSellerId(),
					 item.getItemName(),item.getItemStockNumber(),item.getItemCost(),item.getCategory().getCategoryId(),
					 item.getCategory().getCategoryName(),item.getSubcategory().getSubCategoryId(),
					 item.getSubcategory().getSubCategoryName(),decompressZLib(item.getImage()));
			 responseItemList.add(searchResponse);
		 }
		 return responseItemList;
	}


	public void updateStock(List<StockResponse> stockResponse) {
		ItemInventory item = null;
		for(StockResponse itemstock : stockResponse) {
			Optional<ItemInventory> newitem = itemRepository.findById(itemstock.getItemId());
			 item = new ItemInventory();
			 item =	newitem.get();
			 Integer quantity = item.getItemStockNumber();
			 item.setItemStockNumber(quantity-itemstock.getItemQuantity());
			 itemRepository.save(item);
		}
		
	}
	
	//uncompress the image
	
	public static byte[] decompressZLib(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		//System.out.println("THis is decompression "+outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}

	

}
