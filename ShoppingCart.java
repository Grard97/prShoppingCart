package prShoppingCart;

import java.util.Scanner;
import java.io.*;

public class ShoppingCart {
	
	private Order [] Oarr;
	private final int default_size = 10;
	private int numOrders = 0;
	
	public ShoppingCart() {
	this.Oarr  = new Order [10];
	}
	
	public ShoppingCart(int initSize) {
		this.Oarr = new Order[initSize];
	}
	
	
	public void add (Order o) {
		boolean IsIn = false;
		int i = 0;
		while (i<Oarr.length && IsIn == false) {
			if(o.equals(Oarr[i])) IsIn = true;
			++i;
		}
		if (IsIn) Oarr[i].setUnits(o.getUnits());
		else { 
			if(numOrders == Oarr.length) System.arraycopy(Oarr, 0, Oarr, 0, Oarr.length*2);
			Oarr[i] = o;
		}
	}
	
	public void loadFromFile(String filename) throws FileNotFoundException, ShoppingCartException {
		Scanner sc = new Scanner(new File(filename));

		while (sc.hasNextLine()) {
			int actual = numOrders+1;
			Oarr[actual].setBarCode(sc.nextInt());
			Oarr[actual].setName(sc.nextLine());
			Oarr[actual].setBeerSize(sc.nextLine());
			Oarr[actual].setUnits(sc.nextInt());
			Oarr[actual].setPriceUnit(sc.nextDouble());
		}
	}
	
	public void listOrders() {
		for (int i = 0; i<Oarr.length;++i) {
			
			System.out.println(Oarr[i]);
		}
	}
	
	public float getBill() {
		float bill=0;
		for (int i = 0; i<Oarr.length;++i) {bill += Oarr[i].getPriceUnit();}
		return bill;
	}
	
	private int seek (Order o){
		int i = 0;
		int res;
		while (i<Oarr.length && Oarr[i] != o) {
			i++;
		}
		if (i < Oarr.length) res = i;
		else res = -1;
		return res;
	}
	
	
}
