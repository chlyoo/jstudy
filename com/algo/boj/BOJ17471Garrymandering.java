package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17471Garrymandering {

	private static int N;
	private static int[] population;
	private static int[][] adjMatrix; //인접행렬 
	private static boolean[] selected; //부분집합 생성을 위한 배열 
	private static boolean[] visited; //bfs 방문 처리를 위한 배열 
	private static ArrayList<Integer> area1,area2; 
	private static int t; //부분집합 갯수를 카운트 
	private static Queue<Integer> q;//큐를 전역으로 미리 선언 
	private static int result;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		//인구 입력 받기 
		for (int i = 0; i < N; i++) {
			population[i]= Integer.parseInt(st.nextToken());
		} //
		//그래프 입력받기
		adjMatrix = new int[N][N];
		for (int from = 0; from < N; from++) {
			st = new StringTokenizer(br.readLine());
			int conn = Integer.parseInt(st.nextToken());
			for (int j = 0; j < conn; j++) {
				int dest = Integer.parseInt(st.nextToken())-1; //인덱스를 0부터 시작하기위해 -1 해줌
				adjMatrix[from][dest] = 1;
				adjMatrix[dest][from] = 1;
			}
		}//graph 입력 완료 
		selected = new boolean[N];
		area1 = new ArrayList<>();
		area2 = new ArrayList<>();
		//	부분집합으로 구획을 나눈다.
		visited = new boolean[N];
		q = new LinkedList<>();
		result=Integer.MAX_VALUE;
		powerset(0);
		System.out.println(result==Integer.MAX_VALUE?-1:result); //값이 안바뀐 경우 = -1출력
	}
	//부분집합을 이용해 그룹을 나누어 준다.
	private static void powerset(int cnt) {
		if(cnt==N) {
			if((1<<(N-1)) < t) return; //중복되는 경우를 제거하기 위해t값을 비교
			t++;
			//전역변수이기 때문에 초기화
			area1.clear(); 
			area2.clear();
			for (int i = 0; i < N; i++) {
				if(selected[i]) //부분집합에서 선택된건 그룹1 
					area1.add(i);
				else			//선택 안된건 그룹2
					area2.add(i);
			}
			if(area1.size()==0 || area1.size()==N) return;
			if(connectedGroup()) {
				result = Math.min(popDiff(), result);
			}
			return;
		}
		selected[cnt]=true;
		powerset(cnt+1);
		selected[cnt]=false;
		powerset(cnt+1);
	}
	//그룹의 인구를 계산해서 차이를 반환
	private static int popDiff() {
		int g1 =0, g2=0;
		for (int is : area1) {
			g1+= population[is];
		}
		for (int is : area2) {
			g2+= population[is];
		}
		return Math.abs(g2-g1);
	}
	//연결여부를 bfs로 확인해서 반환 
	private static boolean connectedGroup() {
		Arrays.fill(visited, false);
		q.offer(area1.get(0));
		visited[area1.get(0)]=true;
        int cnt = 1;
		while (!q.isEmpty()) {
			int t = q.poll();
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[t][i]==1 &&area1.contains(Integer.valueOf(i))) {
					visited[i]=true;
					q.offer(i);
                    cnt++;
				}
			}
		}
		if(cnt!=area1.size()) return false;
		q.offer(area2.get(0));
		visited[area2.get(0)]=true;
        cnt++;
		while (!q.isEmpty()) {
			int t = q.poll();
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[t][i]==1 &&area2.contains(Integer.valueOf(i))) {
					visited[i]=true;
					q.offer(i);
                    cnt++;
				}
			}
		}
		if(cnt!=area1.size()+area2.size()) return false;
		return true;
	}

}
