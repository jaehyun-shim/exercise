import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author seungeuncho
 * @since 2016-02-22
 */
public class TestMain {

    static int a ;
    static int[] isVisits;
    static int[][] arr;
    static int[][] result;
    static int[][] isVisits2;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        System.out.println("first: " + a);
        arr = new int[a][a];
        result = new int[a][a];
        isVisits2 = new int[a][a];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }


        for(int i =0; i< a ; i ++) {
            System.out.println("222");
            BFS(i);
            pathCheck(i);
        }
//        bfs(0);
        printArr(result);
    }

    private static void BFS(int i) {
        isVisits = new int[a];
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
//        isVisits[i] = 1;

        while(!q.isEmpty()) {
            i = (int) q.poll();
            for (int j = 0; j < a; j++) {
                if(arr[i][j] == 1 && isVisits[j] == 0) {
                    isVisits[j] = 1;
                    isVisits2[i][j] = 1;
                    q.add(j);
                }

                System.out.println("i: "+ i + " // j : "+ j +" // arr[i][j] : "+ arr[i][j] + " is Visits[j] :" + isVisits[j]);
                System.out.println(isVisits2[i][j]);

            }

        }
    }

    private static void printArr(int[][] result) {
        for (int i = 0; i< result.length; i++) {
            for (int j = 0; j< result.length; j++) {
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private static void pathCheck(int i) {
        for(int j = 0; j<a; j++ ){
            System.out.println("----------path i  :  j  "+ i + " : "+ j  );
            if(isVisits[j]==1) {
                System.out.println("visited !!!!!!!!!!!!!!");
                result[i][j] = 1;
                isVisits[j]=0;
            }
        }
    }
/*
    private static void bfs(int i) {

        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while(!q.isEmpty()) {
            i = q.poll();
            for (int j = 0; j < a; j++) {
                System.out.println("i: "+ i + " // j : "+ j +" // arr[i][j] : "+ arr[i][j] + " is Visits[j] :" + isVisits[j]);
                if(arr[i][j] == 1 && isVisits[j] == 0) {
                    isVisits[j] = 1;
                    q.add(j);
                }

            }

        }


    }
    */


}

