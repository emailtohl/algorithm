package com.github.emailtohl.algorithm.character;

/**
 * KMP算法
 * 
 * @author HeLei
 */
public class Kmp {
	/**
	 * 通过模式串计算出next数组
	 * 数组中的值表示当匹配失败后，模式串中的该值将作为下次匹配的起点。
	 * 
	 * 例如模式串“abababb”的next数组是：[-1,0,0,1,2,3,4]，这表示：
	 * 当第0位匹配失败了，将序号为-1用于下次匹配，当然-1很特殊，这说明文本字符串和模式串都向下一格
	 * 当第1位匹配失败了，则将模式串的第0位与文本串的当前位置进行重新匹配
	 * 当第2位匹配失败了，则将模式串的第0位与文本串的当前位置进行重新匹配
	 * 当第3位匹配失败了，则将模式串的第1位与文本串的当前位置进行重新匹配，可以看出模式串的第0位不需要匹配了
	 * 当第4位匹配失败了，则将模式串的第2位与文本串的当前位置进行重新匹配，可以看出模式串的第0,1位不需要匹配了
	 * 当第5位匹配失败了，则将模式串的第3位与文本串的当前位置进行重新匹配，可以看出模式串的第0,1,2位不需要匹配了
	 * 当第6位匹配失败了，则将模式串的第4位与文本串的当前位置进行重新匹配，可以看出模式串的第0,1,2,3位不需要匹配了
	 * 
	 * 可以看出他们存在交叉的情况
	 * 
	 * @param pattern
	 * @return 
	 */
	int[] getNextArray(String pattern) {
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
	/**
	 * 返回匹配的位置
	 * @param txt 查找的字符串
	 * @param pattern 模式串
	 * @param startPost 查找位置
	 * @return 若返回-1表示未找到匹配的位置
	 */
	public int search(String txt, String pattern, int startPost) {
		if (startPost < 0)
			startPost = 0;
		int i, j, tlen, plen;// i跟踪文本串，j跟踪模式串
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
				// 当匹配失败时，i不会回退，而是调整j指针，在next数组查询从哪个地方开始重新匹配
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
