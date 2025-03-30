import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        mData[] A = new mData[n];

        for (int i = 0; i < n; i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(A);

        int Max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            A[i].index = A[i].index - i;
            if(Max < A[i].index) Max = A[i].index;
        }

        System.out.println(Max + 1);
    }

    public static class mData implements Comparable<mData>{
        int num;
        int index;

        public mData(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(mData o) {
            return this.num < o.num ? -1 : (this.num == o.num ? 0 : 1);
        }
    }
}
