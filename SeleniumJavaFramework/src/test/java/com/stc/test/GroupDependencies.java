package com.stc.test;

import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.testng.annotations.Test;

public class GroupDependencies {
	
	@Test(dependsOnGroups= {"Reg1"}, priority=1)
	
	public void test1() {
		System.out.println("Test 1");
	}
	
	@Test(groups="Reg1")
	public void test2() {
		System.out.println("Test 2");
	}
	
	@Test
	public void test3() {
		System.out.println("Test 3");
	}

}
