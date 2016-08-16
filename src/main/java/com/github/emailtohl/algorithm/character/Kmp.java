package com.github.emailtohl.algorithm.character;

/**
 * KMP算法
 * 
 * @author HeLei
 */
public class Kmp {

	int[] getNextArray(String pattern) {
		if (pattern == null)
			return null;
		int i, j, N;
		N = pattern.length();
		int[] next = new int[N];
		if (N == 1) {
			next[0] = -1;
			return next;
		}
		next[0] = -1;
		next[1] = 0;
		i = 1;
		j = 0;
		while (i < N - 1) {// 每次求解i+1的值
			if ((j == -1) || (pattern.charAt(j) == pattern.charAt(i)))
				next[++i] = ++j;
			else
				j = next[j];
		}
		return next;
	}

	public int search(String txt, String pattern, int startPost) {
		if (txt == null && pattern == null && startPost < 0)
			return -1;
		int i, j, tlen, plen;
		j = -1;// next[0]的值是-1开始的，每当j等于-1时，模式串指针重置为0
		i = startPost - 1;// 而此时的字符串txt的指针也会后移一位，所以初始值先减1
		tlen = txt.length();
		plen = pattern.length();
		int[] next = getNextArray(pattern);
		while (i < tlen && j < plen) {
			if (j == -1 || txt.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else
				j = next[j];
		}
		if (j >= plen)
			return i - plen;
		else
			return -1;
	}

	public int search(String txt, String pattern) {
		return search(txt, pattern, 0);
	}

	public void printNextArray(int[] next) {
		for (int i = 0; i < next.length; i++) {
			System.out.println(next[i]);
		}
	}
}
