import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static class Turtle implements Comparable<Turtle> {

        int weight;
        int strength;

        @Override
        public int compareTo(Turtle o) {
            if (this.strength == o.strength) {
                return this.weight - o.weight;
            }
            return (this.strength) - (o.strength);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Turtle> list = new ArrayList<>();
        String strLine;
        while (true) {
            strLine = br.readLine();
            if (strLine == null || strLine.equals("")) {
                break;
            }
            StringTokenizer scan = new StringTokenizer(strLine);
            Turtle t = new Turtle();
            t.weight = Integer.parseInt(scan.nextToken());
            t.strength = Integer.parseInt(scan.nextToken()) - t.weight;
            list.add(t);
        }
        Turtle[] arr = list.toArray(new Turtle[list.size()]);
        Arrays.sort(arr);
        
        int N = arr.length;
        int[][] dp = new int[N][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = (j == 0 ? 0 : Integer.MAX_VALUE);
            }
        }
        dp[0][1] = arr[0].weight;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= i + 1; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                if (arr[i].strength > dp[i - 1][j - 1]) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i - 1][j - 1] + arr[i].weight);
                }
            }
        }
        for (int i = N; i >= 0; i--) {
            if (dp[N - 1][i] != Integer.MAX_VALUE) {
                System.out.println(i);
                break;
            }
        }
    }
}