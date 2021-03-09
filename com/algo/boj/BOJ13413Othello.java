package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ13413Othello {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC =  Integer.parseInt(br.readLine());
		for (int testCase =0; testCase< TC; testCase++) {
			int N  = Integer.parseInt(br.readLine());
			char[] c1 = br.readLine().toCharArray();
			char[] c2 = br.readLine().toCharArray();
			int w=0;
			int b=0;
			for (int i = 0; i < N; i++) {
				if(c1[i] != c2[i]) {
					if(c1[i]=='W') {
						w++;	
					}else {
						b++;
					}
				};
			}
			sb.append(w+b-Math.min(w,b)).append("\n"); //w+b == 전체 min(
		}
		System.out.print(sb);
	}
}