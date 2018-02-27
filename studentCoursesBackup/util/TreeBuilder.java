package util;

import myTree.Node;
import util.Results;
//import java.util.*;

//http://homepage.divms.uiowa.edu/~sriram/21/spring07/code/tree.java
public class TreeBuilder{

	private Node root,root1,root2;

	public TreeBuilder()
	{
		root = null;
	}


	//search method
	public Node search(int number)
	{
		Node current = root;
		while(current != null && current.BNumber != number)
		{
			if(number < current.BNumber)
			{
				current = current.left;
			}
		        else
			{
				current = current.right;
			}
		
		}
      		return current;
	}


	//insert method
	public void insert(int number,String name)
	{
		Node node_orig,backup_Node_1,backup_Node_2;
		node_orig = search(number);
		
		if(node_orig == null)
		{
			node_orig = new Node();

			node_orig.BNumber = number;
			node_orig.names.add(name);

			try{
				node_orig.backup_Node_1 = (Node)node_orig.clone();
				node_orig.backup_Node_2 = (Node)node_orig.clone();

			}
			catch(CloneNotSupportedException e)
			{
				
			}
		
			if(root==null)
			{
				root = node_orig;
				root1 = node_orig.backup_Node_1;
				root2 = node_orig.backup_Node_2;
			}
			else
			{
				insertNode(root,node_orig);
				insertNode(root1,node_orig.backup_Node_1);
				insertNode(root2,node_orig.backup_Node_2);
			}
		}
		else
		{
			//insert subject if it is not already in arraylist of BNumber
			if(!node_orig.names.contains(name))
			{
				node_orig.names.add(name);
				
				node_orig.backup_Node_1.names.add(name);
				node_orig.backup_Node_2.names.add(name);
			}
		}

	}

	// this method insert a node at proper location
	public void insertNode(Node root, Node currentNode)
	{

		Node current = root;
        	Node parent;
		int number = currentNode.BNumber;
        	while(true)
        	{
			parent = current;
			//if cuurentNode BNumber is < parent node's BNumber, it moves to left
			if(number < current.BNumber)
			{
				current = current.left;
				if(current == null)
                		{
                			parent.left = currentNode;
                			return;
                		}
               		}
           		else //else go for right
			{
				current = current.right;
				if(current == null)
                		{
                			parent.right = currentNode;
                			return;
                		}
               		}
           	}
         }


	public boolean delete(int number, String course)
	{

		// search for the node
		Node delNode = search(number);

		//if node not found, return
		if(delNode == null)
		{}

		//else check for subject, if it is in arraylist, remove it
		else
		{
			if(delNode.names.contains(course))
			{

				delNode.names.remove(course);
				delNode.notifyAll(number,course);
			}
		}
		
		return true;
	}


	// printNodes function
	public void printNodes(String type, Results result)
	{

		// by identifying a type of the node, it calls print_Node function
		switch(type)
		{
			case "original": print_Node(this.root,result);break;
			case "backup1": print_Node(this.root1,result);break;
			case "backup2": print_Node(this.root2,result);break;
		}
	}


	//print_Node function, recursively call itself until reach to the left node then store result and recursively call itself until visit all node
	public void print_Node(Node currentNode,Results result)
	{
		if(currentNode == null)
		return;

		if(currentNode.left != null)
		{print_Node(currentNode.left,result);}

		result.storeNewResult(currentNode.BNumber+" "+currentNode.names);

		if(currentNode.right != null)
		{print_Node(currentNode.right,result);}
	}

}
