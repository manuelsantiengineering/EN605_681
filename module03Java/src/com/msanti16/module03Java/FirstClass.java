package com.msanti16.module03Java;

import com.msanti16.module03Java.MyMath;

public class FirstClass {

	public static void main(String[] args) {
		System.out.println("Module 3 Assignment - Manuel Santiago");
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = MyMath.getProduct(a,b);
		String result = (c < 0) ? "(" + Integer.toString(c*-1) +")" : Integer.toString(c);
		System.out.println("a = " + a + "\nb = " + b);		
		System.out.println("a * b = " + result );

	}

}