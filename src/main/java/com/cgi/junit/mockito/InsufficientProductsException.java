package com.cgi.junit.mockito;

public class InsufficientProductsException extends Exception{
	private static final long serialVersionUID = 1L;
	private String exceptionMessage;
	
	public InsufficientProductsException(int quantityInStock, int quantityToBuy) {
		this.exceptionMessage = "There are " + quantityInStock + " in stock, but you are tring to buy " + quantityToBuy;
	}
	
	@Override
	public String getMessage() {
		return exceptionMessage;
	}
}
