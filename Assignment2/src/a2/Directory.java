package a2;

import java.util.ArrayList;

public class Directory {
	
	private String name;
	private ArrayList<Directory> subDirectory;
	private ArrayList<File> Files;
	
	public Directory(String name){
		this.name = name;
		this.Files = new ArrayList<File>();
		this.subDirectory = new ArrayList<Directory>();
	}

}
