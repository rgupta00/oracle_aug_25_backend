package com.demo.sol;
//Seprate what varies

//O:OCP: 
interface Operation{
	public int apply(int a, int b);
}
//O	C	P
class CalApp{
	//behaviour is passsed from outside word : behavioural parameterization
	
	 public static int applyOp(int a, int b , Operation operation) {
		 return operation.apply(a, b);
	 }
 }
 

public class DemoOCP {

	public static void main(String[] args) {
		Operation addOpt=( a,  b) -> a-b;
		
		int result = CalApp.applyOp(2, 12, addOpt);
		System.out.println(result);
		
		
	}
}
