

// TreapAnalysis.java
// ==================
// Once you have Assignment #3 working, you should be able to use this to
// perform empirical height analysis and show that your treaps are, on average,
// O(log n) in height.
//
// I've also included this for the MethodHandles.lookup() trick.


import java.lang.reflect.Method;
import java.lang.invoke.MethodHandles;

public class TreapAnalysis
{
	static Treap<Integer> generateTreap(int n)
	{
		Treap<Integer> t = new Treap<Integer>();

		for (int i = 0; i < n; i++)
			t.add((int)(Math.random() * Integer.MAX_VALUE));

		return t;
	}

	public static void main(String [] args)
	{
		if (args.length < 1) {
			System.out.println(
			   "Proper syntax: java " + MethodHandles.lookup() + " <treap size>"
			);
			return;
		}

		int n = Integer.parseInt(args[0]);
		Treap<Integer> t = generateTreap(n);

		// print treap stats
		System.out.println("Treap size: " + t.size());
		System.out.println("Treap height: " + t.height());
		System.out.println("Treap const: " + t.height() / (Math.log(t.size() / Math.log(2.0))));
	}
}
