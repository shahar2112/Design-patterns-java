package il.co.ilrd.Observer;


public class FlightPrice<T> 
{
	private Dispatcher<T> flightdispatcher;
	private String country;
	
	public FlightPrice(String country)
	{
		this.flightdispatcher = new Dispatcher<T>();
		this.country = country;
	}
	
	public Dispatcher<T> GetDispatcher()
	{
		return this.flightdispatcher;
	}
	
	public void setandupdate(T t)
	{
		System.out.println("\n-->UPDATE<--");
		System.out.println("The new price for flight to "+ this.country + " is: " + t);
		this.flightdispatcher.updateAll(t);
	}
	
	public void stopupdate(T t)
	{
		System.out.println("\n-->UPDATE STOPPED<--");
		System.out.println("\nYou have been currently stopped getting updates for flights to " + this.country);
		this.flightdispatcher.stopUpdate(t);
	}
	
	public String getCountry()
	{
		return this.country;
	}
}
