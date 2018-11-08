package a2;

/**
 * Determines how similar each pair of users is based on their ratings. This
 * similarity value is represented with with a float value between 0 and 1,
 * where 1 is perfect/identical similarity. Stores these values in the
 * userUserMatrix.
 * 
 * @param items1 is the column of the first user.
 * @param items2 is the column of the second user.
 * @return return a double represents the distance between users.
 */
public class Echo extends Command{
	public Echo(FileSystem fs)
	{
		super(fs);
	}
	
	public File setOraddContent(File file, String content, String input){
		content = content.substring(1, content.length()-1);
		if (input.equals(">"))
			file.setContent(content);
		else
			file.addContent(content);
		
		return file;
	}
	
	public boolean correctForm(String [] input){
		boolean correct = true;

		if (input.length == 1 || input.length > 4)
			correct = false;
		else{
			correct = (input[1].charAt(0) == '\"' && input[1].charAt(input[1].length()-1) == '\"');
			
			if(input.length == 4)
				correct = correct && validName(input[3].split("/")[input[3].split("/").length-1]) && (input[2].equals(">") || input[2].equals(">>"));
		}
		
		return correct;
	}

	public void run(String [] input){
		File currFile = null;
		Directory currDirect = null;
		String fileName = "";
		
		if(correctForm(input)){
			if (input.length == 2)
				System.out.println(input[1]);
			else{
				fileName = input[3].split("/")[input[3].split("/").length-1];
				//Case 2.1�� OutFile is a path
				try{
					currFile = (File) fs.trace(input[3]);
				}
				catch(Exception e){
					currFile = null;
				}
				//Case 2.1.1: file does not exit in OutFile
				if (currFile == null){
					if (input[3].contains("/"))
						try{
							currDirect = (Directory)fs.trace(input[3].replace("/"+fileName,""));
						}
						catch(Exception e){
							currFile = null;
						}
					else
						currDirect = fs.getCurrentDirectory();

					//Case 2.1.1.1: the directory holds the file does not exist in OutFile
					if (currDirect == null){
						System.out.println("The directory does not exist.");
					}
					//Case 2.1.1.2: the directory holds the file exists in OutFile
					else{
						if (currDirect.subExist(fileName)){
							System.out.println("Some Files or Directories already exist");
						}
						else{
							currFile = new File(fileName, currDirect);
							currFile = setOraddContent(currFile, input[1], input[2]);
							currDirect.setSub(currFile);
						}
					}
				}
				//Case 2.1.2: file exit in OutFile
				else
					currFile = setOraddContent(currFile, input[1], input[2]);
			}
		}
		else
			System.out.println(super.errorMessage());
	}
}

