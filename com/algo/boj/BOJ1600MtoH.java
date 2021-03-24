package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600MtoH {
	private static int[][] map;
	private static boolean[][][] visited;
	private static int R,C,K;
	private static int[] dhx = {-1, -2, -1, -2, 1, 2, 1, 2};
	private static int[] dhy = {-2, -1, 2, 1, -2, -1, 2, 1};
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	static int result=-1;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];  // map 정보 저장
		visited = new boolean[R][C][K+1]; //bfs 경로 저장을 위한 3차원 visited
		for (int i = 0; i < R; i++) {
			st =  new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
			}
		}//for
		jump();

	}
	private static void jump() {
		Queue<int[]> q = new LinkedList<int[]>(); //bfs를 위한 큐
		q.add(new int[] {0,0,0,0});	// x,y,k,tr 을 큐에 배열로 전달
		while (!q.isEmpty()) {
			int[] data = q.poll();
			int x = data[0];
			int y = data[1];
			int k = data[2];
			int tr = data[3];
			if(x == R-1 && y == C-1) { //마지막에 도착한 경우 
				result = tr;
				break; //bfs이기 때문에 레벨 즉 이동횟수가 동일하
			}
			if(k<K) { //말처럼 이동가능한 회수가 남은 경우
				for (int i = 0; i < 8; i++) {
					int nx = x+dhx[i];
					int ny = y+dhy[i];
					if(nx<0|| ny<0 || nx >= R || ny >=C) continue;
					if(map[nx][ny]==1)continue;
					if(visited[nx][ny][k+1]) continue;
					visited[nx][ny][k+1]=true;
					q.add(new int[] {nx,ny,k+1,tr+1});
				}
			}
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0|| ny<0 || nx >= R || ny >=C) continue;
				if(map[nx][ny]==1)continue;
				if(visited[nx][ny][k]) continue;
				visited[nx][ny][k]=true;
				q.add(new int[] {nx,ny,k,tr+1});
			}

		}
			System.out.print(result);
	}

}
