import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] A, tmp;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = new int[n + 1];
        tmp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        merge_sort(1, n);
        System.out.println(result);
    }

    private static void merge_sort(int s, int e) {
        if(e - s < 1)
            return;

        int m = s + (e - s) / 2;
        merge_sort(s, m);
        merge_sort(m + 1, e);
        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;

        while(index1 <= m && index2 <= e) {
            if(tmp[index1] > tmp[index2]){
                A[k] = tmp[index2];
                //여기! 앞으로 이동한 거리만큼 더해주기!!
                result = result + index2 - k;
                k++;
                index2++;
            }else{
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }

}
