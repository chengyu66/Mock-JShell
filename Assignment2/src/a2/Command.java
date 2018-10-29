package a2;

import java.util.Arrays;

public class Command {
  
  public static FileSystem fs;
  private String[] validCommands = {"exit", "mkdir", "cd", "ls", "pwd", "pushd",
      "popd", "history", "cat", "echo", "man"};

  public Command(FileSystem fs) {
    Command.fs = fs;
  }

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
