package _04._0412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA1249Supply {
	private static boolean[][] visited;
	private static int[] dx = {1,0,-1,0};		
	private static int[] dy = {0,1,0,-1};		
	private static int startx, starty,destx , desty, N;
	private static int[][] cmap, map;

	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_d4_1249.txt"));
		BufferedReader br = new BufferedReader(	new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
//			if(testCase<=4)continue;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String line =br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j)-'0';
				}
			}
			cmap = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(cmap[i], Integer.MAX_VALUE);
			}
			startx =  starty = 0;
			destx =  desty = N-1;
			System.out.println("#"+testCase+" "+bfs());
		}
	}

	private static int bfs() {
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {startx,starty});
		cmap[startx][starty] =0;
		visited[startx][starty] = true;
		while (!Q.isEmpty()) {
			int[] temp = Q.poll();
			int posx = temp[0];
			int posy = temp[1];
			for (int i = 0; i < 4; i++) {
				int tempx = posx +dx[i];
				int tempy = posy +dy[i];
				if(tempx <0 || tempy<0 || tempx>=N || tempy >=N) continue; //값이 범위를 벗어나는 경우 
				if(!visited[tempx][tempy]|| cmap[tempx][tempy]> map[tempx][tempy]+cmap[posx][posy]) { //방문했거나 || 값이 작은경우 
					visited[tempx][tempy] = true;
					cmap[tempx][tempy] = map[tempx][tempy]+cmap[posx][posy];
					Q.offer(new int[] {tempx,tempy});
				}
			}
		}
		return cmap[destx][desty];
	}
}
