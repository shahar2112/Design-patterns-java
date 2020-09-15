package decorator;

public class Main 
{
	public static void main(String[] args) 
	{
		Pizza myPizza = new PepperPanneer();
		//should print : Price of Peppy Paneer pizza is 10
		System.out.printf("Price of %s is %d %n", myPizza.getDetails(),
		myPizza.getPrice());
		
		myPizza = new JalapenoTopping(myPizza);
		System.out.printf("Price of %s is %d %n", myPizza.getDetails(),
				myPizza.getPrice());
		//should print : Price of Peppy Paneer pizza with Jalapeno Toppings is 13
		
		myPizza = new JalapenoTopping(myPizza);
		System.out.printf("Price of %s is %d %n", myPizza.getDetails(),
				myPizza.getPrice());
		//should print : Price of Peppy Paneer pizza with Jalapeno Toppings with Jalapeno Toppings is
		//16
		
		myPizza = new CheeseTopping(myPizza);
		System.out.printf("Price of %s is %d %n", myPizza.getDetails(),
				myPizza.getPrice());
		//should print : Price of Peppy Paneer pizza with Jalapeno Toppings with Jalapeno Toppings
		//		with cheese Toppings is //18
	}
}
