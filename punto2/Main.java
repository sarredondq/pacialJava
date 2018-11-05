/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author santiago
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static class Tortuga implements Comparable<Tortuga> {

        int peso;
        int fuerza;

        @Override
        public int compareTo(Tortuga o) {
            if (this.fuerza == o.fuerza) {
                return this.peso - o.peso;
            }
            return (this.fuerza) - (o.fuerza);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Tortuga> listaTortuga = new ArrayList<>();
        String s;
        while (true) {
            s = teclado.readLine();
            if (s == null || s.equals("")) {
                break;
            }
            StringTokenizer scan = new StringTokenizer(s);
            Tortuga t = new Tortuga();
            t.peso = Integer.parseInt(scan.nextToken());
            t.fuerza = Integer.parseInt(scan.nextToken()) - t.peso;
            listaTortuga.add(t);
        }
        Tortuga[] arr = listaTortuga.toArray(new Tortuga[listaTortuga.size()]);
        Arrays.sort(arr);
        
        int N = arr.length;
        int[][] dp = new int[N][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = (j == 0 ? 0 : Integer.MAX_VALUE);
            }
        }
        dp[0][1] = arr[0].peso;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= i + 1; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                if (arr[i].fuerza > dp[i - 1][j - 1]) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i - 1][j - 1] + arr[i].peso);
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