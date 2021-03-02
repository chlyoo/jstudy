package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ13305FuelStation2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] distance = new int[N-1];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		long top =Long.parseLong(st.nextToken());
		long sum = 0;
		for (int i = 1; i < N; i++) {
			long tempcost = Long.parseLong(st.nextToken()); //코스트
			if(top>= tempcost) { //입력이 기존보다작은 경우
				sum += top*distance[i-1];
				top = tempcost;
			}else { 					//입력이 기존보다 큰 경우
				sum += top*distance[i-1];
			}
		}
		System.out.print(sum);
	}

}
