/*
 * https://classroom.codingninjas.com/app/classroom/me/10327/content/173811/offering/2157972/problem/7217
 * 
 * Murder
Send Feedback
Once detective Saikat was solving a murder case. While going to the crime scene he took the stairs and saw that a number is written on every stair. He found it suspicious and decides to remember all the numbers that he has seen till now. While remembering the numbers he found that he can find some pattern in those numbers. So he decides that for each number on the stairs he will note down the sum of all the numbers previously seen on the stairs which are smaller than the present number. Calculate the sum of all the numbers written on his notes diary.
Answer may not fit in integer . You have to take long.
Input Format:
First line of input contains an integer T, representing number of test case.
For each test case, first line of input contains integer N, representing the number of stairs.
For each test case, second line of input contains N space separated integers, representing numbers written on the stairs.
Constraints
T<=10^5
1<=N<=10^5
All numbers will be between 0 and 10^9
Sum of N over all test cases doesn't exceed 5*10^5
Output Format
For each test case output one line giving the final sum for each test case.
Sample Input 1:
1
5
1 5 3 6 4
Sample Output 1:
15
Explanation:
For the first number, the contribution to the sum is 0.
For the second number, the contribution to the sum is 1.
For the third number, the contribution to the sum is 1.
For the fourth number, the contribution to the sum is 9 (1+5+3).
For the fifth number, the contribution to the sum is 4 (1+3).
Hence the sum is 15 (0+1+1+9+4).
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.InputStreamReader;

public class Solution {
    static long merge(int arr[], int s, int m, int e) {
        int[] t = new int[e - s + 1];
        int il = s;
        int ir = m;
        int k = 0;
        long sum = 0;
        while (il < m && ir <= e) {
            if (arr[il] < arr[ir]) {
                long times = (e - ir + 1);
                sum += times * arr[il];
                t[k] = arr[il++];

            } else {

                t[k] = arr[ir++];
            }
            k++;
        }
        while (il < m) {
            t[k++] = arr[il++];
        }
        while (ir <= e) {
            t[k++] = arr[ir++];
        }
        k = 0;
        for (int i = s; i <= e; i++) {
            arr[i] = t[k++];
        }
        return sum;
    }

    static long ms(int[] arr, int s, int e) {
        if (s >= e) {
            return 0;
        } else {
            int mid = s + (e - s) / 2;
            long left = ms(arr, s, mid);
            long right = ms(arr, mid + 1, e);
            long mer = merge(arr, s, mid + 1, e);
            return left + right + mer;
        }
    }

    public static void main(String[] args) throws IOException {
        /*
         * Your class should be named Solution.
         * Read input as specified in the question.
         * Print output as specified in the question.
         * Write your code here
         */

        // Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long ans = ms(arr, 0, n - 1);

            // for(int x:arr){
            // System.out.print(x+" ");
            // }
            // System.out.print(" - ");
            System.out.println(ans);
        }
    }

}
