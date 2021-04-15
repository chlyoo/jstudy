package com.algo.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class SWEA5656Brick {
	static class Brick {
		int x, y, size;
		public Brick(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
	private static int[][] map, cmap;
	private static boolean[][] visited;
	private static int W, H, N, result;
	private static int[] pick;
	private static Stack<Brick> s;
	private static Queue<Integer> q;
	private static StringBuilder sb;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,-1,0,1};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		s = new Stack<>();
		q = new LinkedList<>();
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			pick = new int[N];
			map = new int[H][W];
			cmap = new int[H][W];
			visited = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < W; j++) {
					map[i][j] =  Integer.parseInt(st.nextToken());
				}
			}//input
			result=181;
			permutation(0);
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}//testCase 
		System.out.print(sb);
		br.close();

	}
	private static void permutation(int cnt) {
		if(cnt==N) {
			for (int i = 0; i < H; i++) {
				System.arraycopy(map[i], 0, cmap[i], 0, W);
			}
			for (int i = 0; i < N; i++) {
				remove(pick[i]);
				drop();
			}
			if(result==0) return;
			return;
		}
		for (int i = 0; i < W; i++) {
			pick[cnt]=i;			
			permutation(cnt+1);
		}
	}

	private static void drop() {
		int temp = 0;
		for (int i = 0; i < W; i++) {
			for (int j = 1; j <= H; j++) {
				int val = cmap[H-j][i];
				if(val>0) q.offer(val);
				cmap[H-j][i]=0;
			}
			int size = q.size();
			temp+=size;
			for (int j = 1; j <=size; j++) {
				cmap[H-j][i] = q.poll();
			}
		}
		result = Math.min(result, temp);

	}
	private static void remove(int col) {
		for (int i = 0; i < H; i++) {//초기
			Arrays.fill(visited[i], false);
		}
		for (int i = 0; i < H; i++) {
			if(cmap[i][col]>0) {
				s.push(new Brick(i, col, cmap[i][col]));
				break;
			}
		}
		while(!s.isEmpty()) {
			Brick temp = s.pop();
			for (int i = 0; i < temp.size; i++) { //벽돌 크기 만큼 터짐
				for (int d = 0; d < 4; d++) {
					int nx = temp.x+i*dx[d];
					int ny =  temp.y+i*dy[d];
					if(nx<0 || ny<0|| nx>=H || ny>=W) continue;
					if(visited[nx][ny] || cmap[nx][ny]==0)continue;
					visited[nx][ny]=true;
					s.push(new Brick(nx, ny, cmap[nx][ny]));
					cmap[nx][ny] =0;
				}
			}
		}
	}

}
