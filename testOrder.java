package prShoppingCart.src.prShoppingCart;

public class testOrder {

	public static void main(String[] args) throws ShoppingCartException {
			
		Order or1 = new Order (1,"Beer1","Paint",1,3);
		Order or2 = new Order (2,"Beer2","Paint",2,2);
		Order or3 = new Order (1,"Beer1","Bottle",1,3);
		
		System.out.println(or1.toString());
		System.out.println(or2.toString());
		System.out.println(or3.toString());
	}

}
