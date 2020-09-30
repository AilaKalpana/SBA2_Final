package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.Exception.CkException;
import com.eval.coronakit.entity.KitDetail;

public interface KitDetailService {
	public KitDetail addKitItem(KitDetail kitItem) throws CkException;
	public KitDetail getKitItemById(int itemId) throws CkException;
	public List<KitDetail> getAllKitItemsOfAKit(int kitId) throws CkException;
	public List<KitDetail> getAll() throws CkException;
	//public void deleteByProductId(int productId) throws CkException;
	//public KitDetail findByproductId(KitDetail kitItem) throws CkException;
	public void deleteByproductId(int productId) throws CkException;
	public void existsByproductId(int productId) throws CkException;
	//public void deleteByProductId(KitDetail kitItem) throws CkException;
	//void deleteById(int ProdId);
	void deleteByProdId(int ProdId) throws CkException;
}
