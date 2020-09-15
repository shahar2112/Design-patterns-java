package il.co.ilrd.Observer;

import java.util.function.Consumer;


public class Mediator<T> 
{
	private Dispatcher<T> dispatcher;
	private Consumer<T> updateObs;
	private Consumer<T> stopUpdateObs;
	
	Mediator(Dispatcher<T> dispatcher, Consumer<T> update, Consumer<T> stop)
	{
		this.dispatcher = dispatcher;
		this.updateObs = update;
		this.stopUpdateObs = stop;
	}
	
	public void stopUpdate(T t) 
	{
		stopUpdateObs.accept(t);
	}
	
	
	public void update(T t)
	{
		updateObs.accept(t);
	}
	
	
	public Dispatcher<T> getDispatcher() 
	{
		return this.dispatcher;
	}
	
	
	public void setDispatcher(Dispatcher<T> dispatcher) 
	{
		this.dispatcher = dispatcher;
	}
}


