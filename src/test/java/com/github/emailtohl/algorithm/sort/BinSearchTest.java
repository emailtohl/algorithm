package com.github.emailtohl.algorithm.sort;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class BinSearchTest {
	int[] arr = { 1, 2, 3, 4, 5, 6 };
	BinSearch search = new BinSearch();

	@Test
	public void testRecursionSearch() {
		assertEquals(-1, search.recursionSearch(arr, 0, arr.length - 1, 0));
		assertEquals(0, search.recursionSearch(arr, 0, arr.length - 1, 1));
		assertEquals(2, search.recursionSearch(arr, 0, arr.length - 1, 3));
		assertEquals(4, search.recursionSearch(arr, 0, arr.length - 1, 5));
		assertEquals(5, search.recursionSearch(arr, 0, arr.length - 1, 6));
		assertEquals(-1, search.recursionSearch(arr, 0, arr.length - 1, 7));

	}

	@Test
	public void testIterateSearch() {
		assertEquals(-1, search.iterateSearch(arr, 0));
		assertEquals(0, search.iterateSearch(arr, 1));
		assertEquals(2, search.iterateSearch(arr, 3));
		assertEquals(4, search.iterateSearch(arr, 5));
		assertEquals(5, search.iterateSearch(arr, 6));
		assertEquals(-1, search.iterateSearch(arr, 7));
	}
	
	@Test
	public void randomTest() {
		int length = 100;
		Random r = new Random();
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = r.nextInt(100);
		}
		Quick sort = new Quick();
		sort.sort(array, 0, length - 1);
		int keyIndex = r.nextInt(length);
		int key = array[keyIndex];
		int index = search.recursionSearch(array, 0, length - 1, key);
		assertEquals(key, array[index]);
		index = search.iterateSearch(array, key);
		assertEquals(key, array[index]);
	}
}
