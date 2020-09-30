package com.eval.coronakit.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

//@ControllerAdvice
public class CkException extends Exception {
	public CkException(String errMsg){
		super(errMsg);
	}
	
}
