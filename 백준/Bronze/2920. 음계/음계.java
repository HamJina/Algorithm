import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        boolean ascending = true;
        boolean descending = true;
        //배열 채우기
        for(int i = 0; i < 8; i++) {
            int m = sc.nextInt();
            if(ascending && m != i +1) {
               ascending = false;
           } else if(descending && m != 8 - i) {
               descending = false;
           }
        }

        if(ascending) System.out.println("ascending");
        else if(descending) System.out.println("descending");
        else System.out.println("mixed");

    }
}
