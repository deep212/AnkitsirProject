package P1;

public class MissingElement {
	public static void main(String[] args) {
		int[] numbers ={3,4,1,2,6,7};
		MissingElement m = new MissingElement();
		System.out.println(m.getMissingNumber(numbers, 7));
	}
	private static int getMissingNumber(int[] numbers, int totalCount)
	{ 
		int expectedSum = totalCount * ((totalCount + 1) / 2); 
		int actualSum = 0; 
		for (int i : numbers)
		{ 
			actualSum += i; 
			}
		return expectedSum - actualSum;
		}

	
}
