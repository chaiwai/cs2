// info

// GenericsBST.java
// ========
// Basic binary search tree (BST) implementation that supports insert() and
// delete() operations. This framework is provide for you to modify as part of
// Programming Assignment #2.


import java.io.*;
import java.util.*;

// a binary search tree node class that holds any data type
class Node<AnyType>
{
	AnyType data;
	Node<AnyType> left, right;
	
	//sets the data field to "data"
	Node(AnyType data)
	{
		this.data = data;
	}
}

// a binary search tree class that will hold any data type
public class GenericBST<AnyType extends Comparable<AnyType>>
{
	// come back to this //
	private Node<AnyType> root;

	// inserts the root node
	// then calls a method to insert nodes
	public void insert(AnyType data)
	{
		root = insert(root, data);
	}

	// bst insertion method:
	// determines recursively if a node should go to 
	// the left or right
	private Node<AnyType> insert(Node<AnyType> root, AnyType data)
	{
		// if the bst is empty, a root node is set
		if (root == null)
		{
			//instantiates a new node with data
			return new Node(data);
		}
		// if the new node is <, it is placed to the left
		else if (data.compareTo(root.data) < 0 )
		{
			root.left = insert(root.left, data);
		}
		// if the new node is >, it is placed to the right
		else if (data.compareTo(root.data) > 0 )
		{
			root.right = insert(root.right, data);
		}
		else
		{
			// Stylistically, I have this here to explicitly state that we are
			// disallowing insertion of duplicate values. This is unconventional.
			// and it's fancy :)
			;
		}

		// not sure yet
		return root;
	}

	// method for removing nodes
	public void delete(AnyType data)
	{
		root = delete(root, data);
	}

	// recursively determines how to reorganize the bst
	// after a node is deleted
	private Node delete(Node root, AnyType data)
	{
		// returns null if the bst is empty
		if (root == null)
		{
			return null;
		}
		// deletes to the left if data is < the current node
		else if (data < root.data)
		{
			root.left = delete(root.left, data);
		}
		// deletes to the right if data is > the current node
		else if (data > root.data)
		{
			root.right = delete(root.right, data);
		}
		// instructions when the program reaches the end of a bst
		else
		{	
			// when a node has no child, return null
			if (root.left == null && root.right == null)
			{
				return null;
			}
			// return the lhs if the rhs is null
			else if (root.right == null)
			{
				return root.left;
			}
			// return the rhs if the lhs is null
			else if (root.left == null)
			{
				return root.right;
			}
			// finds the right-most node on the left node
			// then sets that data, then deletes the left 
			else
			{
				root.data = findMax(root.left);
				root.left = delete(root.left, root.data);
			}
		}

		return root;
	}

	// This method assumes root is non-null, since this is only called by
	// delete() on the left subtree, and only when that subtree is non-empty.
	private AnyType findMax(Node root)
	{
		while (root.right != null)
		{
			// keeps moving to the right node until the right node is null
			root = root.right;
		}

		return root.data;
	}

	// Returns true if the value is contained in the BST, false otherwise.
	public boolean contains(AnyType data)
	{
		return contains(root, data);
	}
	
	// recursively checks for values on both sides of a node
	private boolean contains(Node root, AnyType data)
	{
		if (root == null)
		{
			return false;
		}
		else if (data < root.data)
		{
			return contains(root.left, data);
		}
		else if (data > root.data)
		{
			return contains(root.right, data);
		}
		else
		{
			return true;
		}
	}

	public void inorder()
	{
		// header line
		System.out.print("In-order Traversal:");
		inorder(root);
		System.out.println();
	}

	// recursively looks for node values and prints in inorder
	private void inorder(Node root)
	{
		// returns if bst is empty
		if (root == null)
			return;

		// checks left, prints, checks right
		inorder(root.left);
		System.out.print(" " + root.data);
		inorder(root.right);
	}

	public void preorder()
	{
		System.out.print("Pre-order Traversal:");
		preorder(root);
		System.out.println();
	}

	private void preorder(Node root)
	{
		//returns if root is empty
		if (root == null)
			return;

		// prints, checks left, then checks right
		System.out.print(" " + root.data);
		preorder(root.left);
		preorder(root.right);
	}

	public void postorder()
	{
		System.out.print("Post-order Traversal:");
		postorder(root);
		System.out.println();
	}

	private void postorder(Node root)
	{
		// returns if bst is empty
		if (root == null)
			return;

		// checks left, checks right, then prints
		postorder(root.left);
		postorder(root.right);
		System.out.print(" " + root.data);
	}
	
	// method for gathering course feedback?
	public static double difficultyRating()
	{
		return 2.5;
	}
	
	public static double hoursSpent()
	{
		return 2.0;
	}

	public static void main(String [] args)
	{
		GenericBST myTree = new GenericBST();

		// inserts 5 random integers from [1,100] into the bst
		for (int i = 0; i < 5; i++)
		{
			int r = (int)(Math.random() * 100) + 1;
			System.out.println("Inserting " + r + "...");
			myTree.insert(r);
		}

		// calls 3 different methods for 3 different bst traversals
		myTree.inorder();
		myTree.preorder();
		myTree.postorder();
	}
}
