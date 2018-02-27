package myTree;

import java.util.ArrayList;
import util.Results;

public class Node implements SubjectI, ObserverI, Cloneable{

	// Declaration of variables and backup nodes
	public int BNumber;
	public ArrayList<String> names = new ArrayList<String>();

	public Node left;
	public Node right;

	public Node backup_Node_1;
	public Node backup_Node_2;


	//override clone method
	//@override
	public Object clone() throws CloneNotSupportedException{
		
		Node n1 = (Node) super.clone();
		n1.names =(ArrayList<String>)names.clone();
		return n1;

	}

	//notify all and update method
	public void notifyAll(int number, String course)
	{
		backup_Node_1.update(number,course);
		backup_Node_2.update(number,course);	
	}

	public void update(int number, String subject)
	{
		this.names.remove(subject);
	}

}
