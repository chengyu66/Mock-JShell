package a2;

public class Mkdir extends Command {
  
  public Mkdir(FileSystem fs) {
    super(fs);
  }
  
  public void run(String[] input) {
    if (input.length == 2) {
      if (input[1].contains("/")) {
        //
      } else {
        Directory newDirectory = new Directory(input[1],
            fs.getCurrentDirectory());
        (fs.getCurrentDirectory()).setSub(newDirectory);
      }
    } else {
      // wrong input
    }
  }
}
