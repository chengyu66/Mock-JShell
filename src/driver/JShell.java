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

// import what we need
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import a2.*;

public class JShell {

  // a boolean variable to control the status of JShell
  private boolean terminate;
  // a dictionary that maps String as key to Command as value
  private Map<String, Command> map;
  private FileSystem fs;
  private PrintDirectory pwd;
  private Mkdir mkdir;
  private ChangeDirectory cd;
  private History history;
  private Ls ls;
  private Echo echo;
  private Cat cat;

  // constructor
  JShell() {
    // JShell will be closed when terminate is true
    terminate = false;
    // create a FileSystem with SingletonDesignPattern
    fs = FileSystem.createInstanceOfFileSystem();
    // for testing, delete this after!!!!!
    Directory a = fs.getRoot();
    a.setSub(new Directory("user",a));
    Directory b = (Directory)a.getSub().get(0);
    b.setSub(new Directory("Application",b));
    b.setSub(new Directory("Desktop",b));
    File juben = new File("juben.txt", b);
    b.setSub(juben);
    Directory c = (Directory)b.getSub().get(0);
    File music = new File("Music.txt", c);
    c.setSub(music);
    music.setContent("DreamTeam");
    
    
    // creating command objects
    pwd = new PrintDirectory(fs);
    cd = new ChangeDirectory(fs);
    mkdir = new Mkdir(fs);
    ls = new Ls(fs);
    history = new History(fs);
    echo = new Echo(fs);
    cat = new Cat(fs);
    // create the dictionary that maps String as key to Command as value
    map = new HashMap<String, Command>();
    // put corresponding Command by String
    map.put("pwd", pwd);
    map.put("mkdir", mkdir);
    map.put("cd", cd);
    map.put("ls", ls);
    map.put("history", history);
    map.put("echo", echo);
    map.put("cat", cat);
  }

  // main class of JShell
  public static void main(String[] args) {
    // Generates a JShell object
    JShell jShell = new JShell();
    // create a scanner for user inputs
    Scanner in = new Scanner(System.in);
    // keep running until terminate is true
    while (!jShell.terminate) {
      // print statement to ask for user's input
      System.out.print("/#: ");
      // trim the extra spaces at the start and end of user input
      String userInput = in.nextLine().trim();
      // turns user input into array's element by spaces between
      String input[] = userInput.split("\\s+");
      // execute the input
      jShell.execute(input);
    }
    // close the scanner
    in.close();
  }

  private void execute(String[] input) {
    // save the first word of user input
    String command = input[0];
    // check if the first word is a valid command
    if (isCommandValid(command)) {
      // if the command is exit
      if (command.equals("exit")) {
        // change the state of terminate to close JShell
        terminate = true;
      // else execute the command
      } else {
        // save the command in history
        history.addHistory(input);
        // execute the corresponding command by user input
        (map.get(input[0])).run(input);
      }
    // else it is not a valid command
    } else {
      // save the input in history
      history.addHistory(input);
      // print the message
      System.out.println(input[0] + ": command not found");
    }
  }
  
  private boolean isCommandValid(String command) {
    boolean result = false;
    if (map.keySet().contains(command)) {
      result = true;
    }
    return result;
  }
}
