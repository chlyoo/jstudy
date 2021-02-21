package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686Chicken {
	static class Store{
		int posx;
		int posy;
		int id;
		static int no;
		Store(int i, int j){
			this.posx = i;
			this.posy = j;
			this.id= ++no;
		}
		public int distance(int i, int j){
			return Math.abs(this.posx - i) + Math.abs(this.posy - j);
		}
		@Override
		public String toString() {
			return "C"+id+"("+posx + "," + posy + ")";
		}


	}
	static class House{
		int posx;
		int posy;
		int id;
		static int no;
		House(int i, int j){
			this.posx = i;
			this.posy = j;
			this.id= ++no;
		}
		public int distance(int i, int j){
			return Math.abs(this.posx - i) + Math.abs(this.posy - j);
		}
		@Override
		public String toString() {
			return "H"+id+"("+posx + "," + posy + ")";
		}
	}

	static int N; //N*N  
	private static int M;
	private static List<Store> storeList;
	private static List<House> houseList;
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
					House house = new House(i,j);
					houseList.add(house);
				}else if(temp==2) {
					Store store = new Store(i,j);
					storeList.add(store);
				}
			}
		}//입력 for
		numbers = new int[storeList.size()];
		combination(0, 0);
		System.out.println(result);

	}

	private static void combination(int cnt, int start) {
		if(cnt==M) {
			//			System.out.println(Arrays.toString(numbers));
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
			//number에 있는집만 방문한다.
			int min = 2*N;
			for(int j = 0 ; j< M; j++) { //numbers[j] 가 인덱스로 들어가서치킨집과의 거리를 계산한다.

				int distance =  storeList.get(numbers[j]).distance(houseList.get(i).posx, houseList.get(i).posy);
				min = Math.min(distance, min); //최소거리를 업데이트 한다.
			}
			sum+= min; 
			//			System.out.println(min);
		}
	}

}
