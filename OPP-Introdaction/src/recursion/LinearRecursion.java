package recursion;

public class LinearRecursion {

	public static boolean isSubstring(String string, String pattern) {
		return isSubstring(string, pattern, 0);
	}

	private static boolean isSubstring(String str, String pattern, int i) {
		if (i == pattern.length()) {
			return true;
		} else if (str.length() == 0) {
			return false;
		} else if (str.charAt(0) == pattern.charAt(i)) {
			return isSubstring(str.substring(1), pattern, ++i);
		} else {
			return isSubstring(str.substring(1), pattern, 0);
		}
	}

	static public long factorial(int n) {
		long res = 0;
		if (n < 0) {
			res = factorial(-n);
		} else if (n < 2) {
			res = 1;
		} else {
			res = n * factorial(n - 1);
		}
		return res;
	}

	static public int power(int number, int pow) {
		int res = 1;
		if (pow < 0) {
			throw new IllegalArgumentException();
		}
		if (pow > 1) {
			res = multip(power(number, pow - 1), number);
		} else if (pow == 1) {
			res = number;
		}
		return res;
	}

	public static int multip(int a, int n) {
		int res;
		if (n < 0) {
			res = multip(a, -n);
		} else if (n == 0) {
			res = 0;
		} else {
			res = a + multip(a, n - 1);
		}
		return res;
	}

	static public long sum(int ar[]) {
		return sum(0, ar);
	}

	private static long sum(int firstIndex, int[] ar) {
		long res = 0;
		if (firstIndex < ar.length) {
			res = ar[firstIndex] + sum(firstIndex + 1, ar);
		}
		return res;
	}

	public static long square(int x) {
		    if (x==1)
		        return 1;
		    else
		        return square(x-1)+2*x-1;
	}

	public static void reverse(int ar[]) {
		reverse(0, ar.length - 1, ar);
	}


	private static void reverse(int firstIndex, int lastIndex, int[] ar) {
		if (firstIndex < lastIndex) {
			swap(ar, firstIndex, lastIndex);
			reverse(firstIndex + 1, lastIndex - 1, ar);
		}

	}

	private static void swap(int[] ar, int firstIndex, int lastIndex) {
		int tmp = ar[firstIndex];
		ar[firstIndex] = ar[lastIndex];
		ar[lastIndex] = tmp;

	}
}