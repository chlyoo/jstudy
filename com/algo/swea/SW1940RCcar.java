
package com.algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1940RCcar {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int speed=0;
			int distance=0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String temp = st.nextToken();
				if(Integer.parseInt(temp)==1) {
					speed+= Integer.parseInt(st.nextToken());

				}else if (Integer.parseInt(temp)==2) {
					speed-= Integer.parseInt(st.nextToken());
					if(speed < 0) speed=0;
				}
				distance+= speed;
			}

			sb.append("#").append(testCase).append(" ").append(distance).append('\n');
		}//end of for test Case
		System.out.print(sb);
	}

}
