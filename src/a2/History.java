package a2;

import java.util.ArrayList;

/**
 * The class collects the recent command in Jshell and print the history.
 */
public class History extends Command {
  private ArrayList<String> historyList;

  /**
   * the constructor of History initialize the historyList.
   * 
   * @param input a String array of user input without space
   * @return return None
   */
  public History(FileSystem fs) {
    super(fs);
    historyList = new ArrayList<String>();
  }

  /**
   * add a new history in the class
   * 
   * @param input a String array of hisotry without space
   * @return return None
   */
  public void addHistory(String[] newHistory) {
    historyList
        .add((historyList.size() + 1) + ". " + String.join(" ", newHistory));
  }

  /**
   * Run the command and output the recent history by the giving path
   * 
   * @param input a String array of user input without space
   * @return return None
   */
  public void run(String[] input) {
    int numbHistory = -1;

    if (input.length == 2 && input[1].matches(".*\\d+.*"))
      numbHistory = Integer.parseInt(input[1]);
    else if (input.length == 1)
      numbHistory = 0;

    if (numbHistory >= 0) {
      for (int i = numbHistory; i < historyList.size(); i++) {
        System.out.println(historyList.get(i));
      }
    } else {
      System.out.println(super.errorMessage());
      System.out.println(errorMessage());
    }
  }

  public String errorMessage() {
    return "correct format of Command history: history [number]";
  }
}
