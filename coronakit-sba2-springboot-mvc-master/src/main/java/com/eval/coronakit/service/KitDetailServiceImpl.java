package com.eval.coronakit.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.Exception.CkException;
import com.eval.coronakit.dao.KitDetailRepository;
import com.eval.coronakit.entity.KitDetail;

@Service
public class KitDetailServiceImpl implements KitDetailService {

	@Autowired
	KitDetailRepository repository;
	
	@Override
	@Transactional
	public KitDetail addKitItem(KitDetail kitItem) throws CkException {
		if(kitItem!=null) {
			try {
				if(repository.existsById(kitItem.getId())) {
					throw new CkException("KitItem already exists!");
				}
			} catch (CkException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			repository.save(kitItem);
		}
		return kitItem;
	}
	

	@Override
	public KitDetail getKitItemById(int itemId)  {
		// TODO Auto-generated method stub
		return repository.findById(itemId).orElse(null);	
		//return null;
	}

	@Override
	public List<KitDetail> getAllKitItemsOfAKit(int kitId) {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public List<KitDetail> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	@Transactional
	public void deleteByProdId(int ProdId) throws CkException {
		KitDetail kitdetail = (repository.findByproductId(ProdId));
		// TODO Auto-generated method stubProdId
		if(kitdetail== null){
			throw new CkException("Product Id Not Found");
		}
		 repository.deleteByproductId(ProdId);
		
		}


	@Override
	public void deleteByproductId(int productId) throws CkException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void existsByproductId(int productId) throws CkException {
		// TODO Auto-generated method stub
		
	}
	
	
	
//	public KitDetail getByProductId(int ProdId) {
//		return repository.findByproductId(ProdId)).orElse(null);	
//	
//		
//	} 
	
	

}
