package a2;

public class Exit extends Command {
  public String run() {
    // terminates Shell
    System.exit(0);
    return "";
  }
}
