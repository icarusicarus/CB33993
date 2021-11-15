
public class MathMain {
	public static void main(String[] args) {
		int begin = 2;
		int end = 10;
		
		long sum = getSumBetween(begin, end);
		System.out.printf("Sum between %d and %d: %d\n", begin, end, sum);
		printSumBetween(begin, end, sum);
		
		long product = getProductBetween(begin, end);
		System.out.printf("Product between %d and %d: %d\n", begin, end, product);
		printProductBetween(begin, end, product);
		
	}
	
	public static long getSumBetween(int begin, int end) {
		long sum = 0;
		for (int i = begin; i < end + 1; i++) {
			sum += i;
		}
		
		return sum;
	}
	
	public static void printSumBetween(int begin, int end, long sum) {
		for (int i = begin; i < end + 1; i ++) {
			if (i == begin) System.out.print(i);
			else System.out.print("+" + i);
		}
		System.out.printf(" = %d\n", sum);
	}
	
	public static long getProductBetween(int begin, int end) {
		long product = 1;
		for (int i = begin; i < end + 1; i++) {
			product *= i;
		}
		
		return product;
	}
	
	public static void printProductBetween(int begin, int end, long product) {
		for (int i = begin; i < end + 1; i ++) {
			if (i == begin) System.out.print(i);
			else System.out.print("*" + i);
		}
		System.out.printf(" = %d\n", product);
	}
}
