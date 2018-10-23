import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int i = 1;
        String s;
        Scanner teclado = new Scanner(System.in);
        ArrayList<Elefante> listaElefante = new ArrayList<Elefante>();		
		while (true) {
            int s1;
            int s2;
			s = teclado.nextLine();
			if (s==null || s.equals("")) {
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
        
        for(Elefante j : listaElefante){
            System.out.println(j.getPeso());
        }
    }
}