package com.ecommerce.seller.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.seller.model.ItemInventory;

@Repository
public interface ItemRepository extends JpaRepository<ItemInventory, Integer>{
	
	@Query(value = "SELECT * FROM item_table_seller WHERE item_table_seller.seller_id_fk = :sellerId"
			,nativeQuery = true)
	public List<ItemInventory> findBySellerId(@Param("sellerId") Integer sellerId);
	
	
//	@Query(value = "DELETE FROM item_table_seller WHERE item_table_seller.seller_id_fk = :sellerId AND item_table_seller.item_id = :itemId"
//			, nativeQuery = true)
//	public void deleteItemById(@Param("sellerId") Integer sellerId,@Param("itemId") Integer itemId);

	@Query(value = "FROM ItemInventory item WHERE lower(item.itemName) LIKE %:itemName%")
	public List<ItemInventory> findByString(@Param("itemName")String searchString); 
		
	

}
