package com.uri.talos.exception;

public class DaoException extends Exception {


	private static final long serialVersionUID = -4417363852350638745L;
	
	public DaoException(String msg){
		super(msg);
	}
	public DaoException(String msg ,Throwable cause){
		super(msg,cause);
	}
	public DaoException(){
		super();
	}

}
