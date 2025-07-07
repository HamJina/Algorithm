import java.util.*;

public class Main {
    static class Material {
        int val;
        ArrayList<Integer> edge;
        Material() {
            val = 1;
            edge = new ArrayList<>();
        }
    }

    static Material[] arr;
    static int vis = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,a,b,p,q,gcdVal,amod,bmod;
        n = sc.nextInt(); // n개의 재료
        arr = new Material[n];
        for(int i=0;i<n;i++) { // 0~n-1번 요소들을 초기화 한다.
            arr[i] = new Material();
        }

        for (int i = 0; i < n-1; i++) {
            a = sc.nextInt(); b = sc.nextInt(); // a번 질량과 b번 질량
            p = sc.nextInt(); q = sc.nextInt(); // a번 질량 : b번 질량 = p : q
            gcdVal = gcd(p, q); // p와 q의 최대 공약수
            amod = arr[b].val * p / gcdVal; //비율을 맞추기 위해 기존 값들과 곱해질 값 계산.
            bmod = arr[a].val * q / gcdVal;
            gcdVal = gcd(amod, bmod);
            vis = 0;
            update(a, amod/gcdVal);
            update(b, bmod/gcdVal);
            arr[a].edge.add(b);
            arr[b].edge.add(a);
        }

        for(int i=0;i<n;i++) {
            System.out.print(arr[i].val + " ");
        }
    }

    public static int gcd(int a , int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void update(int node,int mod) { // DFS로 전체값을 갱신한다.
        arr[node].val *= mod;
        vis |= (1 << node);
        for (int e : arr[node].edge) {
            if ((vis & (1 << e)) == 0) {
                update(e, mod);
            }
        }
    }
}
