import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int count = 0;
    public static int k = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        //배열 채우기
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quick_sort(A,0, n-1);

        if(count < k) System.out.println("-1");
    }


    //퀵정렬 수행
    public static void quick_sort(int[] A, int p, int r) {
        if(p < r) {
            int q = partition(A, p, r);
            quick_sort(A, p, q - 1);
            quick_sort(A, q + 1, r);
        }
    }

    public static int partition(int[] A, int p, int r){
        int x = A[r]; //기준 원소(pivot)
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if(A[j] <= x) {
                swap(A, ++i, j);
            }
        }
        if(i + 1  != r) {
            swap(A, i + 1, r);
        }

        return i + 1;
    }

    public static void swap(int[] A,int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;

        count++;
        if (count == k) System.out.println(A[i] + " " + A[j]);
    }


}
