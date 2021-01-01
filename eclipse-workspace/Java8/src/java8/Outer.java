package java8;


// This class is called top class
// no static, private and protected 
public class Outer {
	
	private int m =100;
	private static int n=90;
	
	public void showx() {
		System.out.println("show m= "+m);
		System.out.println("show n= "+n);
		
	} 
	// This is non static inner class
	// This inner class we can access with the instance of inclosing
	// Inner class we cannot load with the help of outer class
	//That is why we cannot declare anthing static inside it

	class Inner {
		private int p=100;
		// private  static int q=200;
		public void show() {
		System.out.println("show p= "+p);	
		System.out.println("showx m= "+m);
		System.out.println("showx n="+n);
			
		}
		
	}
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.showx();
		// now I want to make an object of Inner
		// Outer.Inner iobj=outer.new Inner();
		Outer.Inner iobj=new Outer().new Inner();
	}
}