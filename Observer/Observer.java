package il.co.ilrd.Observer;

public abstract class Observer<T>
{
	private Mediator<T> mediator;
	
	protected Observer(Dispatcher<T> dispatcher)
	{
		mediator = new Mediator<T>(dispatcher, t -> this.update(t),  e -> this.StopUpdate(e));
	}
	
	public void update(T t)
	{
		System.out.println("updating :" + t);
	}
	
	
	public void subscribe() 
	{
		getDispatcher().subscribe(mediator);
	}
	
	public void unsubscribe()
	{
		getDispatcher().unsubscribe(mediator);
	}
	
	public void StopUpdate(T t) 
	{
		System.out.println("update stopped with :" + t);
	}
	
	
	private Dispatcher<T> getDispatcher() 
	{
		return mediator.getDispatcher();
	}
	
	public void setDispatcher(Dispatcher<T> dispatcher)
	{
		mediator.getDispatcher().unsubscribe(mediator);
		mediator.setDispatcher(dispatcher);
	}
}
