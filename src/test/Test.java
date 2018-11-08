package test;

import a2.*;

public class Test {
	private FileSystem fs;
	Test(){
		fs = FileSystem.createInstanceOfFileSystem();
	}
	
	public static FileDirectory getItem(int number){
		Directory item1 = new Directory("item1", null);
		Directory item2 = new Directory("item2", item1);
		Directory item3 = new Directory("item3", item2);
		Directory item4 = new Directory("item4", item3);
		Directory item5 = new Directory("item5", item4);
		File file1 = new File("file1",item5);
		
		if (number == 1)
			return item1;
		if (number == 2)
			return item2;
		if (number == 3)
			return item3;
		if (number == 4)
			return item4;
		if (number == 5)
			return item5;
		if (number == 6)
			return file1;
		else
			return null;
			
	}
	public static void testFile(){
		String actual, expect;
		File file = new File("hello", null);
		file.setContent("beg some mark QAQ");
		
		actual = file.getName();
		expect = "hello";
		System.out.println("Check the name of file: "+ actual.equals(expect));
		
		actual = file.getContent();
		expect = "beg some mark QAQ";
		System.out.println("Check the content in the file: "+ actual.equals(expect));
	}
	
	public static void main(String [] args){
		testFile();
	}
}
