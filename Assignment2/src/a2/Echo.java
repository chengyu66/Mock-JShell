package a2;


public class Echo extends Command{
	public Echo(FileSystem fs)
	{
		super(fs);
	}
	
	public File setOraddContent(File file, String content, String input){
		if (input.equals(">"))
			file.setContent(content);
		else
			file.addContent(content);
		
		return file;
	}
	public void run(String [] input){
		File currFile = null;
		Directory currDirect = null;
		String fileName = "";

		//Case 1: only STRING in input
		if (input.length == 2)
			System.out.println(input[1]);
		//Case 2: String and OutFile in input
		else if (input.length == 4 && (input[2].equals(">")||input[2].equals(">>"))){
			fileName = input[3].split("/")[input[3].split("/").length-1];
			//Case 2.1£º OutFile is a path
			if (input[3].contains("/")){
				currFile = (File) fs.trace(input[3]);
				//Case 2.1.1: file does not exit in OutFile
				if (currFile == null){
					currDirect = (Directory)fs.trace(input[3].replace("/"+fileName,""));
					//Case 2.1.1.1: the directory holds the file does not exist in OutFile
					if (currDirect == null){
						//Raise Error
					}
					//Case 2.1.1.2: the directory holds the file exists in OutFile
					else{
						currFile = new File(fileName, currDirect);
						currFile = setOraddContent(currFile, input[1], input[2]);
						currDirect.setSub(currFile);
					}
				}
				//Case 2.1.2: file exit in OutFile
				else{
					currFile = setOraddContent(currFile, input[1], input[2]);
				}
			}
			//Case 2.2: OutFile is a name
			else{
				currDirect = fs.getCurrentDirectory();
				currFile = new File(fileName, currDirect);
				currFile = setOraddContent(currFile, input[1], input[2]);
				currDirect.setSub(currFile);
			}
		}
	}
}
