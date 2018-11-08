package a2;
/**
 * PrintDirectory class is a command that used to run pwd
 * command.
 * 
 * @param fs is a filesystem that has been constructed
 * @return return none
 */
public class Pwd extends Command {

  public Pwd(FileSystem fs) {
    super(fs);
  }
  /**
   * run method return none and print the current full path
   * 
   * @param input is a string input list split by "/"
   * @return return None
   */
  public void run(String[] input) {
    // print the current directory with its string
    System.out.println(fs.getCurrentDirectory());
  }
}
