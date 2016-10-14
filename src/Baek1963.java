import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author seungeuncho
 * @since 2016-09-28
 */
public class Baek1963 {


    public static int num;
    public static int[][] numArr;
    public static ArrayList<Integer[][]> numList;
    public static int[] primeArr;
    public static int[] visit;
    public static int[] total;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        visit= new int[10000];
        primeArr= new int[10000];

        total = new int[10000];
        ArrayList<Integer> primeNum = getPrimeNum();

        numArr = new int[num][num];
        numList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int t1 = scanner.nextInt();
            int t2 = scanner.nextInt();

            total[i] = bfs(t1, t2);
            System.out.println("-------------------------------- " + total[i]);
        }

    }

    private static int bfs(int t1, int t2) {


        visit[t1] = 1;
        Queue queue = new LinkedList<Integer>();
        System.out.println("t1 : "+t1);
        queue.add(t1);

        int[][] arr = new int[10000][10000];
        LinkedList<Integer> arr2 = new LinkedList<>();

        int compare = 0;
        int a =10000;
        int aaaaaaa= 0;
        while(!queue.isEmpty()) {
            int q = (int)queue.poll();
//            System.out.println("queue size ?  : "+queue.size());
            if(q == t2) {
                System.out.println("here? total :   " +total[t2] + "  queue  : "+q);

                int i = t2;
                while(i>0) {
                    for (int j : arr[i]) {
                        if(j>0) {
                            System.out.println("int  : " + j);
                            i = j;
                        }
                    }
                }

                return total[t2];
            }
            for (int i = 1; i <= 1000; i*=10) {
//                System.out.println("i  : "+ i);
                compare = q - ((q/i)%10) * i;
//                System.out.println("-------quueue  : "+q + " q/i %10 : " + (q/i)%10   + " i  : "+ i + " compare : "+ compare);
//                if(compare >= 1000) {
//                    System.out.println("compare : " + compare);
                    for (int j = 0; j <= 9; j++) {
//                        System.out.println("-----------------------------------------------------------------");
//                        System.out.println("j*i : " + j*i+"comp : "+ compare +  " total  : "+ total);
                        int data = j*i+ compare;
//                        System.out.println("data : "+data+  " i : "+ i  +  " j  : "+ j);
//                        System.out.println("comp : "+ compare);
                        if(data > 10000) break;
//                        if(data == t2) {
//                            total = queue.size();
//                            return total;
//                        }
                        if (primeArr[data] == 1 && visit[data] != 1) {

                            queue.add(data);
                            visit[data] = 1;
                            total[data] = total[q] +1;
                            arr[data][aaaaaaa] = q;
                            aaaaaaa++;
                            if(q == 8171 || q == 1171 || q == 1151 || q == 1051 || q == 1031 || q == 1033 || data == 8171 || data == 1171 || data == 1151 || data == 1051 || data == 1031 || data == 1033 ) {
                                System.out.println("q : " + q + " data  : " + data + " total [q]+1  : " + total[data]);
                            }

                        }

                    }
//                int[] ints = numArr[i];

            }


//            System.out.println("while?"  + a);
        }

        return a;
    }

    private static ArrayList<Integer> getPrimeNum() {
        ArrayList<Integer> primeNum = new ArrayList<>();
        ArrayList<Integer> primeNumResult = new ArrayList<>();
        primeNum.add(2);

        for (int i = 3; i < 10000; i++) {
            for (int j = 0; j < primeNum.size(); j++) {
                 if(i%primeNum.get(j) == 0) break;

//                System.out.print(j+1);
//                System.out.println(" primeNum size  : "+primeNum.size()  + " i : "+ i);
                if(j+1 == primeNum.size()) {
                    primeNum.add(i);
                    if(i > 999 ) {
                        primeNumResult.add(i);
                        primeArr[i] = 1;
                    }
                }

            }

        }
        return primeNumResult;
    }
}
