package decorator;

public abstract class ToppingDecorator implements Pizza
{
	Pizza pizzaWrapper;
	
	public ToppingDecorator(Pizza myPizza)
	{
		this.pizzaWrapper = myPizza;
	}
	
	@Override
	public int getPrice() 
	{
		return pizzaWrapper.getPrice();
	}

	@Override
	public String getDetails() 
	{
		return pizzaWrapper.getDetails();
	}

}
