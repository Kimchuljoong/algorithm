import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제 링크: https://www.acmicpc.net/problem/1654
 * 문제 난이도: 실버 2
 * 문제 풀이:
 * 이분탐색을 통해 조건에 부합하는 최대 값을 찾는 문제
 * 조심해야할 것은 제약조건의 랜선의 최대 길이는 2^31-1 인데
 * 이분탐색을 위한 계산 과정에서 int의 최대 값을 초과할 수 있으므로 long 타입을 사용해야 한다
 */

/**
 * 예제 입력
 * 4 11
 * 802
 * 743
 * 457
 * 539
 */

public class Boj1654 {

    static int k;
    static int n;
    static long maxValue = 0;

    static List<Long> lans = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            long num = Long.parseLong(br.readLine());
            lans.add(num);

            if (maxValue < num) {
                maxValue = num;
            }
        }

        long left = 0;
        long right = maxValue + 1;
        long mid = 0;
        while(left < right) {
            mid = (right + left) / 2;
            long v = 0;

            for (long lan : lans) {
                v += (lan / mid);
            }

            if (v < n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right-1);

    }
}
