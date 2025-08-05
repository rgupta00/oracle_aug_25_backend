package com.demo2;

public class ProcessShape {

	
	public static void process(Object shape) {
		if(shape instanceof CircleShape) {
			((CircleShape) shape).drawCircleShape();
		}
		else if(shape instanceof SquareShape) {
			((SquareShape) shape).drawSquareShape();
		}
		else if(shape instanceof TriangleShape) {
			((TriangleShape) shape).drawTriangleShape();
		}
	}
}
