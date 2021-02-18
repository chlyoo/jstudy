package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1987Alphabet {
	private static int R,C;
	private static HashMap<Character,Integer>  history;
	private static char[][] map;
	private static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map= new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		history = new HashMap<>();
		for (char ch = 'A'; ch <= 'Z'; ++ch) 
			history.put(ch,0);
		history.put(map[0][0],1);
		//오른쪽 먼저탐색  -> 아래로 ->왼쪽 -> 
		dfs(0,0,1);
		System.out.print(max);
	}
	//0 은 오른쪽 1 은 아래 왼쪽 
	private static void dfs(int i, int j, int cnt) {
		max = max>cnt? max : cnt; 
		for (int d = 0; d < 4; d++) {
			//오른쪽 먼저탐색  -> 아래로 ->왼쪽 -> 
			int nr= i + "1210".charAt(d)-'1';
			int nc= j + "2101".charAt(d)-'1';
			if(nr<0 || nr>=R || nc<0|| nc>=C) continue;
			if(history.get(map[nr][nc])==1) continue;
			history.put(map[nr][nc], history.get(map[nr][nc])+1);
			dfs(nr, nc,cnt+1);
			history.put(map[nr][nc], history.get(map[nr][nc])-1);
		}
	}

}
