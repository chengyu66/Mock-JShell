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
      String path = input[1]; 
      FileDirectory fd = fs.trace(path);
      if (fd instanceof File) {
        System.out.println(((File) fd).getContent());
      } else if (fd instanceof Directory) {
        String contents = "";
        for (FileDirectory fdContents: ((Directory) fd).getSub()) {
          contents += fdContents.getName() + "   ";
        }
        System.out.println(fd.getName() + ": " + contents.trim());
      } else {
        System.out.println("No such file or directory");
      }
    } else {
      System.out.println(super.errorMessage());
      System.out.println(errorMessage());
    }
  }
  
  public String errorMessage() {
    return "correct format of Command ls: ls [PATH]";
  }
}
