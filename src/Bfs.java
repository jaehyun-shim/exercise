import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import javax.xml.bind.SchemaOutputResolver;

/**
 * @author seungeuncho
 * @since 2016-09-27
 */
public class Bfs {

    public static int size;
    public static int count;
    public static int start;
    public static int[][] adj;
    public static int[] visit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정점 : 간선 : start");
        size = scanner.nextInt();
        count = scanner.nextInt();
        start = scanner.nextInt();
        visit = new int[count];
        adj = new int[count][count];

        for (int i = 0; i < count; i++) {
            System.out.println("int");
            int t1 = scanner.nextInt();
            int t2 = scanner.nextInt();
            System.out.println("t1 : t2" + t1 + " : " + t2);
            adj[t1][t2] = adj[t2][t1] = 1;
            
        }

        bfs(start);
    }

    private static void bfs(int v) {
        visit[v] = 1;
        Queue queue = new LinkedList<Integer>();
        queue.add(v);

        for (int i : visit) {
            System.out.println("visit " + i);
        }

        while(!queue.isEmpty()) {
            v = (int) queue.poll();
            System.out.println("-------");
            System.out.println("v : "+ v);
            System.out.println("-------");
            for (int i =1 ; i <=size ; i ++){
                if(adj[v][i] == 1&& visit[i] != 1){
                    visit[i] = 1;
                    queue.add(i);
                    System.out.println(v + " -> " + i);
                }
//                System.out.println("i: "+ i + " // v : "+ v +" // arr[v][i] : "+ adj[v][i] + " is Visits[i] :" + visit[i]);
            }
        }


    }
}
