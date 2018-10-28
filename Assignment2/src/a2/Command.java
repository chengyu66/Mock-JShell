package a2;

public class Command {
  public String fpart;
  public String spart;
  
  private static String[] validCommands =
    {"exit", "mkdir", "cd", "is", "pwd", "pushd", "popd", "history", "cat",
        "echo", "man"};
  
  public Command(String input) {
    String[] my_list = input.split(" ");
    fpart = my_list[0];
    if(this.isValid(input)){
      this.run(fpart);
    }
  }
  
  public String[] getValidCommands() {
    return validCommands;
  }
  
  // every subclass of Command should override this method
  public void run(String cmd) {
    if(cmd == "cd") {
      a2.ChangeDirectory c = new ChangeDirectory(cmd);
    }
    // other cases writing here
  }
  
  public boolean isValid(String input) {
    boolean result = false;
    if(fpart.isEmpty()) {
      result = false;
    } else {
      for(String str:validCommands) {
        if(str == fpart) {
          result = true;
        }
      }
      result = true;
    }
    return result;
  }
}
