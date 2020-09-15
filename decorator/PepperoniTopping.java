package decorator;

public class PepperoniTopping extends ToppingDecorator
{
	private static final int PEPPERONI_PRICE = 4;
	
	public PepperoniTopping(Pizza myPizza) 
	{
		super(myPizza);
	}
	
	@Override
	public int getPrice() 
	{
		return super.getPrice() + PEPPERONI_PRICE;
	}

	@Override
	public String getDetails() 
	{
		return super.getDetails() + " with pepperoni"; 
	}
}
