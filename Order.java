package prShoppingCart.src.prShoppingCart;

public class Order {

	private int barCode;
	private String name;
	private String size;
	private int units;
	protected float priceUnit;
	
	
	public Order(int barCode, String name, String size, int units, float priceUnit) throws ShoppingCartException{
		
		this.barCode = barCode;
		this.name = name;
		this.units = units;
		this.priceUnit = priceUnit;
		String possibleSize [] = {"BOTTLE", "PAINT", "HALF PAINT"};
		int cont = 0;
		for(int i = 0;  i < possibleSize.length; ++i) {
			if(size.toUpperCase().equals(possibleSize[i])) cont++;
		}
		if (cont == 1) this.size = size;
		else throw new ShoppingCartException("ERROR: wrong size");
				
}
	
	
	public int getBarCode() {
		return this.barCode; 
	}
	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}
	public String getName() { return this.name;}
	public void setName(String name) {this.name=name;}
	public String getBeerSize() {return this.size;}
	public void setBeerSize(String beerSize) throws ShoppingCartException {
		String possibleSize [] = {"BOTTLE", "PAINT", "HALF PAINT"};
		int cont = 0;
		for(int i = 0;  i < possibleSize.length; ++i) {
			if(size.toUpperCase().equals(possibleSize[i])) cont++;
		}
		if (cont == 1) this.size = size;
		else throw new ShoppingCartException("ERROR: wrong size");}	
	public int getUnits() {return this.units;}
	public void setUnits(int units) {this.units = units;}
	public float getPriceUnit() {return this.priceUnit;}
	public void setPriceUnit(float priceUnit) {this.priceUnit = priceUnit;} 

	public String toString() {
		return this.barCode+";"+this.name+";"+this.size+";"+this.units+";"+this.priceUnit;
	}
}
	