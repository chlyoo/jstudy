package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686ChickenOptimize {

	static int N; //N*N  
	private static int M;
	private static List<int[]> storeList;
	private static List<int[]> houseList;
	private static int[] numbers;
	private static int result = Integer.MAX_VALUE;
	private static int sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		storeList = new ArrayList<>();
		houseList = new ArrayList<>();
		for (int i = 0; i < N; i++) { //입력하면서 치킨집이면 좌표를 storepos 추가
			String line = br.readLine();
			for (int j = 0, k=0; j < N; j++, k+=2) {
				int temp = line.charAt(k)-'0';
				if(temp==1) {
					int[] t= {i,j};
					houseList.add(t);
				}else if(temp==2) {
					int[] t= {i,j};
					storeList.add(t);
				}
			}
		}//입력 for
		numbers = new int[storeList.size()]; //치킨집 수만큼 배열 생성
		combination(0, 0);
		System.out.println(result);

	}
	//치킨집 M개를 선택한 조합을 구한다.
	private static void combination(int cnt, int start) {
		if(cnt==M) {
			calcDistance();
			result = Math.min(sum, result); // 치킨거리의 최소값을 업데이트 한다.
			return;
		}
		for(int i = start; i<storeList.size(); i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	//number의 있는 인덱스를 가지고 for문을 돌려서각 집의 거리를 구한다.
	private static void calcDistance() {
		sum = 0;
		for(int i = 0; i < houseList.size(); i++) {// 각집마다먼저 돌린다 거기서 최소값을 구한다
			int min = 2*N;
			for(int j = 0 ; j< M; j++) { //numbers[j] 가 인덱스로 들어가서치킨집과의 거리를 계산한다.
				int distance =  Math.abs(storeList.get(numbers[j])[0] - houseList.get(i)[0]) +Math.abs(storeList.get(numbers[j])[1]-houseList.get(i)[1]); 
				min = Math.min(distance, min); //최소거리를 업데이트 한다.
			}
			sum+= min; 
		}
	}

}
