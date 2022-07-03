package com.ecommerce.seller.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.Deflater;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.seller.model.ItemInventory;
import com.ecommerce.seller.model.ProductCategory;
import com.ecommerce.seller.model.ProductSubCategory;
import com.ecommerce.seller.model.Seller;
import com.ecommerce.seller.repository.ItemRepository;
import com.ecommerce.seller.responsemodel.SearchItemResponse;
import com.ecommerce.seller.responsemodel.UpdateResponse;
import com.ecommerce.seller.service.ItemInventoryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("image")
public class ImageUploadController {

	 @Autowired
	 private ItemInventoryService itemInventoryService;
	
	 @Autowired
	 private ItemRepository itemRepository;

	@PostMapping("/upload")
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file, @RequestParam("itemname") String itemName,
			@RequestParam("seller") String seller, @RequestParam("category") String category , @RequestParam("subcategory") String subCategory,
			@RequestParam("price") String price, @RequestParam("stock") String stock, @RequestParam("desc") String description, @RequestParam("remark") String remark) 
	throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		Seller sellerId = new Seller();
		ProductCategory categoryId = new ProductCategory();
		ProductSubCategory subCategoryId = new ProductSubCategory();
		sellerId.setSellerId(Integer.parseInt(seller));
		categoryId.setCategoryId(Integer.parseInt(category));
		subCategoryId.setSubCategoryId(Integer.parseInt(subCategory));
		
		System.out.println(sellerId.getSellerId());
		ItemInventory item = new  ItemInventory(sellerId,categoryId, subCategoryId, Double.parseDouble(price), itemName,description, Integer.parseInt(stock),
				 remark, compressZLib(file.getBytes()));
		itemInventoryService.addItems(item);
		return ResponseEntity.status(HttpStatus.OK);
	}

	@GetMapping(path = { "/get/{itemId}" })
	public UpdateResponse getImage(@PathVariable("itemId") Integer itemId) throws IOException {

		final Optional<ItemInventory> retrievedItem = itemRepository.findById(itemId);
		
		UpdateResponse updateItem = new UpdateResponse(retrievedItem.get().getItemCost(),retrievedItem.get().getItemName()
				,retrievedItem.get().getItemDescription(),retrievedItem.get().getItemStockNumber(),retrievedItem.get().getItemRemarks());
		return updateItem;
	}

	@GetMapping(value = "/getAll")
	public List<SearchItemResponse> getAll(){
		return itemInventoryService.getAll();
	}
	
	
	
	// compress the image bytes before storing it in the database
	public static byte[] compressZLib(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
//	public static byte[] decompressZLib(byte[] data) {
//		Inflater inflater = new Inflater();
//		inflater.setInput(data);
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//		byte[] buffer = new byte[1024];
//		try {
//			while (!inflater.finished()) {
//				int count = inflater.inflate(buffer);
//				outputStream.write(buffer, 0, count);
//			}
//			outputStream.close();
//		} catch (IOException ioe) {
//		} catch (DataFormatException e) {
//		}
//		return outputStream.toByteArray();
//	}
}