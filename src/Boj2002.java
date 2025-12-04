import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제 링크: https://www.acmicpc.net/problem/2002
 * 문제 난이도: 실버 1
 * 시간복잡도: O(N^2)
 */

/**
 * 예제 입력
 * 4
 * ZG431SN
 * ZG5080K
 * ST123D
 * ZG206A
 * ZG206A
 * ZG431SN
 * ZG5080K
 * ST123D
 */

public class Boj2002 {

    static int n;
    static Map<String, Integer> pickUpMap = new HashMap<>();
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        for(int i = 0; i < n; i++) {
            String car = br.readLine();
            pickUpMap.put(car, i);
        }

        for(int i = 0; i < n; i++) {
            String car = br.readLine();
            arr[i] = pickUpMap.get(car);
        }

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(arr[i] > arr[j]) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);



    }
}
