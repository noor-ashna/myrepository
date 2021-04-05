package com.java8;

   interface Aprintable{
	void print(String message);
}
public class LamdaExampleTwo {
	
	public static void main(String[] args) {
		
		// without lambda expression
        Aprintable printable = new Aprintable() {
           @Override
           public void print(String msg) {
              System.out.println(msg);
           }
        };
        printable.print(" Print message to console....");
        
        // with lambda expression
        Aprintable withLambda = (msg) -> System.out.println(msg);
        withLambda.print(" Print message to console....");
		
	}

}
