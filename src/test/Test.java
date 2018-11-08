package test;

import a2.*;

public class Test {
	private FileSystem fs;
	Test(){
		fs = FileSystem.createInstanceOfFileSystem();
	}
	
	public void testFile(){
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
		
	}
}
