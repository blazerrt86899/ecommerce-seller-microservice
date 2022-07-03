package com.ecommerce.seller.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.seller.model.ItemInventory;
import com.ecommerce.seller.model.SearchItem;
import com.ecommerce.seller.responsemodel.SearchItemResponse;
import com.ecommerce.seller.responsemodel.StockResponse;
import com.ecommerce.seller.responsemodel.UpdateResponse;
import com.ecommerce.seller.service.ItemInventoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/item")
public class ItemInventoryController {
	
	@Autowired
	private ItemInventoryService itemService;
	
	@PostMapping(value = "/additem",produces = "application/json")
	public ItemInventory addItem(@RequestBody ItemInventory item) {
		return itemService.addItems(item);
	}
	
	@GetMapping(value = "/getAll/{sellerid}")
	public List<SearchItemResponse> getAllItems(@PathVariable("sellerid") Integer sellerId) {
		return itemService.getAllItems(sellerId);
	}
	
//	@GetMapping(value = "/getAll")
//	public List<SearchItemResponse> getAll(){
//		return itemService.getAll();
//	}
	
	
	@PutMapping(value = "/updateitem/{itemid}", produces = "application/json")
	public ItemInventory updateItem(@RequestBody UpdateResponse item, @PathVariable("itemid") Integer itemId) {
		return itemService.updateItem(item, itemId);
	}
	
	@DeleteMapping(value = "/deleteitem/{itemid}")
	public void deleteItem(@PathVariable("itemid") Integer itemId) {
		itemService.deleteItem(itemId);
	}
	
	@PostMapping(value = "/searchitem",produces = "application/json")
	public List<SearchItemResponse> searchItemByString(@RequestBody SearchItem item ){
		return itemService.searchItem(item);
	}
	
	@PutMapping(value = "/updatestock", produces = "application/json")
	public void updateItemStock(@RequestBody List<StockResponse> stockResponse) {
		 itemService.updateStock(stockResponse);
	}

}
