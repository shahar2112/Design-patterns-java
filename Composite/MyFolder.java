package il.co.ilrd.Composite;

import java.io.File;
import java.util.ArrayList;

/* This class is a composite class, has files inside it. */
public class MyFolder implements FileComponent
{
	private String folderName;
	private ArrayList<FileComponent> myFiles;
	private int depth;
	
	public MyFolder(File folder, int depth)
	{
		myFiles = new ArrayList<FileComponent>();
		this.folderName = folder.getName();
		this.depth = depth;
	}

	@Override
	public void print() 
	{
		printDepth();
		
		System.out.println(folderName);
		
		for(FileComponent myfiles : myFiles)
		{
			myfiles.print();
		}
		
	}
	
	
	
	/* adding to the array list folders with files and files */
	public void addFileComponent(String path)
	{
		File endfile = new File(path);
		File[] myfilesAndDir = endfile.listFiles();
		
		for(File files : myfilesAndDir)
		{
			if(files.isDirectory())
			{
				addFolder(files);
			}
			else
			{
				MyFile file = new MyFile(files, depth +1);
				myFiles.add(file);
			}
		}
	}
	
	/*utility function to create new folder and add that
	 * folder to the component array and then call recursively 
	 * this function with the new path (including curr folder)*/
	private void addFolder(File files)
	{
		MyFolder folder = new MyFolder(files, depth +1);
		myFiles.add(folder);
		String newpath = files.getPath();
		folder.addFileComponent(newpath);
	}
	
	/*utility function to print dashs for the folders depth */
	private void printDepth()
	{
		System.out.print("|");
		for(int i = 0; i < this.depth; ++i)
		{			
			System.out.print("-");
		}
	}
}
