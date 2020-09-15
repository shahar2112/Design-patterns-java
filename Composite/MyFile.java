package il.co.ilrd.Composite;

import java.io.File;

/*This class is a leaf of the composite, a regular file not a folder */
public class MyFile implements FileComponent
{
	private File file;
	private int depth;
	
	public MyFile(File file, int depth)
	{
		this.file = file;
		this.depth = depth;
	}

	@Override
	public void print() 
	{
		System.out.print("|");
		for(int i = 0; i < this.depth; ++i)
		{			
			System.out.print("-");
		}
		System.out.println(file.getName());
	}
}

