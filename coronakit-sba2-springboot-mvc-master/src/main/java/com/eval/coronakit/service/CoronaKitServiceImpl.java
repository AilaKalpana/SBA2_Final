package com.eval.coronakit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.Exception.CkException;
import com.eval.coronakit.dao.CoronaKitRepository;
import com.eval.coronakit.entity.CoronaKit;


@Service
public class CoronaKitServiceImpl implements CoronaKitService {

	@Autowired
	CoronaKitRepository repository;
	
	@Override
	@Transactional
	public CoronaKit saveKit(CoronaKit kit) throws CkException {
		if(kit!=null) {
//			if(!repository.existsById(kit.getId())) {
//				throw new CkException("Kit Not Found");
//			}
			
			repository.save(kit);
		}
		return kit;
		
	}

	@Override
	public CoronaKit getKitById(int kitId) {
		return repository.findById(kitId).orElse(null);	
		
	}
	
	@Override
	public List<CoronaKit> getAll() {
		return repository.findAll();
	}

}
