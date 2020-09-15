package il.co.ilrd.Observer;

public class Testobs {

	public static void main(String[] args) 
	{
		FlightPrice<Integer> flightPriceAmsterdam = new FlightPrice<Integer>("Amsterdam");
		FlightPrice<Integer> flightPriceParis = new FlightPrice<Integer>("Paris");
		
		Observer1 observer1 = new Observer1(flightPriceAmsterdam.GetDispatcher(), 500, "Mark");
		Observer2 observer2 = new Observer2(flightPriceAmsterdam.GetDispatcher(), "Meital");
		Observer3 observer3 = new Observer3(flightPriceAmsterdam.GetDispatcher(), "Liran");
		
		observer1.subscribe();
		observer2.subscribe();
		observer3.subscribe();
		
	
		
		flightPriceAmsterdam.setandupdate(400);

		observer2.unsubscribe();
		
		flightPriceAmsterdam.setandupdate(600);
		
		flightPriceAmsterdam.stopupdate(600);
		flightPriceParis.setandupdate(200);
		
		observer2.setDispatcher(flightPriceParis.GetDispatcher());
		observer2.subscribe();
	
		flightPriceParis.setandupdate(300);
		
		for(int i = 1; i < 3; ++i)
		{
			final int k = i;
			Thread thread = new Thread(() -> {flightPriceAmsterdam.setandupdate(300*k); });
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		
		
	}

}

class Observer1 extends Observer<Integer>
{
	int maxprice;
	String name;
	
	Observer1(Dispatcher<Integer> dispatcher, int maxprice, String name) 
	{
		super(dispatcher);
		this.maxprice = maxprice;
		this.name = name;
	}
	
	@Override
	public void update(Integer t)
	{
		System.out.println("\n--->" + this.name);
		System.out.println("The new price is " + t);
		
		if(t.compareTo(this.maxprice) > 0)
		{
			System.out.println("The price is too high for me");
		}
		else
		{			
			super.update(t);
		}
	}
	
	@Override
	public void StopUpdate(Integer t)
	{
		System.out.println("\nI am " + this.name + ", you stopped my update");
		System.out.println("The last price was " + t);
	}	
}




class Observer2 extends Observer<Integer>
{
	String name;
	
	Observer2(Dispatcher<Integer> dispatcher, String name)
	{
		super(dispatcher);
		this.name =  name;
	}
	
	@Override
	public void update(Integer t) 
	{
		System.out.println("\n--->" + this.name);
		System.out.println("Thank you for updating me I just wanted to know the price");
	}
	
	@Override
	public void StopUpdate(Integer t)
	{
		System.out.println("\nYou stopped updating " + this.name);
	}
}





class Observer3 extends Observer<Integer>
{
	static int maxPrice = 1000;
	String name;
	
	Observer3(Dispatcher<Integer> dispatcher, String name)
	{
		super(dispatcher);
		this.name = name;
	}
	
	@Override
	public void update(Integer t) 
	{
		System.out.println("\n--->" + this.name);
		if(t.compareTo(maxPrice) > 0)
		{
			System.out.println("I will never pay more than 1000 for a flight");
		}
		else
		{
			System.out.println("Thanks for the update, i will think about that");			
		}
	}
	
	@Override
	public void StopUpdate(Integer t)
	{
		System.out.println("\nYou stopped updating " + this.name);
	}
}