import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class HallintaOhjelma {
    public static void main(String[] args) {
        Queue<Asiakas> jono = new LinkedList<>(); // FIFO-periaatteella toimiva jono
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Tulostetaan valikko
            System.out.println("Valitse toiminto: ");
            System.out.println("1. Lisää asiakas jonoon");
            System.out.println("2. Poista asiakas jonosta");
            System.out.println("3. Lopeta ohjelma");

            int valinta = scanner.nextInt();

            switch (valinta) {  // switch-case rakenteella valitaan haluttu toiminto
                case 1: // "Lisää asiakas jonoon" - toiminto luo uuden asiakkaan ja lisää sen jonoon
                    Asiakas asiakas = new Asiakas();
                    asiakas.setAloitusAika(System.nanoTime());
                    jono.add(asiakas);
                    System.out.println("Asiakas " + asiakas.getId() + " lisätty jonoon.");
                    break;
                case 2: // "Poista asiakas jonosta" - toiminto poistaa jonon ensimmäisen asiakkaan
                    if (!jono.isEmpty()) {
                        Asiakas poistettuAsiakas = jono.poll();
                        poistettuAsiakas.setLopetusAika(System.nanoTime());
                        long kulutettuAika = poistettuAsiakas.kulutettuAika() / 1000000;
                        System.out.println("Asiakas " + poistettuAsiakas.getId() + " poistettu jonosta. Asiakas oli jonossa " + kulutettuAika + " ms.");
                    } else {    // Jos jono on tyhjä, tulostetaan virheilmoitus.
                        System.out.println("Jono on tyhjä.");
                    }
                    break;
                case 3: // "Lopeta ohjelma" - toiminto lopettaa ohjelman
                    System.out.println("Ohjelma lopetetaan.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Valinta ei vastaa annettuja vaihtoehtoja.");
                    break;
            }
        }
    }
}
