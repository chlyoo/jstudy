package _0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 궁수는 항상 3명
 * 궁수의 위치  = map[N][?] N+1번째 행에 있음
 * 적을 맵에다가 위치시키기
 * 궁수의 위치를 조합을 이용해서 mC3 형태로 배치시키기
 * 각 배치마다 최대로 처리 가능한 적 계산
 * 최대 처리가능한 적의 최대값을 출력
 */
public class BOJ17135Castle {

	private static int N, M, D;
	static int[] pos =new int[3];//궁수의 위치
	private static char[][] map, map2;
	private static int eli;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		//N , M, D
		N = Integer.parseInt(st.nextToken()); //행의 수
		M =Integer.parseInt(st.nextToken()); //열의 수
		D =Integer.parseInt(st.nextToken()); //궁수의 공격제한 거리
		map = new char[N][M]; // N+1 번 행에는  모든 칸에 성
		map2 = new char[N][M]; // 복사한 배열
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0, k =0; j < M; j++, k+=2) {
				map[i][j] = line.charAt(k);
			}
		}
		eli = 0;
		combination(0,0 );
		System.out.print(eli);
	}
	//사정거리와 거리를 가지고 제거할 수 있는 적군의 수를 계산해서 리턴한다.
	private static void eliminate() {
		int attack = 0;
		Queue<int[]> list = new LinkedList<>();
		for (int k = 0; k < N; k++) { //행만큼 반복
			for (int i = 0; i < 3; i++) { //궁수마다 반복
				inner:for (int distance = 1; distance <= D; distance++) { //거리만큼 탐색해야함
				int posx= N; // 아쳐의 행
				int posy = pos[i]; //아쳐의 열
					//좌측 탐색
					for (int j2 = 1; j2 <= distance-1; j2++) { //거리 -1 번 반복
						if(posx-j2<0 || posy-distance+j2>=M ||posy-distance+j2<0 ) continue;
						if(map2[posx-j2][posy-distance+j2]=='1') {
							int[] temp = {posx-j2,posy-distance+j2};
							list.offer(temp);
							break inner;
						}
					}
					if(posx-distance < 0) continue;
					if(map2[posx-distance][posy]=='1') {
						int[] temp = {posx-distance, posy};
						list.offer(temp);
						break inner;
					}
					//우측탐색
					for (int j2 = 1; j2 <= distance-1; j2++) { //거리 -1 번 반복
						if(posx-(distance)+j2<0 || posx-(distance)+j2 >=N || posy+j2>=M ) continue;
						if(map2[posx-(distance)+j2][posy+j2]=='1') {
							int[] temp = {posx-(distance)+j2, posy+j2};
							list.offer(temp);
							break inner;
						}
					}
				}//거리 1부터 D까지 실행
			}//궁수마다 반복하는 for문
			//한줄 처리가 끝난 경우 큐에서 꺼내서 죽인사람++ 이미 죽은사람 -> map에서 0으로 변경
			while (!list.isEmpty()) {
				int[] is = list.poll();
				if(map2[is[0]][is[1]]!='0') {
					map2[is[0]][is[1]]='0';
					attack++;
				}
			}
			//배열 한칸아래로 이동
			for (int j = N-1; j >0;  j--) {
				System.arraycopy(map2[j-1], 0, map2[j], 0, M);
			}
			Arrays.fill(map2[0],'0');

		}//다음행
		eli = Math.max(attack, eli);
	}

	private static void combination(int cnt, int start) {
		if (cnt ==3) {
			for(int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, map2[i], 0, map2[i].length);
			}
			eliminate();
			return;
		}
		for (int i = start; i<M; i++) {
			pos[cnt]= i; 
			combination(cnt+1, i+1);
		}
	}
}