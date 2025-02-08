package mypkg;

public class DemoProj {
	
	public int add(int a,int b) {
		return a+b;
	}
	public String Intro(String name) {
		return "kalyan "+name;
	}
	public String greet(String name) {
		return "Hello "+name;
	}
	public String Infor(String name) {
		return "Learning "+name;
	}
	public static void main(String[] args) {
		DemoProj ob1=new DemoProj();
		System.out.println("I am "+ob1.Intro("Ram"));
		System.out.println(ob1.greet("Linkedin"));
		System.out.println(ob1.Infor("Jenkins"));
		System.out.println(ob1.add(10,20));

	}
}
