package com.java8.Lamda;

@FunctionalInterface
interface Arithmetic {
	int operations(int a, int b);
}

public class LamdaExampleOne {

	public static void main(String[] args) {

		Arithmetic addition = (a, b) -> (a + b);
		// addition operation

		System.out.println("Addition=> " + addition.operations(10, 20));
		
		Arithmetic substraction= (a,b)->(a - b);
		
		System.out.println("Substraction=> " + substraction.operations(50, 10));
			
	        }
		}
		
	

