import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //1~n까지의 숫자 배열 생성
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        //배열 정렬하기, 투포인터는 정렬된 배열에서 사용가능
        Arrays.sort(nums);

        int count = 0;
        int left = 0;
        int right = n-1;
        while(left < right) {
            if(nums[left] + nums[right] < m) {
                left++;
            } else if(nums[left] + nums[right] > m) {
                right--;
            } else {
                count++;
                left++;
            }
        }

        System.out.println(count);
    }
}
