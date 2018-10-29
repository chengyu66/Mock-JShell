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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import a2.Command;
//import a2.Exit;

public class JShell {

  private boolean terminate;
  Map<String, Command> map;
  Command com;
  //Exit exit;

  JShell() {
    terminate = false;
    com = new Command();
    //exit = new Exit();
    map = new HashMap<String, Command>();
    //map.put("exit", exit);
  }

  public static void main(String[] args) {
    JShell jShell = new JShell();
    Scanner in = new Scanner(System.in);
    while (!jShell.terminate) {
      System.out.print("/#: ");
      String userInput = in.nextLine().trim();
      String input[] = userInput.split("\\s+");
      // for testing, delete this after!!!
      System.out.println(Arrays.toString(input));
      jShell.execute(input);
    }
    in.close();
  }

  public void execute(String[] input) {
    String command = input[0];
    if (com.isValid(command)) {
      if (command.equals("exit")) {
        terminate = true;
      } else {
        (map.get(input[0])).run(input);
      }
    } else {
      System.out.println(input[0] + ": command not found");
    }
  }
}
