package demo;

public class Main {
	
	public static void main(String[] args) {
		//Simple approach for benchmarking.. diff of time
		
		NumberChecker checker=new NumberChecker();
		
		//warm up for native compilation -XX:+PrintCompilation
		for(int i=0;i<10000; i++) {
			checker.isPrime2(i);
		}
		long start = System.currentTimeMillis();
		
		
		for(int i=1001;i<20000; i++) {
			checker.isPrime2(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("time taken: "+(end-start)+" ms");
		
	
	}

}
