package decorator;


public class JalapenoTopping extends ToppingDecorator
{
	private static final int JALEPO_PRICE = 3;
	
	public JalapenoTopping(Pizza myPizza) 
	{
		super(myPizza);
	}
	
	@Override
	public int getPrice() 
	{
		return super.getPrice() + JALEPO_PRICE;
	}

	@Override
	public String getDetails() 
	{
		return super.getDetails() + " with Jalepo"; 
	}

}
