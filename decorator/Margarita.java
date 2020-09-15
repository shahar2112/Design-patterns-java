package decorator;

public class Margarita implements Pizza
{
	private static final int PRICE = 12;
	
	@Override
	public int getPrice() 
	{
		return PRICE;
	}

	@Override
	public String getDetails()
	{
		return "Pizza Margarita";
	}

}
