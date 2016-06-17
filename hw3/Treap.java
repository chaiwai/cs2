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
		
		// some rand numb gen
	}
	
//	Insert data into the treap (as above), but do not generate a random node priority for the new
//	node. Instead, let the programmer (me) pass the priority as a parameter. I’ll use this to test your
//	code with my own sequence of not-so-random priorities.
	public void add(T data, int priority)
	{
	
	}
	
	private Node<T> add(Node<T> root, T data, int priority)
	{
		return null;  //for now
	}
	
//	Delete data from the treap (if it is present).
	public void remove(T data)
	{
	
	}
	
	private Node<T> delete(Node<T> root, T data)
	{
		return null; //for now
	}
	
//	Return true if the treap contains data, false otherwise.
	public boolean contains(T data)
	{
		return contains(root, data); // change
	}
	
	private boolean contains(Node<T> root, T data)
	{
		return false;
		// cp from genericbst?
	}
	
//	Return the number of elements in the treap in O(1) time.
	public int size()
	{
		
		return 0; // change	
	}
//	Return the height of the treap. (An O(n) solution is fine here.)
	public int height()
	{
	
		return 0; // change
	}
	
	public Node<T> getRoot()
	{
		return root;
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
