package com.a.basics_oo.c;

public class DemoMain {

	public static void main(String[] args) {
		
		Stack stack=new AmitStack();
		
		someInternalLogic(stack);
	}

	private static void someInternalLogic(Stack stack) {
	
		stack.push(0);
		stack.push(3);
		stack.push(-33);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	
	

}
