package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class BOJ2667Numbering {
	static class Node{
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int[][] map;
	private static int N, mini , minj;
	private static int[] dx= {1,-1,0,0};
	private static int[] dy= {0,0,1,-1};
	private static ArrayList<Integer> rank;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		rank = new ArrayList<>();
		bfs();
		sb.append(rank.size()).append("\n");
		Collections.sort(rank);
		for (int val: rank) {
			sb.append(val).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static void bfs() {
		LinkedList<Node> q = new LinkedList<>();
		Node s = selectOne(mini, minj);
		int cnt = 0;
		while(s!=null) {
			q.offer(s);
			map[s.x][s.y]=0;
			cnt= 1;
			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Node n = q.poll();
					for (int d = 0; d < 4; d++) {
						int nx =n.x+dx[d];
						int ny =n.y+dy[d];
						if(nx<0 || ny<0 || nx>=N || ny>=N || map[nx][ny]==0) continue;
						cnt++;
						map[nx][ny]=0;
						q.offer(new Node(nx,ny));
					}
				}
			}
			rank.add(cnt);
			s = selectOne(mini, minj);
		}
	}

	private static Node selectOne(int x, int y) {
		int c=0;
		for (int i = x; i < N; i++) {
			if(i==x) {
				c =y;
			}else
				c=0;
			for (int j = c; j < N; j++) {
				if(map[i][j]==1) {
					mini = i;
					minj = j;
					return new Node(i,j);
				}
			}
		}
		return null;
	}

}
