package com.stc.test;

import org.testng.annotations.Test;

public class GroupsTest {
	
	
	@Test(groups="windows.Reg")
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	
	@Test(groups= {"windows.Smoke", "linux.Reg"})
	public void test2() {
		System.out.println("I am inside Test 2");
	}
	
	@Test(groups= {"Reg", "Int"})
	public void test3() {
		System.out.println("I am inside Test 3");
	}
	
	@Test(groups= {"linux.Reg"})
	public void test4() {
		System.out.println("I am inside Test 4");
	}
	
	@Test(groups= { "Smoke"})
	public void test5() {
		System.out.println("I am inside Test 5");
	}

}
