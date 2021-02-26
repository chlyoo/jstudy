package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
class Dice{
	 int A,B,C,D,E,F,top,bottom;
	 List<Integer> four;
	public Dice(){}

	public Dice(int[] input){
		four = new ArrayList<>();
		A = input[1];
		B = input[2];
		C = input[3];
		D = input[4];
		E = input[5];
		F = input[6];
	}
	public List<Integer> getfour() {
		four.clear();
		four.add(A);
		four.add(B);
		four.add(C);
		four.add(D);
		four.add(E);
		four.add(F);
		four.remove(Integer.valueOf(top));
		four.remove(Integer.valueOf(bottom));
		return four;
	}
	public int getMaxfour() {
		return Collections.max(getfour());
	}

	public void setBottom(int i){
		switch (i) {
			case 1 :
				bottom = A;
				top = F;
				break;
			case 2 :
				bottom = B;
				top = D;
				break;
			case 3 :
				bottom = C;
				top = E;
				break;
			case 4 :
				bottom = D;
				top = B;
				break;
			case 5 :
				bottom = E;
				top = C;
				break;
			case 6 :
				bottom = F;
				top = A;
				break;
		}
	}
}
public class BOJ2116Dice {
	
	private static List<Dice> list;
	private static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int map[][] = new int[N][6+1];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 6; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			list.add(new Dice(map[i]));
		}//input 입력 for
		max=0;
		for (int i = 1; i <= 6; i++) { //a,b,c,d,e,f 차례대로 바닥에 두기
			Dice base = list.get(0);
			base.setBottom(i);
			recursiveDice(1, base.top, base.getMaxfour());
			}
		System.out.println(max);

	}//main

	private static void recursiveDice(int cnt, int top, int sum) {
		if(cnt>= list.size()) {
			max = Math.max(max, sum);
			return;
			}
		Dice dice = list.get(cnt);
		for (int i = 1; i <= 6; i++) { //a,b,c,d,e,f 차례대로 바닥에 두기
			dice.setBottom(i);
			if(dice.bottom!=top)continue;
			recursiveDice(cnt+1, dice.top, sum+dice.getMaxfour());
		}
	}

}
