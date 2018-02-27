package util;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface,StdoutDisplayInterface{

	ArrayList<String> result;
	FileWriter fw = null;
	BufferedWriter bw = null;

	public Results()
	{
		result = new ArrayList<String> ();
	}

	public void storeNewResult(String s)
	{
		result.add(s);
	}


	//@Override
	public void writeToStdout()
	{
		for(int i=0 ;i<result.size();i++)
		{
			System.out.println(result.get(i));
		}
	}

	//@Override
	public void writeToFile(String s1)
	{
		try
		{
			fw = new FileWriter(s1);
			bw = new BufferedWriter(fw);
			for(int i=0;i<result.size();i++)
			{
					bw.write(result.get(i));
					bw.write("\n");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bw.close();
				fw.close();
			}
			catch(IOException e)
			{e.printStackTrace();}
		}
	}	
}
