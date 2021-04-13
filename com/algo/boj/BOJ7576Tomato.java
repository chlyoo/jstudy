package _04._0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576Tomato {
	static class Pos{//좌표 정보 저장을 위한 클래
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
		List<Pos> ripe = new ArrayList<>();//익은 토마토의 좌표를 저장할 리스트
		int nr =0; // 덜익은 토마토 개수
		int rcnt=0; //for문을 돌리기 위해서 익은 토마토 개수저장
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				map[i][j] = tomato; //map에 토마토 정보를 저장
				if(tomato==1) {
					ripe.add(new Pos(i,j)); //익은 토마토 정보 저장 
					rcnt++; //익은 토마토 개수 증가
				}else if(tomato==0) {
					nr++; //익어야 하는 토마토 수 증가
				}
			}
		}//input
		int level=-1; //시작하자마자 레벨이 증가하므로 
		Queue<Pos> q = new LinkedList<>();
		for (int i = 0; i < rcnt; i++) {
			q.offer(ripe.get(i));
		}
		while (!q.isEmpty()) {
			int size = q.size(); //같은 단계에 있는 익은 토마토를 처리하기 위해 for문으로 묶었다.
			for (int i = size; i >0; i--) {
				Pos temp = q.poll();
				int px = temp.x;
				int py = temp.y;
				for (int d = 0; d < 4; d++) {//4방 탐색
					int nx = px+dx[d]; //dx dy를 이용하여 4방의 좌표 계산
					int ny = py+dy[d];
					if(nx<0 || ny<0 || nx>=R || ny>=C) continue; //범위를 벗어나는 경우
					if( map[nx][ny]!=0)continue;//토마토가 이미 익거나, 없는경우
					map[nx][ny] = 1;
					nr--; //익어야 하는 토마토 개수를 감소 
					q.offer(new Pos(nx,ny));
				}
			}
			level++; //for문이 1번 끝나면 레벨이 증가 
		}
		System.out.print(nr==0?level :-1); //덜익은 토마토 개수가 0개이면 레벨을 출력 
		//덜익은 토마토가 있으면 -1 출력 
	}//main
}
