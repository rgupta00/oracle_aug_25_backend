package demo;

public class NumberChecker {

	//version 1
	public  Boolean isPrime(Integer testNumber) {
		for (Integer i = 2; i < testNumber; i++) {
			if (testNumber % i == 0) return false;
		}
		return true;
	}
	
	//version 2
	public  Boolean isPrime2(int testNumber) {
		int maxToCheck=(int) Math.sqrt(testNumber);
		
		for (int i = 2; i <= maxToCheck; i++) {
			if (testNumber % i == 0) return false;
		}
		return true;
	}
	
}
