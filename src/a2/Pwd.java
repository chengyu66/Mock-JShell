package a2;

public class Pwd extends Command {

  public Pwd(FileSystem fs) {
    super(fs);
  }

  public void run(String[] input) {
    System.out.println(fs.getCurrentDirectory());
  }
}
