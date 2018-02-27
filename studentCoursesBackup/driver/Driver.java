package studentCoursesBackup.driver;

import myTree.Node;
import util.FileProcessor;
import util.TreeBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import util.Results;

public class Driver{

	public static void main(String[] args)
	{
		FileProcessor fp1 = new FileProcessor(args[0]);
		FileProcessor fp2 = new FileProcessor(args[1]);
		TreeBuilder tb = new TreeBuilder();


		String s1,s2;
		while((s1 = fp1.readLine()) != null)
		{
			String[] temp = s1.split(":");
			tb.insert(Integer.parseInt(temp[0]),temp[1]);
		}

		while((s2 = fp2.readLine()) != null)
		{
			String[] temp = s2.split(":");
			tb.delete(Integer.parseInt(temp[0]),temp[1]);
		}

		Results r1 = new Results();
		Results r2 = new Results();
		Results r3 = new Results();
		System.out.println("original node");
		tb.printNodes("original",r1);
		r1.writeToStdout();
		r1.writeToFile(args[2]);

		System.out.println("Backup Node 1");		
		tb.printNodes("backup1",r2);
		r2.writeToStdout();
		r2.writeToFile(args[3]);

		System.out.println("Backup Node 2");
		tb.printNodes("backup2",r3);
		r3.writeToStdout();
		r3.writeToFile(args[4]);

	}
}
