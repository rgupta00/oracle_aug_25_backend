package com.demo2;

public class Demo {

	public static void main(String[] args) {
		
		//testable, flexible
		
		Tyre tyre=new MrfTyre();
		Engine engine=new V8Engine();
		
		
		Car car =new Car();
		
		//manual dp=> if it can be automize, it would be great
		//Spring framewrok: IOC(external agency )
		car.setEngine(engine);
		car.setTyre(tyre);
		
		
		car.drive();
	}
}
