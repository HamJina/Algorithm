import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            A.add(sc.nextInt());
        }
        Integer max = Collections.max(A);
        System.out.println(max);
        System.out.println(A.indexOf(max) + 1);

    }
}
