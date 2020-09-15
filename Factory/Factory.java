package il.co.ilrd.Factory;
import java.util.Map;
import java.util.function.Function;
import il.co.ilrd.HashMap.HashMap;


/* K = is the key type
 * T = the common created type
 * D = the creator function parameter type*/
public class Factory<T,K,D> 
{
	private Map<K,Function<D,? extends T>> map;
	private static int CAPACITY = 10;
	
	public Factory()
	{
		this.map = new HashMap<>(CAPACITY);
	}
	
	public void add(K key, Function<D, ? extends T> creator)
	{
		map.put(key, creator);
	}
	
	/* return null if this key does not exist
	 * data is the parameter of the ctor.	*/
	public T create(K key, D data)
	{
		if(!map.containsKey(key))
		{
			return null;
		}
		Function<D, ? extends T> creator = map.get(key);
		return creator.apply(data);
	}
}




