package mypkg;

public class DemoProj {
	
	public String greet(String name) {
		return "kalyan "+name;
	}
	
	public static void main(String[] args) {
		DemoProj ob1=new DemoProj();
		System.out.println("I am "+ob1.greet("Ram"));
	}
}
