package com.eval.coronakit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eval.coronakit.entity.KitDetail;

@Repository
public interface KitDetailRepository extends JpaRepository<KitDetail, Integer>{
	
	@Modifying
	@Query(value = "DELETE from KIT_DETAIL where PRODUCT_ID =?1",nativeQuery=true)
	public void deleteByproductId(int ProdId);
	
	@Query(value = "SELECT * from KIT_DETAIL where PRODUCT_ID =?1",nativeQuery=true)
	public KitDetail findByproductId(int ProdId);
	
	@Query(value = "SELECT * from KIT_DETAIL where PRODUCT_ID =?1",nativeQuery=true)
	public boolean existsByproductId(int prodId);

}
