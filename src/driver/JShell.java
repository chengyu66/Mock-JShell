// **********************************************************
// Assignment2:
// Student1:
// UTORID user_name:xincheng
// UT Student #:1004068518
// Author:Chengyu Xin
//
// Student2: 
// UTORID user_name: mihao
// UT Student #: 1004418203
// Author: Hao Mi
//
// Student3:
// UTORID user_name: wangy809
// UT Student #: 1004042617
// Author: Yunfei Wang
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
import a2.*;

public class JShell {

  private boolean terminate;
  private Map<String, Command> map;
  private FileSystem fs;
  private Command com;
  private PrintDirectory pwd;
  private Mkdir mkdir;
  private ChangeDirectory cd;
  private History history;
  private Ls ls;

  JShell() {
    terminate = false;
    fs = new FileSystem("Windows");
    // for testing, create FileSystem to test pwd,cd
    Directory a = fs.getRoot();
    a.setSub(new Directory("user",a));
    Directory b = (Directory)a.getSub().get(0);
    b.setSub(new Directory("Application",b));
    b.setSub(new Directory("Desktop",b));
    Directory c = (Directory)b.getSub().get(0);
    c.setSub(new Directory("Music",c));
    
    
    com = new Command(fs);
    pwd = new PrintDirectory(fs);
    cd = new ChangeDirectory(fs);
    mkdir = new Mkdir(fs);
    ls = new Ls(fs);
    history = new History(fs);
    map = new HashMap<String, Command>();
    map.put("pwd", pwd);
    map.put("mkdir", mkdir);
    map.put("cd", cd);
    map.put("ls", ls);
    map.put("history", history);
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
        history.addHistory(input);
        (map.get(input[0])).run(input);
      }
    } else {
      history.addHistory(input);
      System.out.println(input[0] + ": command not found");
    }
  }
}
