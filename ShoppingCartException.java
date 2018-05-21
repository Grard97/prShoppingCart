package prShoppingCart.src.prShoppingCart;

public class ShoppingCartException extends Exception{
	
	public ShoppingCartException () {
		super();
	}
	
	public ShoppingCartException(String message) {
		super();
		System.err.println(message);
	}

}
