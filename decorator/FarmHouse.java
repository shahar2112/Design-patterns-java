package decorator;

public class FarmHouse implements Pizza
{
	private static final int PRICE = 13;
	
	@Override
	public int getPrice() 
	{
		return PRICE;
	}

	@Override
	public String getDetails()
	{
		return "Farm House Pizza";
	}
}
