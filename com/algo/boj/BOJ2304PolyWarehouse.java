package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2304PolyWarehouse {

	private static int index;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		index = 0;
		int[][] map = new  int[N][];
		for (int i = 0; i < N; i++) {
			StringTokenizer	st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[i]=new int[] {x,y};
			if( y > max) {
				index =x;
				max= y;
			}
		}//입력받는 for문
		Arrays.sort(map, (o1,o2) -> {
			if(o2[1]==o1[1]) return Math.abs(index - o2[0]);
			return o2[1]-o1[1];
		});
		int lindex = index;
		int rindex = index;
		int sum =0;
		for (int i = 1; i < map.length; i++) {
			if(map[i][0]> rindex ) {					//오른쪽 탐색
				sum += map[i][1] * (map[i][0] -rindex); //높이 차이곱하기 거리차이
				rindex = map[i][0];						//rindex업데이
			}else if(map[i][0] < lindex){ 				//왼쪽 탐색
				sum += map[i][1] *(lindex -map[i][0]);
				lindex = map[i][0];
			}
		}
		System.out.print(sum+max);
	}
}
