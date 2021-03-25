package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9205BeerWalk {
	private static int[][] graph;
	private static boolean[][] result; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int testCase = 0; testCase < TC; testCase++) { //testCase수 만큼반복한다. 
			int N  = Integer.parseInt(br.readLine()); //편의점의 수를 입력받는다.
			graph= new int[N+2][2];  // 집 + 편의점 + 공연장 => 1 + N + 1 
			for (int j = 0; j < N+2; j++) {
				st = new StringTokenizer(br.readLine());
				graph[j] =new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; 
			}
			result = new boolean[N+2][N+2]; //정점이 연결되어 있는지를 담는 배열
			for (int j = 0; j < result.length; j++) {
				for (int j2 = 0; j2 < result.length; j2++) {
					//i,j의 맨하튼 거리가 1000보다 작은 경우 ( 연결된 경우)
					if(getDistance(graph[j][0], graph[j][1], graph[j2][0], graph[j2][1])<=1000) {
						result[j][j2] = true;
						result[j2][j] = true;
					}
				}
			}
			for (int via = 0; via < N+2; via++) {
				for (int from = 0; from < N+2; from++) {
					if(via==from)continue;
					for (int to =0; to < N+2; to++) {
						if(from==to || via==to)continue;
						//from - via와 via-to 가 연결된 경우 from-to, to-from도 연결된다.
						if(result[from][via] && result[via][to]) {
							result[from][to] =true;
							result[to][from] =true;
						}
					}
				}
			}//for 
			// 0==집의 인덱스, N+1==공연장의 인덱스
			if(result[0][N+1]) { //연결된 경로가 존재하는 경우
				System.out.println("happy");
			}else { //연결된 경로가 없는 경우 
				System.out.println("sad");
			}

		}//testCase
	}
	//맨하튼 거리를 리턴하는 함수
	private static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}

}
