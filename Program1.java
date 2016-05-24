public class Program1 {
	public static int NoCanHasSum(int [] array) {
		
		int min = 0;
		
		if (array[0] > 1)
			return 1;
		else
			for (int i = 0; i < array.length; i++){
				if (array[i] > min + 1)
					return min + 1;
				
				min = min + array[i];
			}
		
		return min + 1;
	}
	
	public static double difficultyRating() {

		return 2.5;
	}
	
	public static double hoursSpent() {
 		
 		return 3.0;
	}
}
