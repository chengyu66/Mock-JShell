package a2;

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
		for (int i = Integer.parseInt(input[1]);i<historyList.size(); i++)
		{
			System.out.println(historyList.get(i));
		}
	}
}
