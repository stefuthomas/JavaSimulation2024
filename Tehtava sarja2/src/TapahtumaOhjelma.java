import java.util.PriorityQueue;

class Tapahtuma implements Comparable<Tapahtuma> {
    // Tapahtuma-luokan attribuutit
    private String nimi;
    private int aika;
    public TapahtumanTyyppi tyyppi;
    public Tapahtuma(String nimi, int aika) { // Konstruktori
        this.nimi = nimi;
        this.aika = aika;
        this.tyyppi = TapahtumanTyyppi.saapuminen;
    }

    public String getNimi() {   // Getteri
        return nimi;
    }

    public long getAika() {     // Getteri
        return aika;
    }

    @Override   // Comparable-rajapinnan toteutus
    public int compareTo(Tapahtuma tapahtuma) {
        if (this.aika < tapahtuma.aika) {   // Valinta rakenne, jolla vertaillaan tapahtumia niiden aikojen perusteella
            return -1;
        } else if (this.aika > tapahtuma.aika) {
            return 1;
        } else {
            return 0;
        }
    }

}

class TapahtumaLista {
    private PriorityQueue<Tapahtuma> tapahtumat;    // Tapahtumalista-luokan attribuutiksi asetetaan PriorityQueue-tyyppinen tapahtumat.

    public TapahtumaLista() {
        this.tapahtumat = new PriorityQueue<>();
    }   // Konstruktori

    public void addTapahtuma(Tapahtuma tapahtuma) { // Metodi, jolla lisätään tapahtuma tapahtumalistaan.
        tapahtumat.add(tapahtuma);
        System.out.print(tapahtuma.getNimi() + " lisätty. " + tapahtuma.getAika() + " minuuuttia");
        System.out.println(" Tyyppi: " + tapahtuma.tyyppi);
    }

    public Tapahtuma nextTapahtuma() {  // Metodi, jolla palautetaan seuraavaksi tapahtuva tapahtuma ilman poistoa.
        Tapahtuma poistuva = tapahtumat.peek();
        poistuva.tyyppi = TapahtumanTyyppi.poistuminen;
        return poistuva;
    }

    public void removeNextTapahtuma() { // Metodi, jolla poistetaan seuraavaksi tapahtuva tapahtuma.
        System.out.println(" Tyyppi: " + tapahtumat.peek().tyyppi);
        tapahtumat.poll();
    }

    public void printTapahtumat() { // Metodi, jolla tulostetaan kaikki tapahtumat, jos lista ei ole tyhjä.
            while (!tapahtumat.isEmpty()) {
                Tapahtuma tapahtuma = tapahtumat.poll();
                System.out.println(tapahtuma.getNimi() + " - Aika: " + tapahtuma.getAika() + " minuuttia" + " Tyyppi: " + tapahtuma.tyyppi);
        }
    }

}

public class TapahtumaOhjelma { // Pääohjelma-luokka, jossa testataan Tapahtuma- ja TapahtumaLista-luokkia.
    public static void main(String[] args) {
        TapahtumaLista tapahtumaLista = new TapahtumaLista();   // Luodaan uusi tapahtumalista-olio.
        // Generoidaan tapahtumia ja lisätään ne tapahtumalistaan.
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 1", (int) (Math.random() * 25) + 1));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 2", (int) (Math.random() * 25) + 1));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 3", (int) (Math.random() * 25) + 1));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 4", (int) (Math.random() * 25) + 1));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 5", (int) (Math.random() * 25) + 1));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 6", (int) (Math.random() * 25) + 1));
        // Seuraavaksi tapahtuva tapahtuma ilman poistoa.
        System.out.print("Seuraava tapahtuma: " + tapahtumaLista.nextTapahtuma().getNimi());
        // Poistetaan seuraavaksi tapahtuva tapahtuma.
        tapahtumaLista.removeNextTapahtuma();
        System.out.print("Seuraava tapahtuma: " + tapahtumaLista.nextTapahtuma().getNimi());
        tapahtumaLista.removeNextTapahtuma();
        System.out.print("Seuraava tapahtuma: " + tapahtumaLista.nextTapahtuma().getNimi());
        tapahtumaLista.removeNextTapahtuma();
        // Tulostetaan tapahtumat-listalla olevat tapahtumat.
        System.out.println("Tapahtumat:");
        tapahtumaLista.printTapahtumat();
    }
}
