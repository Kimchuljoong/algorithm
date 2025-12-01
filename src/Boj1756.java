import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제 링크: https://www.acmicpc.net/problem/1756
 * 문제 난이도: 골드 5
 * 시간복잡도: O(D+N)
 * 문제 풀이:
 * 피자 반죽이 넓이가 다른 오븐에 들어가게 되면 반죽이 들어갈 수 있는 오븐의 넓이는 직전 오븐의 넓이보다 넓을 수 없다
 * 따라서 오븐을 위 규칙에 맞게 넓이를 조정한 후 오븐 배열의 역순으로 피자 반죽과 비교하여 계산한다
 */

/**
 * 예제 입력
 * 7 3
 * 5 6 4 3 6 2 3
 * 3 2 5
 */

public class Boj1756 {

    static int d;
    static int n;
    static List<Integer> oven = new ArrayList<>();
    static List<Integer> pizza = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        init();

        int lastPosition = 0;
        for (int i = d-1; i >= 0; i--) {

            if (pizza.get(0) <= oven.get(i)) {
                lastPosition = i;
                pizza.remove(0);
            }
            if (pizza.isEmpty())
                break;
        }

        System.out.println(pizza.isEmpty() ? lastPosition + 1 : 0);

    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < d; i++) {
            int depth = Integer.parseInt(st.nextToken());
            if (i > 0) {
                depth = Math.min(depth, oven.get(i-1));
            }
            oven.add(depth);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pizza.add(Integer.parseInt(st.nextToken()));
        }
    }
}
