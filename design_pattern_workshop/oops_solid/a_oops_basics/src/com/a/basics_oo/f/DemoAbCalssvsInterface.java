package com.a.basics_oo.f;
//kid jump like a monkey
//kid is monkey

interface Jumpable{
	public void jump();
}

class Monkey implements Jumpable{
	public void stayOnTree() {
		System.out.println("i stay on stayOnTree");
	}
	
	public void biteOnBack() {
		System.out.println("biteOnBack");
	}

	@Override
	public void jump() {
		System.out.println("jump by monkey :)");
	}
	
}
class Kid implements Jumpable{
	
	public void doHomeWork() {
		System.out.println("doing HomeWork :(");
	}
	
	public void goToSchool() {
		System.out.println("going to school :(");
	}
	@Override
	public void jump() {
		System.out.println("jump by kid :)");
	}
}
public class DemoAbCalssvsInterface {
	
	public static void main(String[] args) {
		Kid kid=new Kid();
		kid.jump();
		kid.doHomeWork();
		
	}

}
