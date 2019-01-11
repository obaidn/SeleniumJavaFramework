package com.stc.test;

import org.testng.annotations.Test;

public class RetryFailedTests {
	
	
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	@Test(retryAnalyzer=com.stc.listener.MyRetry.class)
	public void test2() {
		System.out.println("Test 2");
		int x = 1/0;
		System.out.println(x);
	}
	@Test
	public void test3() {
		System.out.println("Test 3");
	}

}
