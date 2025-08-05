package com.a.basics_oo.a;
//A passanger is moving from LN to Noida "using" metro/ bike
//loose coupling and high cohesion
class Metro{
	public void move(String source, String destination) {
		System.out.println("moving from "+ source + " to "+ destination+" using metro");
	}
}
class Bike{
	public void move(String source, String destination) {
		System.out.println("moving from "+ source + " to "+ destination+" using bike");
	}
}

class Passanger{
	private String name;
	
	public Passanger(String name) {
		this.name = name;
	}
	public void travel(String source, String destination,Bike bike ) {
		System.out.println("name : "+ name);
		bike.move(source, destination);
	}
}
public class RelationShipBwTheObjects {
	
	public static void main(String[] args) {
		Bike bike=new Bike();
		
	//	Metro metro=new Metro();
		Passanger passanger=new Passanger("raj");
		passanger.travel("LN", "Noida", bike);
	}

}



