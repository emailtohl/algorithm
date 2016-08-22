package com.github.emailtohl.algorithm.sort;

import java.util.Random;

import org.junit.Test;

public class SelectTest {

	@Test
	public void testSort() {
		int length = 100;
		Random r = new Random();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = r.nextInt(100);
		}
		Select sl = new Select();
		long start = System.currentTimeMillis();
		sl.sort(arr);
		long stop = System.currentTimeMillis();
		System.out.println(stop - start);
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " , ");
		}
	}

}
