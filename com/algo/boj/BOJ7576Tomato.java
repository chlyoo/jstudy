package _04._0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576Tomato {
	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		List<Pos> ripe = new ArrayList<>();
		int nr =0; //no tomato
		int rcnt=0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				map[i][j] = tomato;
				if(tomato==1) {
					ripe.add(new Pos(i,j));
					rcnt++;
				}else if(tomato==0) {
					nr++;
				}
			}
		}//input
		int level=-1;
		Queue<Pos> q = new LinkedList<>();
		for (int i = 0; i < rcnt; i++) {
			q.offer(ripe.get(i));
		}
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = size; i >0; i--) {
				Pos temp = q.poll();
				int px = temp.x;
				int py = temp.y;
				for (int d = 0; d < 4; d++) {//4방 탐색
					int nx = px+dx[d];
					int ny = py+dy[d];
					if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
					if( map[nx][ny]!=0)continue;
					map[nx][ny] = 1;
					nr--;
					q.offer(new Pos(nx,ny));
				}
			}
			level++;
		}
		System.out.print(nr==0?level :-1);
	}//main

}
