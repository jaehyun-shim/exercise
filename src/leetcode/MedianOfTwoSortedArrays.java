package leetcode;

/**
 * @author seungeuncho
 * @since 2016-09-30
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
//        findMedianSortedArrays(nums1,nums2);
        findMedianSortedArrays2(nums1,nums2);
    }

    public static double findMedianSortedArrays2(int A[], int B[]) {
        int lengthA = A.length;
        int lengthB = B.length;
        if ((lengthA + lengthB) % 2 == 0) {
            double r1 = (double) findMedianSortedArrays2(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2);
            double r2 = (double) findMedianSortedArrays2(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2 + 1);
            return (r1 + r2) / 2;
        } else
            return findMedianSortedArrays2(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB + 1) / 2);
    }

    public static int findMedianSortedArrays2(int A[], int startA, int endA, int B[], int startB, int endB, int k) {
        int n = endA - startA;
        int m = endB - startB;
        System.out.println("startA : "+ startA+ " endA : " +endA+ " startB : "+startB+ " endB : " + endB + " k "+ k + " n : "+ n + " m  : "+ m);
        if (n <= 0) {
            System.out.println(" n<=0 " + B[startB + k - 1]);
            return B[startB + k - 1];
        }
        if (m <= 0){
            System.out.println(" m<=0 "+A[startA + k - 1]);
            return A[startA + k - 1];
        }

        if (k == 1) {
            System.out.println("k ==1 "+ (A[startA] < B[startB]));
            return A[startA] < B[startB] ? A[startA] : B[startB];
        }

        int midA = (startA + endA) / 2;
        int midB = (startB + endB) / 2;
        System.out.println("midA  : "+ midA +  " midB : "+ midB);

        if (A[midA] <= B[midB]) {
            if (n / 2 + m / 2 + 1 >= k) {
                System.out.println("1");
                return findMedianSortedArrays2(A, startA, endA, B, startB, midB, k);
            }
            else{
                System.out.println("2");
                return findMedianSortedArrays2(A, midA + 1, endA, B, startB, endB, k - n / 2 - 1);
            }
        } else {
            if (n / 2 + m / 2 + 1 >= k) {
                System.out.println("3");
                return findMedianSortedArrays2(A, startA, midA, B, startB, endB, k);
            }
            else {
                System.out.println("4");
                return findMedianSortedArrays2(A, startA, endA, B, midB + 1, endB, k - m / 2 - 1);
            }

        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length+nums2.length;
        if(total%2==0){
            System.out.println("total  : "+ total);
            return (findKth(total/2+1, nums1, nums2, 0, 0)+findKth(total/2, nums1, nums2, 0, 0))/2.0;
        }else{
            System.out.println("0 total  : "+ total);
            return findKth(total/2+1, nums1, nums2, 0, 0);
        }
    }

    public static int findKth(int k, int[] nums1, int[] nums2, int s1, int s2){
        System.out.println("---------------");
        System.out.println("s1  : "+ s1 + " s2 : "+ s2+ " k  : "+ k );
        if(s1>=nums1.length) {
            System.out.println("s1 > = " + nums2[s2 + k - 1]);
            return nums2[s2 + k - 1];
        }
        if(s2>=nums2.length){
            System.out.println("s 1 > = "+ nums1[s1+k-1]);
            return nums1[s1+k-1];
        }
        if(k==1) {
            System.out.println("k  == 1 "+ Math.min(nums1[s1], nums2[s2]));
            return Math.min(nums1[s1], nums2[s2]);
        }
        int m1 = s1+k/2-1;
        int m2 = s2+k/2-1;

        System.out.println(" m1  : "+ m1 + " m2  : "+ m2);

        int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;
        int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;

        System.out.println("mid  :  "+ mid1  +   "  mid 2 : "+ mid2);
        if(mid1<mid2){
            System.out.println(" ??");
            return findKth(k-k/2, nums1, nums2, m1+1, s2);
        }else{
            System.out.println("!!");
            return findKth(k-k/2, nums1, nums2, s1, m2+1);
        }
    }
}
