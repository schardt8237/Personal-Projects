class SmallestMissingPositiveInteger {
	// Moves all non-positive integers to the left side of the array and all positive integers to the right
	private static int sortBySign(int[] array) {
		int j = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] <= 0) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				j++;
			}
		}
		
		return j;
	}
	
	private static int findMissingPositive(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(Math.abs(array[i]) - 1 < array.length && array[Math.abs(array[i]) - 1] > 0)
				array[Math.abs(array[i]) - 1] = -array[Math.abs(array[i]) - 1];
		}
		
		for(int i = 0; i < array.length; i++)
			if(array[i] > 0)
				return i + 1;
			
		return array.length + 1;
	}
	
	private static int findMissing(int[] array) {
		int shift = sortBySign(array);
		int[] array2 = new int[array.length-shift];
		int j = 0;
		
		for(int i = shift; i < array.length; i++) {
			array2[j] = array[i];
			j++;
		}
		
		return findMissingPositive(array2);
	}
	
	public static void main(String[] args) {
		int[] array = { 2, 3, -7, 6, 8, 1, -10, 15 };
		int missing_int = findMissing(array);
		System.out.println("The smallest missing positive integer is: " + missing_int);
	}
}