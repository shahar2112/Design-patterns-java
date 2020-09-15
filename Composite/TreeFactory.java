package il.co.ilrd.Composite;

import java.io.File;

/*This class creates a fileComponent of type folder or file
 * if file is directory so add "root" folder and call 
 * addFileComponent to create rest of the array tree */
public class TreeFactory 
{
	private FileComponent fileComponent;
	
	//constructor
	public TreeFactory(String path) 
	{
		File file = new File(path);
		
		if(file.isDirectory())
		{
			fileComponent = new MyFolder(file, 0);
			((MyFolder) fileComponent).addFileComponent(path);
		}
		else
		{
			fileComponent = new MyFile(file, 0);
		}
		
	}

	
	public void print()
	{
		fileComponent.print();
	}
	
}
