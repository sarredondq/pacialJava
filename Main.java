import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    /** metodo main */
    public static void main(String[] args) {
        // ingresar los datos de los elefantes y ponerlos en una lista
        int i = 1;
        String s;
        Scanner teclado = new Scanner(System.in);
        ArrayList<Elefante> listaElefante = new ArrayList<Elefante>();
        while (true) {
            int s1;
            int s2;
            s = teclado.nextLine();
            if (s == null || s.equals("")) {
                break;
            }
            Scanner scan = new Scanner(s);
            s1 = scan.nextInt();
            s2 = scan.nextInt();
            Elefante tem = new Elefante(s1, s2, i);
            listaElefante.add(tem);
            i++;
            scan.close();
        }
        teclado.close();

        while (!(listaElefante.isEmpty())) {
            // menor peso
            Elefante elMenorPeso = listaElefante.get(0);
            for (Elefante j : listaElefante) {
                if(elMenorPeso.getPeso() > j.getPeso()){
                    elMenorPeso = j;
                }
            }
            Elefante elMayorCi = elMenorPeso;

            for (Elefante j : listaElefante) {
                if(elMayorCi.getCi() < j.getCi()){
                    elMayorCi = j;
                }
            }
            
        }
    }
}