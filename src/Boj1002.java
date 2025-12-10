import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 링크: https://www.acmicpc.net/problem/1002
 * 문제 난이도: 실버 3
 * 문제 풀이:
 * 두 원간의 거리를 이용하면 된다
 */

/**
 * 예제 입력
 * 3
 * 0 0 13 40 0 37
 * 0 0 3 0 7 4
 * 1 1 1 1 1 5
 */

public class Boj1002 {

    static int t;
    static Point[] pjs;
    static Point[] pbs;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        pjs = new Point[t];
        pbs = new Point[t];

        for (int i = 0; i < t; i++) {
            String l = br.readLine();
            st = new StringTokenizer(l);

            pjs[i] = new Point(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
            pbs[i] = new Point(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        for (int i = 0; i < t; i++) {
            System.out.println(go(pjs[i], pbs[i]));
        }

    }

    public static int go(Point a, Point b) {

        double diff = Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
        double maxR = a.r + b.r;
        double minR = Math.abs(a.r - b.r);

        if (diff == 0 && a.r == b.r) {
            return -1;
        } else if (diff == maxR || diff == minR) {
            return 1;
        } else if (diff > minR && diff < maxR) {
            return 2;
        } else {
            return 0;
        }
    }

    public static class Point {
        int x;
        int y;
        int r;

        Point(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

    }
}
