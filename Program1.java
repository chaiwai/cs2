public class Program1 {
	public static int NoCanHasSum(int [] array) {
// An O(n) method that returns the smallest integer p >= 1
// such that no subset of elements from array sums to p.
// array is an array of positive integers sorted in
// non-decreasing order. The array may contain duplicates.
		
		int min = 0;
		
		if (array[0] > 1)
			return 1;
		else
			for (int i = 0; i < array.length; i++){
				min = min + array[i];
				

			}
		
		
		return min + 1;
	}
	
	public static double difficultyRating() {
// Return a double indicating how difficult you found this
// problem on a scale of 1.0 (ridiculously easy) through 5.0
// (insanely difficult).
// Please give your rating in terms of how you perceived the
// difficulty of this problem before discussing it with others
// (if applicable).
		
		return 2.5;
	}
	
	public static double hoursSpent() {
// Return an estimate (greater than zero) of the number
// of hours you spent on this assignment.
 		
 		return 2.0;
	}
	//***
	//delete main before submitting
	//***
	public static void main(String [] args){
		int [] x = new int [5];
		x[0] = 3;
		x[1] = 4;
		x[2] = 5;
		//x[3] = 1;
		//x[4] = 2;
		
		System.out.println(NoCanHasSum(x));
	}
	//testing git sync
}
