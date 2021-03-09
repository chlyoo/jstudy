package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1080Matrix {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] arr1 = new char[r][c];
		char[][] arr2 = new char[r][c];
		for (int i = 0; i < r; i++) {
			arr1[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < r; i++) {
			arr2[i] = br.readLine().toCharArray();
		}
		int count = 0;

		for (int i = 0; i < r-3; i++) {
			for (int j = 0; j < c-3; j++) {
				if(arr1[i][j]!=arr2[i][j]) {
					count++;
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l< 3; l++) {
							if(arr1[i+k][j+l]=='1') 
								arr1[i+k][j+l]='0';
							else 
								arr1[i+k][j+l]='1';
						}

					}
				}

			}

		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(arr1[i][j]!=arr2[i][j]) { 
					count=-1;
					break;
				}
			}
		}
		System.out.print(count);

	}

}
