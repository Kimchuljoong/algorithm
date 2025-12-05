import java.io.BufferedReader;
import java.util.*;

/**
 * 문제 링크: https://www.acmicpc.net/problem/1939
 * 문제 난이도: 골드 3
 * 문제 풀이:
 * 이분 탐색 and DFS
 */

/**
 * 예제 입력
 * 3 3
 * 1 2 2
 * 3 1 3
 * 2 3 2
 * 1 3
 */

public class Boj1939 {

    static int n;
    static int m;
    static Map<Integer, List<Node>> arr = new HashMap<>();

    static boolean[] visited;

    static int s;
    static int d;

    static int sv = 1;
    static int mv = 0;

    static int ttt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());

            if (t > mv) {
                mv = t;
            }
            if(arr.containsKey(a)) {
                arr.get(a).add(new Node(b, t));
            } else {
                arr.put(a, new ArrayList<>());
                arr.get(a).add(new Node(b, t));
            }

            if(arr.containsKey(b)) {
                arr.get(b).add(new Node(a, t));
            } else {
                arr.put(b, new ArrayList<>());
                arr.get(b).add(new Node(a, t));
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken()) - 1;
        d = Integer.parseInt(st.nextToken()) - 1;

        while (sv <= mv) {
            ttt = 0;
            visited = new boolean[n];

            int md = (sv + mv) / 2;
            go(s, md);

            if (ttt != 0) {
                sv = md + 1;
            } else {
                mv = md - 1;
            }
        }

        System.out.println(mv);

    }

    public static void go(int t, int w) {
        if (t == d) {
            ttt = w;
            return;
        }

        visited[t] = true;

        for (Node node : arr.get(t)) {
            if (!visited[node.to] && node.weight >= w) {
                go(node.to, w);
            }
        }
    }

    static class Node {
        int to;
        boolean visited = false;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}