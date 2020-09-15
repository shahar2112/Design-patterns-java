package decorator;

public class PepperPanneer implements Pizza 
{
	private static final int PRICE = 10;
	
	@Override
	public int getPrice() 
	{
		return PRICE;
	}

	@Override
	public String getDetails()
	{
		return "Peppy paneer Pizza";
	}

}
