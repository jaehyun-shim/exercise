import java.util.Scanner;

/**
 * @author seungeuncho
 * @since 2016-09-27
 */
public class Dfs {

    public static int size;
    public static int count;
    public static int start;
    public static int[][] adj;
    public static int[] visit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        count = scanner.nextInt();
        start = scanner.nextInt();
        adj = new int[count][count];
        visit = new int[count];

        for (int i = 0; i < count; i++) {
            int t1 = scanner.nextInt();
            int t2 = scanner.nextInt();
            adj[t1][t2] = adj[t2][t1] = 1;

        }

        dfs(start);

    }

    private static void dfs(int start) {
        visit[start] = 1;
        for (int i = 1; i <= size  ; i++) {
             if(adj[start][i] == 1 && visit[i] != 1) {
                 System.out.println(start + " -> "+ i);
                 dfs(i);
             }

        }
    }
}
