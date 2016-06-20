// info

//Implement the probabilistic Treap data structure. It is important that you implement the insertion and deletion operations as described in class. (In particular, be sure to read my note in Webcourses on how deletion is handled, which includes a discussion of how this differs from our traditional approach to BST deletion.) Your Treap class must be generic. Since there is an ordering property in treaps, you must also restrict the type parameter (e.g., AnyType) to classes that implement Comparable.

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
	//hashset maybe?
	
	//constructor?
	
//	Add data to the treap. Do not allow insertion of duplicate values. You will have to generate a
//	random priority for this node. Find an efficient way to ensure that no duplicate priorities are
//	generated, which uses no more than O(n) extra memory.
	public void add(T data)
	{
		if (!contains(root, data))
		{
			int priority = getPriority();
			root = add(root, data, priority);
		}
	}
	
//	Insert data into the treap (as above), but do not generate a random node priority for the new
//	node. Instead, let the programmer (me) pass the priority as a parameter. I’ll use this to test your
//	code with my own sequence of not-so-random priorities.
	public void add(T data, int priority)
	{
		if (!contains(root, data))
		{
			root = add(root, data, priority);
		}
	}
	
	private Node<T> add(Node<T> root, T data, int priority)
	{
		// if the bst is empty, a root node is set
		if (root == null)
		{
			//instantiates a new node with data
			return new Node<AnyType> (data);
		}
		// if the new node is <, it is placed to the left
		// using the compareTo method, if data is less than root.data
		// it will return a negative #
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
			;
		}

		return root;
	}
	
//	Delete data from the treap (if it is present).
	public void remove(T data)
	{
		root = delete(root, data);
	}
	
	private Node<T> delete(Node<T> root, T data)
	{
		return null; //for now
	}
	
//	Return true if the treap contains data, false otherwise.
	public boolean contains(T data)
	{
		return contains(root, data);
	}
	
	private boolean contains(Node<T> root, T data)
	{
		if (root == null)
		{
			return false;
		}
		// if data is less than root.data, look left
		else if (data.compareTo(root.data) < 0 )
		{
			return contains(root.left, data);
		}
		//if data is greater than root.data, look right
		else if (data.compareTo(root.data) > 0 )
		{
			return contains(root.right, data);
		}
		else
		{
			return true;
		}
	}
	
//	Return the number of elements in the treap in O(1) time.
	public int size()
	{
		return this.size; // does this work?	
	}
//	Return the height of the treap. (An O(n) solution is fine here.)
	public int height()
	{
		return height(root);
	}
	
	public int height(Node<T> root)
	{
		return 0; //change
	}
	public Node<T> getRoot()
	{
		return root;
	}
	
	// generates a random number for a priority
	public int getPriority()
	{
		int priority = (int)(Math.random()*(Integer.MAX_VALUE - 1) + 1);
		while (prioritySet.contains(priority)
			priority = (int)(Math.random()*(Integer.MAX_VALUE - 1) + 1);
		prioritySet.add(priority)
		return priority;
	}
	
	public static double difficultyRating()
	{
		return 3.0; // change
	}
	
	public static double hoursSpent()
	{
		return 3.0; // change
	}
	
	public static void main (String [] args)
	{
	
	}

}
