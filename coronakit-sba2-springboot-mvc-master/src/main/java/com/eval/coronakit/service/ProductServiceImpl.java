package com.eval.coronakit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.Exception.CkException;
import com.eval.coronakit.dao.ProductMasterRepository;
import com.eval.coronakit.entity.ProductMaster;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMasterRepository repository;
	
	@Override
	@Transactional
	public ProductMaster addNewProduct(ProductMaster product) throws CkException {
		if(product!=null) {
			if(repository.existsById(product.getId())) {
				throw new CkException("Product Id already used!");
			}
			
			repository.save(product);
		}
		return product;
	}
		

	@Override
	public List<ProductMaster> getAllProducts() throws CkException {
		return repository.findAll();
	}

	@Override
	@Transactional
	public ProductMaster deleteProduct(int productId) throws CkException{
		if(!repository.existsById(productId)) {
			throw new CkException("Product Id Not Found");
		}
		repository.deleteById(productId);
		return null;
		
	}

	@Override
	public ProductMaster getProductById(int productId) {
		return repository.findById(productId).orElse(null);	
	}
	
	@Override
	public ProductMaster saveProduct(ProductMaster product) throws CkException {
		if(product!=null) {
			
			repository.save(product);
		}
		return product;
	}

}
