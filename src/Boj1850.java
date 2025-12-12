import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제 링크: https://www.acmicpc.net/problem/1850
 * 문제 난이도: 실버 1
 * 문제 풀이:
 * 최대공약수 문제
 */

/**
 * 예제 입력
 * 500000000000000000 500000000000000002
 */

public class Boj1850 {

    static long a;
    static long b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        long t = gcd(a, b);

        for (long i = 0; i < t; i++) {
            bw.write("1");
        }
        bw.flush();
    }

    public static long gcd(long n1, long n2) {
        long t;
        while(n1 % n2 != 0) {
            t = n1 % n2;
            n1 = n2;
            n2 = t;
        }

        return n2;
    }
}
