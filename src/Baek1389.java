import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author seungeuncho
 * @since 2016-09-27
 */
public class Baek1389 {
    public static int user;
    public static int friend;
    public static int[][] adj;
    public static int[] visit;
    public static int[] dist;
    public static int[] prev;
    static Vector<Integer> steps = new Vector<Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        user = scanner.nextInt();
        friend = scanner.nextInt();
        adj = new int[user+1][user+1];
        visit = new int[user+1];
        dist = new int[user+1];
        prev = new int[user+1];
        Arrays.fill(dist,999999);

        for (int i = 0; i < user; i++) {
            int u1 = scanner.nextInt();
            int f1 = scanner.nextInt();
            adj[u1][f1] = adj[f1][u1] = 1;
            
        }

        result(1,user);

        makingPath(0,user,user);

        System.out.print("최종경로 = ");
        for(int node : steps){
            System.out.print(node + " ");
        }

        System.out.println();

        System.out.print("각 노드의 최적 누적거리 = ");
        for(int d : dist){
            System.out.print(d + " ");
        }




    }

    private static int result(int s, int f) {
        if(s == f) {
            return dist[f];

        }
        int min =99999 ;
        for (int i = 0; i < friend; i++) {
            if(adj[s][i] == 1 && visit[i] != 1) {
                if(dist[i] > dist[s] + adj[s][i]) {
                    dist[i] = dist[s] + adj[s][i];
                    prev[i] = s;
                }
                System.out.println(dist[s] + ":"+adj[s][i]);
                System.out.println("dist : " + dist[min] + " : "+ dist[i]);
                if(min>dist[i]) {
                    min = i;
                }
                System.out.println(min);
            }

        }

        result(min,f);

        return 0;

    }

    public static void makingPath(int start, int end, int node){
        if(node == start){
            steps.add(node);
            return;
        }

        makingPath(start, end, prev[node]);
        steps.add(node);

    }
}
