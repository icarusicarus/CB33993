
public class FactorialMain {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i ++) {
			System.out.print("\nFactorial of " + i + ": ");
			for (int j = 1; j <= i; j ++) {
				if (j == 1) System.out.print(1);
				else System.out.print("*" + j);
			}
			System.out.print("=");
			System.out.print(factorial(i));
		}
		
	}
	
	public static long factorial(final int n) {
		if (n <= 1) {
			return n;
		}
		else {
			return factorial(n - 1)*n;
		}
	}
}
