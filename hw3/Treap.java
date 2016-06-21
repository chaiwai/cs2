// info

/* indicates comments from program requirements */

// indicates comments from the coder

/* Implement the probabilistic Treap data structure. It is important that you implement the insertion and deletion operations as described in class. (In particular, be sure to read my note in Webcourses on how deletion is handled, which includes a discussion of how this differs from our traditional approach to BST deletion.) Your Treap class must be generic. Since there is an ordering property in treaps, you must also restrict the type parameter (e.g., AnyType) to classes that implement Comparable. */

import java.util.*;
import java.lang.Math;

class Node<T>
{
	T data;
	Node<T> left, right;
	int priority;
	
	Node(T data, int priority)
	{
		this.data = data;
		this.priority = priority;
	}
}

public class Treap<T extends Comparable<T>>
{
	private int size = 0;
	private Node<T> root;
	
	// stores treap priority values in a hashset
	HashSet<Integer> prioritySet;
	
	public Treap()
	{
		prioritySet = new HashSet<Integer>();
	}
	
	/* Add data to the treap. Do not allow insertion of duplicate values. You will have to generate a
	random priority for this node. Find an efficient way to ensure that no duplicate priorities are
	generated, which uses no more than O(n) extra memory. */
	
	// adds data to the treap. no else statement ensures no duplicate values
	public void add(T data)
	{
		if (!contains(root, data))
		{
			int priority = getPriority();
			root = add(root, data, priority);
		}
	}
	
	/* Insert data into the treap (as above), but do not generate a random node priority for the new
	node. Instead, let the programmer (me) pass the priority as a parameter. I’ll use this to test 		your code with my own sequence of not-so-random priorities. */
	
	public void add(T data, int priority)
	{
		if (!contains(root, data))
			root = add(root, data, priority);
	}
	
	private Node<T> add(Node<T> root, T data, int priority)
	{
		// if the treap is empty, a root node is set
		if (root == null)
		{
			// instantiates a new node with data after incrementing treap size
			this.size++;
			return new Node<T> (data, priority);
		}
		
		// if the new node is <, it is placed to the left using the compareTo method
		// if data is less than root.data it will return a negative #
		else if (data.compareTo(root.data) < 0 )
		{
			root.left = add(root.left, data, priority);
			
			// rotation of priority to maintain heapiness
			if (root.left.priority < root.priority)
			{
				Node<T> child = root.left;
				root.left = child.right;
				child.right = root;
				root = child;
			}
		}
		// if the new node is >, it is placed to the right
		else if (data.compareTo(root.data) > 0 )
		{
			root.right = add(root.right, data, priority);
			
			// rotation of priority to maintain heapiness
			if (root.right.priority < root.priority)
			{
				Node<T> child = root.right;
				root.right = child.left;
				child.left = root;
				root = child;
			}

		}
		else
		{
			// this disallows duplicates
			;
		}

		return root;
	}
	
	/* Delete data from the treap (if it is present). */
	public void remove(T data)
	{	
		// no else statement will disregard values not in the treap
		if (contains(root, data))
			root = remove(root, data);
	}
	
	// nightmare method
	private Node<T> remove(Node<T> root, T data)
	{
		if (root == null)
			return null;
		
		// first step is to look for the node
		// recursively search through branches
		else if (data.compareTo(root.data) < 0)
			root.left = remove(root.left, data);
		else if (data.compareTo(root.data) > 0)
			root.right = remove(root.right, data);
		
		// this else statement assumes the value is equal
		// which means we found the node to delete
		else
		{
			if (root.left == null)
				return null;
			
			else if (root.right == null)
				return null;
			
			// if both sides are null, then the node is a leaf node
			// which means it can be removed after decrementing the size
			// and removing the priority value
			else if (root.left == null && root.right == null)
			{
				prioritySet.remove(root.priority);
				size--;
				return null;
			}
			
			// if the node has two children
			else
			{
				//priority rotations
				return null;
			}
			
		}
		
		return null;
	}
	
	/* Return true if the treap contains data, false otherwise. */
	public boolean contains(T data)
	{
		return contains(root, data);
	}
	
	private boolean contains(Node<T> root, T data)
	{
		if (root == null)
			return false;
		
		// if data is less than root.data, look left
		else if (data.compareTo(root.data) < 0 )
			return contains(root.left, data);
		
		//if data is greater than root.data, look right
		else if (data.compareTo(root.data) > 0 )
			return contains(root.right, data);
		
		else
			return true;
	}
	
	/* Return the number of elements in the treap in O(1) time.*/
	public int size()
	{
		return this.size;   
	}
	
	/* Return the height of the treap. (An O(n) solution is fine here.)*/
	public int height()
	{
		return height(root);
	}
	
	public int height(Node<T> root)
	{
		if (root == null)
			return -1;
		else
		{
			// recursively looks down each branch and increments the height
			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			
			if (leftHeight < rightHeight)
			{
				rightHeight++;
				return rightHeight;
			}
			
			else
			{
				leftHeight++;
				return leftHeight;
			}
		}
	}
	public Node<T> getRoot()
	{
		return root;
	}
	
	// generates a random number for a priority from [1, Integer.MAX_VALUE]
	public int getPriority()
	{
		int priority = (int)(Math.random()*(Integer.MAX_VALUE - 1) + 1);
		
		// looks for another random number if the priority is already used
		while (prioritySet.contains(priority))
			priority = (int)(Math.random()*(Integer.MAX_VALUE - 1) + 1);
		
		prioritySet.add(priority);
		
		return priority;
	}
	
	public static double difficultyRating()
	{
		return 3.0; 
	}
	
	public static double hoursSpent()
	{
		return 4.0; 
	}
	
}
