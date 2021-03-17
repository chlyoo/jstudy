package com.algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution{
	private static int[][] map;
	private static int N;
	private static int[][] core;
	private static int corecount;
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			N= Integer.parseInt(br.readLine());
			map = new int[N][N];
			core =new int[12][2];
			corecount = 0;
			for (int i = 0; i < map.length; i++) {
				String line = br.readLine();
				for (int j = 0, k=0; j < map.length; k+=2,j++) {
					int temp = line.charAt(k)-'0';
					map[i][j]= temp;
					if(temp==1 && i!=0 && i!=N-1 && j!=0 && j!=N-1) {
						core[corecount][0]= i;
						core[corecount++][1]= j;
					}
				}//innermap for
			}//map for
			minLine = Integer.MAX_VALUE;
			maxcore = Integer.MIN_VALUE;
			copymap = new int[N][N];
			connect(0,0);
			System.out.println("#"+testCase+" "+minLine);
		}//testCase
	}
	private static int[] dx = {-1,0,1,0};
	private static int[] dy = {0,-1,0,1};
	private static int[][] copymap;
	private static int minLine;
	private static int maxcore;

	private static void connect(int start, int cnt) {
		if(start==corecount) {
			if(cnt<maxcore) return;
			int count = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(copymap[i][j]==2) {
						count++;
					}
				}
			}
			if(cnt>maxcore) {
				maxcore = cnt;
				minLine = count;
			}else if(cnt==maxcore) {
				minLine = Math.min(count, minLine);
			}

		}		
		for (int k = 0; k < copymap.length; k++) {
			System.arraycopy(map, 0, copymap, 0, N);
		}
		for (int i = start; i < corecount; i++) { //각 코어별로
			int posx =core[i][0];
			int posy =core[i][1];
			//4방향에 대해서 탐색
			for (int j = 0; j < 4; j++) {
				if(!checkLine(posx, posy, j, copymap)) {//갈수 없는 방향이라면
					continue;
				}
				//갈수 있다면 값을 바꿔줘야한다.
				markLine(posx,posy,j, copymap);
				connect(i+1, cnt+1);
				//가지 않는다면 원래대로 고쳐준다.
				celanLine(posx,posy,j,copymap);
			}
			connect(i+1, cnt);
		}

	}
	private static void celanLine(int x, int y, int dir, int[][] map) {
		while(x>0 && x<N-1 && y>0 && y<N-1) {
			x+= dx[dir];
			y+= dy[dir];
			map[x][y]=0;
		}

	}
	private static void markLine(int x, int y, int dir, int[][] map) {
		while(x>0 && x<N-1 && y>0 && y<N-1) {
			x+= dx[dir];
			y+= dy[dir];
			map[x][y]=2;
		}

	}
	//끝까지 갈 수 있으면 true 없으면 false를 리턴
	private static boolean checkLine(int x, int y, int dir, int[][] copymap) {
		while(x>0 && x<N-1 && y>0 && y<N-1) {
			x+= dx[dir];
			y+= dy[dir];
			if(copymap[x][y]!=0) { //maP의 값이 0이 아닌 경우 = 코어 또는 전선이 있는 경우
				return false;
			}
		}
		return true;
	}
}