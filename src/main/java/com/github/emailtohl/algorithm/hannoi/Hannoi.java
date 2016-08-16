package com.github.emailtohl.algorithm.hannoi;
/**
 * 汉诺塔
 * @author HeLei
 *
 */
public class Hannoi {

	public void hannoi(int n, char a, char b, char c) {
		if (n == 1) {
			System.out.println(n + " ： " + a + " → " + c);
			return;
		}

		hannoi(n - 1, a, c, b);
		System.out.println(n + " ： " + a + " → " + c);
		hannoi(n - 1, b, a, c);
	}
}
