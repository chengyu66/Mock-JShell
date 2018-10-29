package a2;

import java.util.Arrays;

public class Command {

  private String[] validCommands = {"exit", "mkdir", "cd", "is", "pwd", "pushd",
      "popd", "history", "cat", "echo", "man"};

  public Command() {}

  // Every subClass should override this method
  public void run(String[] input) {}

  public boolean isValid(String command) {
    boolean result = false;
    if (Arrays.asList(validCommands).contains(command)) {
      result = true;
    }
    return result;
  }
}
