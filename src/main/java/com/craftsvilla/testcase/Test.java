package com.craftsvilla.testcase;

public class Test {
public static void main(String[] args) {
	String str="₹ 999";
	
	str=str.replace('₹', ' ');

	int price=Integer.parseInt(str.trim());
	
}
}
