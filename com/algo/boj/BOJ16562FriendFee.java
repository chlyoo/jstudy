package com.algo.boj;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16562FriendFee {

	static int[] p, pay;
	static int find(int a) {
		if(a==p[a]) return a;
		else return p[a] = find(p[a]);
	}
	static void union(int a, int b) {
		int pa=find(a);
		int pb = find(b);
		//비용이 적은걸로 대표 
		if(pay[pb] > pay[pa]) 	p[pb] = pa;
		else 					p[pa] = pb;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		pay = new int[N+1];

		//친구비 입력
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 1; i <= N; i++) {
			pay[i] = Integer.parseInt(st.nextToken());
		}
		//make set 
		p = new int[N+1];
		for (int i = 1; i <= N; i++) { //make set
			p[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			union(v,w);
		}
		int sum = 0;
		for (int i = 1; i <=N; i++) {
			if(i==p[i]) sum+=pay[i];
		}
		System.out.print(sum<=K? sum: "Oh no");
		br.close();
	}


}

