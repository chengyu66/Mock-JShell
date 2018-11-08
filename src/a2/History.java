package a2;
/**
 * Determines how similar each pair of users is based on their ratings. This
 * similarity value is represented with with a float value between 0 and 1,
 * where 1 is perfect/identical similarity. Stores these values in the
 * userUserMatrix.
 * 
 * @param items1 is the column of the first user.
 * @param items2 is the column of the second user.
 * @return return a double represents the distance between users.
 */
import java.util.ArrayList;

public class History extends Command{
	private ArrayList<String> historyList;

	public History(FileSystem fs)
	{
		super(fs);
		historyList = new ArrayList<String>();
	}
	
	public void addHistory(String [] newHistory)
	{
		historyList.add((historyList.size()+1)+ ". " + String.join(" ", newHistory));
	}
	
	public void run(String [] input)
	{
		int numbHistory = -1;
		
		if (input.length == 2 && input[1].matches(".*\\d+.*"))
			numbHistory = Integer.parseInt(input[1]);
		else if (input.length == 1)
			numbHistory = 0;
		
		if (numbHistory >= 0){
			for (int i = numbHistory;i<historyList.size(); i++)
	        {
	            System.out.println(historyList.get(i));
	        }
		}
		else{
			System.out.println(super.errorMessage());
		    System.out.println(errorMessage());
		}
	}
	
	public String errorMessage() {
	    return "correct format of Command history: history [number]";
	  }
}
