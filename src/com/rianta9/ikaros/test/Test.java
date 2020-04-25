/**
 * 
 */
package com.rianta9.ikaros.test;

/**
 * @author rianta9
 * Datecreate: 14 thg 3, 2020 10:26:05
 */
public class Test {
	
	String text;
	public Test(String text) {
		this.text = text;
	}
	
	
	public static void test(Test a) {
		a.text = a.text.replace("a", "â");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test a = new Test("ahihi");
		test(a);
		System.out.println(a.text);
	}

}
