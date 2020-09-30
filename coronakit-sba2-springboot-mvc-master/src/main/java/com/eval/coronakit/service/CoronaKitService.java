package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.Exception.CkException;
import com.eval.coronakit.entity.CoronaKit;

public interface CoronaKitService {
	public CoronaKit saveKit(CoronaKit kit) throws CkException;
	public CoronaKit getKitById(int kitId);
	public List<CoronaKit> getAll();
}
