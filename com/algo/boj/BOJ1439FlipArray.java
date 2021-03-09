package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1439FlipArray {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr =br.readLine().toCharArray(); 
		char flag='1';
		int czero= 0;
		int cone = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==flag) {
				if(i==0) 
					cone++;
			}else {
				if(flag=='1') {
					flag='0';
					czero++;
				}else {
					flag='1';
					cone++;
				}
			}
		}
		System.out.print(Math.min(czero, cone));
	}

}
