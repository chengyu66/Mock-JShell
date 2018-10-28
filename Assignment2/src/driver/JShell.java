// **********************************************************
// Assignment2:
// Student1:
// UTORID user_name:xincheng
// UT Student #:1004068518
// Author:Chengyu Xin
//
// Student2:
// UTORID user_name:
// UT Student #:
// Author:
//
// Student3:
// UTORID user_name:
// UT Student #:
// Author:
//
// Student4:
// UTORID user_name:
// UT Student #:
// Author:
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package driver;

import java.util.Arrays;// for testing
import java.util.Scanner;
import a2.Exit;

public class JShell {

  private static boolean terminate = false;
  Exit exit;

  JShell() {
    exit = new Exit();
  }

  public static void main(String[] args) {
    JShell jShell = new JShell();
    while (!terminate) {
      System.out.print("/#: ");
      Scanner in = new Scanner(System.in);
      String userInput = in.nextLine().trim();
      String input[] = userInput.split("\\s+");
      // for testing, delete this after!!!
      System.out.println(Arrays.toString(input));
      jShell.execute(userInput, input);
    }
  }

  public void execute(String userInput, String[] input) {
    if (input[0].equals("exit")) {
      terminate = true;
      exit.run();
    /*} else if (input[0].equals("mkdir")) {
      mkdir.run();
    } else if (input[0].equals("cd")) {
      cd.run();
    } else if (input[0].equals("ls")) {
      ls.run();
    } else if (input[0].equals("pwd")) {
      pwd.run();
    } else if (input[0].equals("pushd")) {
      pushd.run();
    } else if (input[0].equals("popd")) {
      popd.run();
    } else if (input[0].equals("history")) {
      history.run();
    } else if (input[0].equals("cat")) {
      cat.run();
    } else if (input[0].equals("echo")) {
      echo.run();
    } else if (input[0].equals("man")) {
      man.run();
    */} else {
      System.out.println(input[0] + ": command not found");
    }
  }

}
