import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제 링크: https://www.acmicpc.net/problem/1515
 * 문제 난이도: 실버 2
 * 문제 풀이:
 * 숫자를 1부터 증가 시키면서 해당 숫자에 포함된 숫자들 이 주어진 숫자들에 포함되어있는지 체크하여
 * 주어진 숫자에 대해 전체 확인이되는 경우 그 숫서가 최소값
 * 설명이 어렵다..
 */

/**
 * 예제 입력
 * 234092
 */


public class Boj1515 {

    static String s;
    static char[] cs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        cs = s.toCharArray();

        int i = 0;
        int j = 0;

        while (true) {
            i++;
            char[] css = Integer.toString(i).toCharArray();
            for (int k = 0; k < css.length; k++) {

                if (j == cs.length) break;
                if (css[k] == cs[j]) {
                    j++;
                }
            }

            if (j == cs.length) break;
        }

        System.out.println(i);
    }
}
