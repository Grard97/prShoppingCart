
import java.util.*;
import prShoppingCart.*;

public class VIPPrancingPony 
{

	public static void main(String[] args) 
	{
		String [] VIPS = { 	"James Hetfield",
							"Lars Ulrich",
							"Kirk Hammett",
							"Dave Mustaine",
							"Jason Newsted",
							"Cliff Burton",
							"Robert Trujillo",
							"Ron McGovney"};
		
		VIPShoppingCart cart = new VIPShoppingCart(VIPS);
		boolean exit = false;
		
		Scanner keyboard = new Scanner(System.in);		
		System.out.print("Client Name:");
		String client = keyboard.nextLine();
		
		while(!exit)
		{
			char op = Menu();
			
			switch (op)
			{
				case 'A':	cart.add(ReadOrderFromKeyboard());
						  	break;
				case 'B':	System.out.print("File Name:");
							cart.loadFromFile(new Scanner(System.in).nextLine());
					  		break;
				case 'C':	cart.listOrders();
					  		break;
				case 'D':	cart.listOrders();
							System.out.println("Total: $" + cart.getBill(client));
							System.out.println("You are paying the bill");
							if (Confirm())
							{
								System.out.println("Done");
								cart = new VIPShoppingCart(VIPS);
							}
					 		break;
				case 'E':	exit = Confirm();
			 				break;
				default: System.out.println("Wrong Option");
			}
			if (!exit) Pause();
		}
	}

	public static char Menu()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("\tDeveloped by: <Name> "); 
		System.out.println("\t10th May 2018");
		System.out.println("\tThe Inn of the Prancing Pony");
		System.out.println("\t============================");
		System.out.println("\t\tA. Order.");
		System.out.println("\t\tB. Load Shopping Cart from text file.");
		System.out.println("\t\tC. List Shopping Cart.");
		System.out.println("\t\tD. Pay the bill.");
		System.out.println("\t\tE. Exit.");
		System.out.println();
		System.out.print("\t\tOption:"); 

		return keyboard.nextLine().toUpperCase().charAt(0);
		
	}
	
	public static void Pause()
	{

		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Press ENTER to Continue ...");
		keyboard.nextLine();
		
	}
	
	public static boolean Confirm()
	{

		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Are you sure (Yes/No)");
		return keyboard.nextLine().compareToIgnoreCase("yes")==0;
		
	}
	
	public static Order ReadOrderFromKeyboard()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Bar Code: ");
		int bc = keyboard.nextInt();
		System.out.print("Name: ");
		String n = keyboard.next();
		System.out.print("Beer Size: ");
		String bs = keyboard.next();
		System.out.print("Units: ");
		int u = keyboard.nextInt();
		System.out.print("Price per Unit: ");
		float p = keyboard.nextFloat();
		
		return new Order(bc,n,bs,u,p);
	}
}
