import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 링크: https://www.acmicpc.net/problem/1049
 * 문제 난이도: 실버 4
 * 문제 풀이:
 * 셋트 가격과 한개 가격의 최솟값을 각각 구하고 6개(셋트)로 나눈 몫과 나머지를 이용해서 문제를 풀면 된다
 * 셋특 가격은 낱개 * 6개의 가격과 셋트 가격 중 작은 값을 셋트 가격으로 한다
 * 6개로 나눈 나머지의 값을 낱개로 사는 것과 셋트 1개를 사는 것 중 작은 값을 구해야한다
 */

/**
 * 예제 입력
 * 15 1
 * 100 40
 */

public class Boj1049 {

    static int n;
    static int m;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int minSetValue = Integer.MAX_VALUE;
        int minOneValue = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            minSetValue = Math.min(minSetValue, Math.min(v1, 6 * v2));
            minOneValue = Math.min(minOneValue, v2);
        }

        int result = (minSetValue * (n / 6));
        if (n % 6 > 0) {
           result += Math.min((n % 6) * minOneValue, minSetValue);
        }

        System.out.println(result);
    }
}
