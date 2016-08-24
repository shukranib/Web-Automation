package com.craftsvilla.framework;

public class Test {
	public static void main(String[] args) {
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		System.out.println(number);
	}
}