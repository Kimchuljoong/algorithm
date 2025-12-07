import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 링크: https://www.acmicpc.net/problem/1743
 * 문제 난이도: 실버 1
 * 문제 풀이:
 * DFS
 */

/**
 * 예제 입력
 * 3 4 5
 * 3 2
 * 2 2
 * 3 1
 * 2 3
 * 1 1
 */

public class Boj1743 {

    static int[][] arr;
    static int n;

    static int a;
    static int b;

    static int tr = 0;
    static int result = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[a+1][b+1];

        for (int i = 0; i < n; i++) {
            String l = br.readLine();
            st = new StringTokenizer(l);

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
        }

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (arr[i][j] == 0) continue;
                tr = 1;
                go(i, j);
                if (result < tr) result = tr;
            }
        }

        System.out.println(result);
    }

    public static void go(int x, int y) {
        arr[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx >=1 && xx <= a && yy >=1 && yy <= b && arr[xx][yy] == 1) {
                go(xx, yy);
                tr++;
            }
        }
    }
}
