package mypkg;

import static org.junit.Assert.*;

import org.junit.Test;

public class testdemo {
	DemoProj obj = new DemoProj();
	@Test
	public void test() {
		assertEquals(30,obj.add(10,20));
	}

}
