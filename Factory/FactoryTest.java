package il.co.ilrd.Factory;

import java.util.function.Function;

public class FactoryTest 
{
	public static void main(String[] args)
	{
		Factory<Animals , String, String> myfactory = new Factory<>();
		Function<String, Animals> lambdaAnimal = (nothing) -> {return new Animals();};		
		
		myfactory.add("ANIMAL", lambdaAnimal);
		myfactory.create("ANIMAL", null);
		
		Function<String, Bear> lambdaBear = (s) -> {return new Bear(s);};
		myfactory.add("BEAR", lambdaBear);
		Animals dog = myfactory.create("BEAR", "Poo");
		dog.voice();
		
		Function<String, Tiger> lambdaTiger = (t) -> {return new Tiger(t);};
		myfactory.add("TIGER", lambdaTiger);
		Animals tiger = myfactory.create("TIGER", "Too");
		tiger.voice();
		
		//passing method references
		Factory<Animals , String, Integer> myfactory2 = new Factory<>();
		Function<Integer, Animals> lambdaStaticAnimal = (nothing) -> {return Animals.staticCreatorMethod();};
		myfactory2.add("ANIMAL", lambdaStaticAnimal);
		
		//Reference to a static method
		Function<Integer, Animals> lambdaStaticBEAR = Bear :: staticCreatorMethod;
		myfactory2.add("BEAR", lambdaStaticBEAR);
		myfactory2.create("BEAR", 2);
	
		//Reference to a non static method
		Bear pooBear = new Bear(2);
		myfactory2.add("BEAR", pooBear :: instanceCreatorMethod);
		myfactory2.create("BEAR", 2);
		
		//reference to a constructor
		myfactory2.add("TIGER", Tiger :: new);
		tiger = myfactory2.create("TIGER", 4);
		tiger.voice();
		
		Function<String, Cat> lambdaCat = (t) -> {return new Cat(t);};
		myfactory.add("CAT", lambdaCat);
		Animals cat = myfactory.create("CAT", "kitty");
		cat.voice();

	}

}

class Animals
{
	
	public Animals()
	{

	}
	
	void voice()
	{
		System.out.println("animal voice");
	}
	
	static Animals staticCreatorMethod()
	{
		return new Animals();
	}
	
	Animals instanceMethod()
	{
		return new Animals();
	}
	
}

class Bear extends Animals
{

	public Bear(String name)
	{
		super();
		System.out.println("Bear constructor");
	}
	
	
	public Bear(Integer legs)
	{
		System.out.println("Bear constructor, I have " + legs + " legs");
	}
	
	void voice()
	{
		System.out.println("“You're braver than you believe, stronger than you seem, and smarter than you think.”");
	}
	
	static Animals staticCreatorMethod(Integer legs)
	{
		return new Bear(legs);
	}
	
	Animals instanceCreatorMethod(Integer legs)
	{
		System.out.println("“If you live to be a hundred, "
				+ "I hope I live to be a hundred minus one day,"
				+ " so that I never have to live a day without you.”");
		return new Bear(legs);
	}
	
}

class Tiger extends Animals
{
	private String color;
	private static Integer legs = 4;
	
	public Tiger(String name)
	{
		super();
		this.color = "orange";
		
		System.out.println("My name is " + name + " my color is " + color);
	}
	
	
	public Tiger(Integer legs)
	{
		System.out.println("Tiger constructor, I have " + legs + "legs");
	}
	
	void voice()
	{
		System.out.println("“They're bouncy, trouncy,"
				+ " flouncy, pouncy, fun, fun, fun, fun, fun."
				+ " But the most wonderful thing about Tiggers,"
				+ " is I'm the only one. IIIII'm the only one!”");
	}
	
	static Animals staticCreatorMethod()
	{
		return new Tiger(legs);
	}
}

class Cat extends Tiger
{
	private String name;
	
	public Cat(String name)
	{
		super(name);
		this.name = name;
		System.out.println("I am a cat");
	}
	
	
	void voice()
	{
		System.out.println("miawwwwww PSSSS PSSS my name is " + name);
	}
	
	
}