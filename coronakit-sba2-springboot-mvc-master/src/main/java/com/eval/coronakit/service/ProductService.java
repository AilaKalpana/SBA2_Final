package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.Exception.CkException;
import com.eval.coronakit.entity.ProductMaster;

public interface ProductService {

	public ProductMaster addNewProduct(ProductMaster product) throws CkException;
	public List<ProductMaster> getAllProducts() throws CkException;
	public ProductMaster deleteProduct(int productId) throws CkException;
	public ProductMaster getProductById(int productId) throws CkException;
	ProductMaster saveProduct(ProductMaster product) throws CkException;
}
