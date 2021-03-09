package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1439Flip {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char flag='1';
		int czero= 0;
		int cone = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==flag) {
				if(i==0) {
					cone++;
					continue;
				}
			}else {
				if(flag=='1') {
					flag='0';
					czero++;
				}else {
					flag='1';
					cone++;
				}
			} //   11/ 00 /11         1: 2  0 : 1 
		}
		System.out.print(Math.min(czero, cone));

	}

}
