package com.a.basics_oo.a.sol;
//A passanger is moving from LN to Noida "using" metro/ bike
//loose coupling and high cohesion

//Abstraction is a concept: 2 ways to achive it in java : interface vs abstract class?
//when i should go for what ?

interface Vehicle{
	public  abstract void move(String source, String destination);
}
class Metro implements Vehicle{
	public void move(String source, String destination) {
		System.out.println("moving from "+ source + " to "+ destination+" using metro");
	}
}
class Bike implements Vehicle{
	public void move(String source, String destination) {
		System.out.println("moving from "+ source + " to "+ destination+" using bike");
	}
}

class Passanger{
	private String name;
	
	public Passanger(String name) {
		this.name = name;
	}
	public void travel(String source, String destination,Vehicle vehicle ) {
		System.out.println("name : "+ name);
		vehicle.move(source, destination);
	}
}
public class RelationShipBwTheObjects {
	
	public static void main(String[] args) {
		Vehicle vehicle=new Metro();
		
	//	Metro metro=new Metro();
		Passanger passanger=new Passanger("raj");
		passanger.travel("LN", "Noida", vehicle);
	}

}



