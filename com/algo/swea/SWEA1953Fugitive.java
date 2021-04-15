package com.algo.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1953Fugitive {
	static class Pos{
		int x,y,direction;

		public Pos(int x, int y, int direction) {
			super();
			this.x = x;
			this.y = y;
			this.direction =direction;
		}
	}

	private static int[] dx = {-1,1,0,0};
	private static int[] dy = { 0,0,-1,1};
	private static int N, M, R, C, L; 
	private static int[][] map;
	private static boolean[][] visited;
	private static LinkedList<Pos> q;
	private static int result;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d9_1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		q = new LinkedList<>();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//입력의 크기 
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			//맨홀 뚜껑 좌표
			R = Integer.parseInt(st.nextToken()); 
			C = Integer.parseInt(st.nextToken());
			//이동 시간 L
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = toBit(Integer.parseInt(st.nextToken()));
				}
			}//input
			result = 1;
			bfs();
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static void bfs() {
		q.clear();
		q.offer(new Pos(R,C, map[R][C]));
		visited[R][C]=true;
		int level =1;
		while(level<L &&!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pos p =q.poll();
				int nx = 0;
				int ny = 0;
				for (int d = 0; d <4 ; d++) {
					if((p.direction&(1<<d))!=0) {
						nx =p.x + dx[d];
						ny =p.y + dy[d];
						if(nx<0 || ny <0 || nx>=N || ny>=M) continue;
						if(visited[nx][ny] || map[nx][ny]==0) continue;
						if((map[nx][ny] & (1<<cDriection(d)))!=0){
							visited[nx][ny]=true;
							q.offer(new Pos(nx,ny, map[nx][ny]));
							result++;
						}
					}

				}
			}
			level++;
		}
	}
	//return counter direction 
	private static int cDriection(int d) {
		if(d == 0)
			return 1;
		else if(d==1)
			return 0;
		else if(d==2)
			return 3;
		else return 2;
	}
	private static int toBit(int direction) {
		switch (direction) {
			case 1 :
				return 15;// 1+2+4+8
			case 2 :
				return 3;//1+2;
			case 3 :
				return 12;//4+8;
			case 4 :
				return 9;//1+8;
			case 5 :
				return 10;//2+8;
			case 6 :
				return 6;//2+4;
			case 7 :
				return 5;//1+4; 
		}
		return 0;
	}

}
