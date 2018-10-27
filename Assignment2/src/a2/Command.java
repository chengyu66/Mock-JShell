package a2;

public class Command {
  
  private static String[] validCommands =
    {"exit", "mkdir", "cd", "is", "pwd", "pushd", "popd", "history", "cat",
        "echo", "man"};
  
  public Command() {
    
  }
  
  public String[] getValidCommands() {
    return validCommands;
  }
  
  public String run() {
    return "";
  }
}
