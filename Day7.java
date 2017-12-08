import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class Program {
    private String ime;
    private int teza;
    private String[] potomci;
    private int skupnaTeza;

    Program(String ime, int teza, String[] potomci) {
        this.ime = ime;
        this.teza = teza;
        this.potomci = potomci;
    }

    int getTeza() {
        return teza;
    }

    String getIme() {
        return ime;
    }

    String[] getPotomci() {
        return potomci;
    }

    void setSkupnaTeza(int skupnaTeza) {
        this.skupnaTeza = skupnaTeza;
    }

    int getSkupnaTeza() {
        return skupnaTeza;
    }
}

public class Day7 {
//7.1 sm na roko najdu.
//7.2:
    private static boolean exit = false;
    private static int rezultat = 0;

    private static int poisci(ArrayList<Program> stolp, int index) {
        if (exit) {
            return 0;
        }
        Program trenutni = stolp.get(index);
        if (trenutni.getPotomci() == null) {
            trenutni.setSkupnaTeza(trenutni.getTeza());
            return trenutni.getSkupnaTeza();
        }
        int[] potomci = new int[trenutni.getPotomci().length];
        for (int i = 0; i < potomci.length; i++) {
            for (int j = 0; j < stolp.size(); j++) {
                Program temp = stolp.get(j);
                if (Objects.equals(trenutni.getPotomci()[i], temp.getIme())) {
                    potomci[i] = j;
                }
            }
        }

        int teza = 0;
        for (int i = 0; i < potomci.length - 1; i++) {
            int prvi = poisci(stolp, potomci[i]);
            int drugi = poisci(stolp, potomci[i + 1]);
            if (exit) {
                return rezultat;
            }
            teza = prvi;
            if (prvi != drugi) {
                int iPrvi = i;
                int iDrugi = i + 1;
                int tretji;
                if (i == 0) {
                    tretji = poisci(stolp, potomci[i + 2]);
                    if (drugi == tretji) {
                        iPrvi = i + 1;
                        iDrugi = i;
                    }
                }

                exit = true;
                Program vrni1 = stolp.get(potomci[iPrvi]);
                Program vrni2 = stolp.get(potomci[iDrugi]);


                rezultat = vrni2.getTeza() + (vrni1.getSkupnaTeza() - vrni2.getSkupnaTeza());
                return rezultat;
            }
        }
        trenutni.setSkupnaTeza(trenutni.getTeza() + teza * potomci.length);
        return trenutni.getSkupnaTeza();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Program> stolp = new ArrayList<>();
        while (sc.hasNext()) {
            String vrstica = sc.nextLine();
            String[] besede = vrstica.split(" ");
            int teza = Integer.parseInt(besede[1].substring(1, besede[1].indexOf(')')));
            String[] potomci = null;
            if (besede.length > 3) {
                potomci = new String[besede.length - 3];
                for (int i = 3; i < besede.length - 1; i++) {
                    besede[i] = besede[i].substring(0, besede[i].length() - 1);
                    potomci[i - 3] = besede[i];
                }
                potomci[potomci.length - 1] = besede[besede.length - 1];
            }
            stolp.add(new Program(besede[0], teza, potomci));
        }

        poisci(stolp, 357);//tuki mors dat index korena puzzle: 357 test:8

        System.out.println(rezultat);

    }
}
