package a2;

import java.util.HashMap;
import java.util.Map;

/**
 * Documentaiton that store the table contains Command strings maps
 * to its Documentation
 * 
 * @param map is a hashmap that map Command strings to Documentations
 * @return return None
 */
public class Documentation{
  private Map<String, String> map;
  public Documentation(){
    // set new hashtable
    this.map = new HashMap<String, String>();
    // map all command strings to its documentation
    map.put("exit", "Input format: exit \n quit the program")
    map.put("pwd", "Input format: pwd \n Print the current directory");
    map.put("mkdir", "Input format: mkdir <DIR...> \n Create a new directories,"
            + " each of which may be relative to current directory or may be "
            + "a full path. It may create multiple directories at the same time");
    map.put("cd", "Input format: cd DIR \n Change directory to DIR, which may "
            + "be relative to the current directory or may be a full path.");
    map.put("ls", "If no paths are given, print the contents (file or directory) of the current\n" + 
            "directory, with a new line following each of the content "
            + "(file or directory).Otherwise, for each path p, the order listed:\n" + 
            "If p specifies a file, print p\n" + 
            "If p specifies a directory, print p, a colon, then the contents of that\n" + 
            "directory, then an extra new line.\n" + 
            "If p does not exist, print a suitable message.");
    map.put("history", "This command will print out recent commands, one command per line. i.e.\n" + 
            "1. cd ..\n" + 
            "2. mkdir textFolder\n" + 
            "3. echo Hello World\n" + 
            "4. fsjhdfks\n" + 
            "5. history\n" + 
            "The above output from history has two columns. The first column is\n" + 
            "numbered such that the line with the highest number is the most recent\n" + 
            "command. The most recent command is history. The second column contains\n" + 
            "the actual command. Note: Your output should also contain as output any\n" + 
            "syntactical errors typed by the user as seen on line 4.\n" + 
            "We can truncate the output by specifying a number (>=0) after the\n" + 
            "command. For instance, if we want to only see the last 3 commands typed, we\n" + 
            "can type the following on the command line:\n" + 
            "history 3\n" + 
            "And the output will be as follows:\n" + 
            "4. fsjhdfks\n" + 
            "5. history\n" + 
            "6. history 3");
    map.put("echo", "Case 1: \n Input format: echo String[>OUTFILE]. \n If OUTFILE is not provided, print STRING on the shell. Otherwise, put\n" + 
            "STRING into file OUTFILE. STRING is a string of characters surrounded\n" + 
            "by double quotation marks. This creates a new file if OUTFILE does not exists\n" + 
            "and erases the old contents if OUTFILE already exists. In either case, the only\n" + 
            "thing in OUTFILE should be STRING. \n\n"
            + "Case 2: \n echo String >> OUTFILE. \n appends instead of overwrites");
    map.put("pushd", "Input format: popd \n Saves the current working directory by pushing onto directory stack and\n" + 
            "then changes the new current working directory to DIR. The push must be\n" + 
            "consistent as per the LIFO behavior of a stack. The pushd command\n" + 
            "saves the old current working directory in directory stack so that it can be\n" + 
            "returned to at any time (via the popd command). The size of the directory\n" + 
            "stack is dynamic and dependent on the pushd and the popd commands.");
    map.put("popd", "Remove the top entry from the directory stack, and cd into it. The removal\n" + 
            "must be consistent as per the LIFO behavior of a stack. The popd\n" + 
            "command removes the top most directory from the directory stack and\n" + 
            "makes it the current working directory. If there is no directory onto the\n" + 
            "stack, then give appropriate error message.");
    map.put("cat", "Input format: cat File1 [File2 ...] \n Display the contents of FILE1 and other files (i.e. File2 ��.) concatenated\n" + 
            "in the shell. You may want to use three line breaks to separate the contents of\n" + 
            "one file from the other file.");
    map.put("man", "Input format: man CMD \n Print documentation for CMD");
    
  }
  /**
   * Get the hash map that contain all command strings and documentations
   * 
   * @return return a hashmap contain all documentations
   */
  public Map<String, String> getMap() {
    return map;
  }
  /**
   * method that set the map with hashmap of command string
   * and its documentation
   * 
   * @param map is a hashmap that map Command strings to Documentations
   * @return return None
   */
  public void setMap(Map<String, String> map) {
    this.map = map;
  }
  

}
