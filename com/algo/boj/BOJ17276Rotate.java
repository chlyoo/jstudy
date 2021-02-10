package com.algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17276Rotate {

	static StringBuilder sb = new StringBuilder();
	private static int R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			int[][] map = new int[R][R];
			int[][] storage = new int[R][R];
			int spin = Integer.parseInt(st.nextToken());
			if(spin<0) spin+=360;

			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < R; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
				}
			} // input
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < R; j++) {
					storage[i][j]= map[i][j];
				}
			}
			while(spin!=0) {
				rotationMap(map, storage);
				spin-=45;
			}
			//출력
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < R; j++) {
					sb.append(storage[i][j]).append(" ");
				}
				sb.append('\n');
			}
		}
		System.out.print(sb);
	}

	private static void rotationMap(int[][] map, int[][] storage) {
		for ( int i = 0; i < R; ++i ) {
			storage[i][i] = map[R/2][i];        //  \          
			storage[i][R/2] = map[i][i];        //    |          
			storage[i][(R-1)-i] = map[i][R/2];  //      /  
			storage[R/2][i] = map[(R-1)-i][i];  //    -  
		}
		for (int i = 0; i < storage.length; i++) {
			for (int j = 0; j < storage.length; j++) {
				map[i][j]=storage[i][j];
			}
		}
	}

}
