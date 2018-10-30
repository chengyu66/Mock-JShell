package a2;


public class Ls extends Command{
  
  public Ls(FileSystem fs) {
    super(fs);
  }
  
  public void run(String[] input) {
    String output = "";
    if (input.length == 1) {
      for (FileDirectory fd: fs.getCurrentDirectory().getSub()) {
        output += fd.getName() + "   ";
      }
      System.out.println(output.trim());
    } else if(input.length == 2) {
      // if input path
      // need trace
    } else {
      System.out.println(super.errorMessage());
      System.out.println(errorMessage());
    }
  }
  
  public String errorMessage() {
    return "correct format of Command ls: ls [PATH]";
  }
}
