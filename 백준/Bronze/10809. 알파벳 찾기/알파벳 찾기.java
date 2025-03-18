import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String ss = sc.next();
        int[] result = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        char[] charArray = ss.toCharArray();

        for (int i = 0; i < ss.length(); i++) {
            if(result[charArray[i] - 'a'] == -1) result[charArray[i] - 'a'] = i;
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
