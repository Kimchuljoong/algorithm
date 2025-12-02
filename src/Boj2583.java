import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2583 {

    static int[][] arr;
    static int m;
    static int n;

    static int l;

    static int count = 0;

    static List<Integer> result = new ArrayList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Queue<Integer> xq = new LinkedList<>();
    static Queue<Integer> yq = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        arr = new int[m][n];

        for (int i = 0; i < l; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = y1; x < y2; x++) {
                for (int y = x1; y < x2; y++) {
                    arr[x][y] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count = 0;
                if (arr[i][j] == 0) {
                    count = 1;
                    go(i, j);
                }

                if (count != 0) {
                    result.add(count);
                }
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static void go(int x, int y) {

        arr[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx >=0 && xx < m && yy >=0 && yy < n && arr[xx][yy] == 0) {
                count += 1;
                go(xx, yy);
            }
        }
    }
}
