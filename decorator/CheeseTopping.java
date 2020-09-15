package decorator;

public class CheeseTopping extends ToppingDecorator
{
	private static final int CHEESE_PRICE = 2;
	
	public CheeseTopping(Pizza myPizza)
	{
		super(myPizza);
	}
	
	@Override
	public int getPrice() 
	{
		return super.getPrice() + CHEESE_PRICE;
	}

	@Override
	public String getDetails() 
	{
		return super.getDetails() + " with cheese"; 
	}

}
