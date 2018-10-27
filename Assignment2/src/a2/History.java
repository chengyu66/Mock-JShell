package a2;

import java.util.ArrayList;

public class History {
	private ArrayList<String> historyList;

	public History()
	{
		historyList = new ArrayList<String>();
	}
	
	public void addHistory(String newHistory)
	{
		historyList.add((historyList.size()+1)+ ". " + newHistory);
	}
	
	public void printHistory(int numbLine)
	{
		for (int i = numbLine;i<historyList.size(); i++)
		{
			System.out.println(historyList.get(i));
		}
	}
}
