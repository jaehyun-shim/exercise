/**
 * @author seungeuncho
 * @since 2016-10-04
 */
import java.util.Vector;

public class Test {


    int n = 0; // 정점의 갯수

    final static int m = 30000; // 선이 없는 곳... 무지 큰수로 설정
    int data[][];	// 전체 지도 데이타

    boolean visit[]; // 방문지 확인
    int dis[]; // 시작점 부터의 거리
    int prev[]; // 도착점 전의 정점 저장

    int s,e;  // 시작점과 끝점 저장
    int stack[]; // 시작점부터 끝점까지의 순서 저장

    Vector<Integer> stackV;

    public void init(int dataI[][]) // 다익스트라(Dijkstra) 알고리즘/단일 점에 따라 최단거리
    {
        data=dataI;
        n = data.length;

        dis = new int[n];
        visit = new boolean[n];
        prev = new int[n];
        stack = new int[n];
        stackV=new Vector<Integer>();
    }

    public int theLeastDistance()
    {
        return dis[e-1];
    }

    public void start(int start,int end)
    {
        System.out.println("=========================================================="); // Test Addpend..
        System.out.println("Dijkstra start");
        System.out.println("startPoint: "+start);
        System.out.println("endPoint: "+end);
        System.out.println("===========================================================");
        s=start;
        e=end;

        int k=0;
        int min=0;



        for (int i = 0; i < n; i++) { /* 초기화 */
            dis[i] = m;
            prev[i] = 0;
            visit[i] = false;
        }

        dis[s - 1] = 0; /* 시작점의 거리는 0 */

        for (int i = 0; i < n; i++) {
            min = m;
            for (int j = 0; j < n; j++) { /* 정점의 수만큼 반복 */
//                System.out.println(" false? " + (visit[j] == false) + "  cal : "+ (dis[j] < min) + "  dis  : "+ dis[j]+   " min : "+ min);
                if (visit[j] == false && dis[j] < min) { /* 확인하지 않고 거리가 짧은 정점을 찾음 */
                    k = j;
                    min = dis[j];
//                    System.out.println("i : "+ i + " j   "+ j + " min " + min );
                }
            }
            visit[k] = true; /* 해당 정점 확인 체크 */

            if (min == m)break; /* 연결된 곳이 없으면 종료 */

            /****
             * I -> J 보다 I -> K -> J의
             * 거리가 더 작으면
             * 갱신
             ****/
//            System.out.println("-------------------------");
            for (int j = 0; j < n; j++) {
//                System.out.println(" dis[k] + data[k][j] " + (dis[k] + data[k][j]) + " dis[j]"+ dis[j] );
                if (dis[k] + data[k][j] < dis[j]) {
//                    System.out.println(" hmm ?  k   " + k+  "  j : " + j + " dis[k] + data[k][j] " + (dis[k] + data[k][j]) + " dis[j]"+ dis[j] );

                    dis[j] = dis[k] + data[k][j]; /* 최단거리 저장*/
                    prev[j] = k; /* J로 가기 위해서는 K를 거쳐야 함 */
                }
            }
//            System.out.println("-------------------------");
        }
        //	nowLeastDistance();   //콘솔에서 최단거리 출력
        inverseFind();			// 콘솔에서 최단 경로 출력
    }

    /**** 최단 거리 출력 ****/
    public void nowLeastDistance()
    {
        System.out.printf("최단거리:  %10d       ", dis[e - 1]);
    }

    /**** 최단 경로를 저장 ****/
    public void inverseFind()
    {
        int tmp = 0;
        int top = -1;
        tmp = e - 1;
        System.out.println("-----------------");
        while (true) {
            stack[++top] = tmp + 1;
            if (tmp == s - 1)break; /* 시작점에 이르렀으면 종료 */

            System.out.println("s   : "+ s +  " tmp  : " + tmp + " top : "+ top );
            tmp = prev[tmp];
            System.out.println(" prev : "+ prev[tmp] +" tmp : "+ tmp);
        }

		/* 역추적 결과 출력 */
        stackV.removeAllElements();
        for (int i = top; i > -1; i--) {
            System.out.printf("%d", stack[i]);
            stackV.add(stack[i]);
            if (i != 0)System.out.printf(" -> ");
        }
        //System.out.printf("\n");
    }

    public Vector<Integer> getStack()
    {
        return stackV;
    }




    public static void main(String[] args) {
        int m=30000;
        int [][]data = new int[][] {
                { 0, 2, m, m, m, 3, m, m },
                { 2, 0, 4, 1, m, m, m, m },
                { m, 4, 0, m, m, m, 3, m },
                { m, 1, m, 0, 3, m, 2, m },
                { m, m, 3, 3, 0, m, m, 4 },
                { 3, m, m, m, m, 0, 6, m },
                { m, m, m, 2, m, 6, 0, 4 },
                { m, m, m, m, 4, m, 4, 0 } };
        Test k=new Test();
        k.init(data);
        k.start(1,3);
    }

}

