package com.uri.talos.exception;

public class TalosException extends Exception {


	private static final long serialVersionUID = 7019176181539872116L;
	
	
	public TalosException(String msg){
		super(msg);
	}
	public TalosException(String msg ,Throwable cause){
		super(msg,cause);
	}
	public TalosException(){
		super();
	}

}
