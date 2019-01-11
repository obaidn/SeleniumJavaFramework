package com.stc.listener;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class TestNGListenerTest2 {
	
	@Test
	public void test10() {
		System.out.println("I am inside Test 10");
	}
	@Test
	public void test20() {
		System.out.println("I am inside Test 20");
		Assert.assertTrue(false);
	}

	@Test
	public void test30() {
		System.out.println("I am inside Test 30");
		throw new SkipException("This Test is SKIPPED");
	}

	

}
