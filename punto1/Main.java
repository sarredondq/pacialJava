/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author santiago
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /**
     * metodo main
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // ingresar los datos de los elefantes y ponerlos en una lista
        int poc = 1;
        String s;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Elefante> listaElefante = new ArrayList<>();
        while (true) {
            int s1;
            int s2;
            s = teclado.readLine();
            if (s == null || s.equals("")) {
                break;
            }
            StringTokenizer scan = new StringTokenizer(s);
            s1 = Integer.parseInt(scan.nextToken());
            s2 = Integer.parseInt(scan.nextToken());
            Elefante tem = new Elefante(s1, s2, poc);
            listaElefante.add(tem);
            poc++;
        }
        Elefante[] arrPorPeso = listaElefante.toArray(new Elefante[listaElefante.size()]);
        Arrays.sort(arrPorPeso);
        int[] lisTemp = new int[arrPorPeso.length];
        lisTemp[0] = 1;

        for (int j = 1; j < lisTemp.length; j++) {
            lisTemp[j]=Math.max(1, lisTemp[j]);
            for (int k = 0; k < j; k++) {
                if (arrPorPeso[j].getCi() < arrPorPeso[k].getCi() && arrPorPeso[j].getPeso() > arrPorPeso[k].getPeso()) {
                    lisTemp[j] = Math.max(lisTemp[k] + 1, lisTemp[j]);
                }
            }
        }
        int max = 0;
        for (int j : lisTemp) {
            max = Math.max(j, max);
        }
        System.out.println(max);
        int[] solucion = new int[max];

        boolean primero = true;
        int ultimo = 0;
        for (int i = lisTemp.length - 1; i >= 0 && max > 0; i--) {
            if (lisTemp[i] == max && (primero || ultimo < arrPorPeso[i].getCi())) {
                ultimo = arrPorPeso[i].getCi();
                solucion[--max] = arrPorPeso[i].getPosicion();
                primero = false;
            }
        }
        for (int i : solucion) {
            System.out.println(i);
        }
    }
}
