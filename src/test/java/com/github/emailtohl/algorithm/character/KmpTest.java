package com.github.emailtohl.algorithm.character;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class KmpTest {

	@Test
	public void testGetNextArray() {
		Kmp kmp = new Kmp();
		int[] next = kmp.getNextArray("abababb");
		int[] expect = {-1,0,0,1,2,3,4};
		assertTrue(Arrays.equals(next, expect));
		kmp.printNextArray(next);
		
		Random r = new Random();
		char[] av = new char[] {'X', 'Y', 'Z'};
		StringBuilder pattern = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			pattern.append(av[r.nextInt(3)]);
		}
		next = kmp.getNextArray(pattern.toString());
		// check
		for (int i = 0; i < next.length; i++) {
			int val = next[i];
			if (val == -1) {
				continue;
			}
			int rightStart = i - val;
			for (int leftStart = 0; leftStart < val; leftStart++, rightStart++) {
				assertEquals(pattern.charAt(leftStart), pattern.charAt(rightStart));
			}
		}
	}

	@Test
	public void testSearchStringStringInt() {
		Kmp kmp = new Kmp();
		int actual;
		System.out.println("匹配在：");
		actual = kmp.search("abacbcabababbcbc", "abababb", 1);
		System.out.println(actual);
		assertEquals("abacbcabababbcbc".indexOf("abababb"), actual);
		System.out.println("--------------------------------");
		
		System.out.println("匹配在：");
		actual = kmp.search("abaaaabaaaaaaaaa", "baaaaaaaaa", 0);
		System.out.println(actual);
		assertEquals("abaaaabaaaaaaaaa".indexOf("baaaaaaaaa"), actual);
		System.out.println("--------------------------------");

		System.out.println("匹配在：");
		actual = kmp.search("bcbaabacaababacaa", "ababac", 0);
		System.out.println(actual);
		assertEquals("bcbaabacaababacaa".indexOf("ababac"), actual);
		System.out.println("--------------------------------");
		
		
		System.out.println("匹配在：");
		actual = kmp.search("abcabcabca", "abcabx", 0);
		System.out.println(actual);
		assertEquals("abcabcabca".indexOf("abcabx"), actual);
		System.out.println("--------------------------------");

		System.out.println("匹配在：");
		actual = kmp.search("abacababc", "abab", 0);
		System.out.println(actual);
		assertEquals("abacababc".indexOf("abab"), actual);
		System.out.println("--------------------------------");
	}

	@Test
	public void testSearchStringString() {
		Kmp kmp = new Kmp();
		int actual;
		System.out.println("匹配在：");
		actual = kmp.search("annbcdanacadsannannacanna", "annacanna");
		System.out.println(actual);
		assertEquals("annbcdanacadsannannacanna".indexOf("annacanna"), actual);
		System.out.println("--------------------------------");

		System.out.println("匹配在：");
		actual = kmp.search("BBC ABCDAB ABCDABCDABDE", "ABCDABD");
		System.out.println(actual);
		assertEquals("BBC ABCDAB ABCDABCDABDE".indexOf("ABCDABD"), actual);
		System.out.println("--------------------------------");
	}

}
