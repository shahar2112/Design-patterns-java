package il.co.ilrd.Observer;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher<T> 
{
	private List<Mediator<T>> mediators;
	
	public Dispatcher()
	{
		mediators = new ArrayList<Mediator<T>>();
	}
	
	
	public void updateAll(T t)
	{	
		for(Mediator<T> iMediator: mediators)
		{
			iMediator.update(t);
		}
	}
	
	public void stopUpdate(T t) 
	{
		for(Mediator<T> iMediator: mediators)
		{
			iMediator.stopUpdate(t);
		}
	}
	
	
	public void subscribe(Mediator<T> observer)
	{
		System.out.println("Subscribed ");
		this.mediators.add(observer);
	}
	
	
	public void unsubscribe(Mediator<T> observer) 
	{
		System.out.println("you have been unsubscribed");
		this.mediators.remove(observer);
	}
}
