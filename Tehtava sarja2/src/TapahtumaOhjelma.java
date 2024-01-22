import java.util.PriorityQueue;

class Tapahtuma implements Comparable<Tapahtuma> {
    // Tapahtuma-luokan attribuutit
    private String nimi;
    private long aika;
    public Tapahtuma(String nimi, long aika) { // Konstruktori
        this.nimi = nimi;
        this.aika = aika;
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
        System.out.println(tapahtuma.getNimi() + " lisätty. " + tapahtuma.getAika() + " minuuuttia");
    }

    public Tapahtuma nextTapahtuma() {
        return tapahtumat.peek();
    }   // Metodi, jolla palautetaan seuraavaksi tapahtuva tapahtuma ilman poistoa.

    public void removeNextTapahtuma() {
        tapahtumat.poll();
    }   // Metodi, jolla poistetaan seuraavaksi tapahtuva tapahtuma.

    public void printTapahtumat() { // Metodi, jolla tulostetaan kaikki tapahtumat, jos lista ei ole tyhjä.
        while (!tapahtumat.isEmpty()) {
            Tapahtuma tapahtuma = tapahtumat.poll();
            System.out.println(tapahtuma.getNimi() + " - Aika: " + tapahtuma.getAika() + "minuuttia");
        }
    }

}

public class TapahtumaOhjelma { // Pääohjelma-luokka, jossa testataan Tapahtuma- ja TapahtumaLista-luokkia.
    public static void main(String[] args) {
        TapahtumaLista tapahtumaLista = new TapahtumaLista();   // Luodaan uusi tapahtumalista-olio.
        // Generoidaan tapahtumia ja lisätään ne tapahtumalistaan.
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 1", 15));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 2", 9));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 3", 11));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 4", 20));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 5", 4));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 6", 7));
        // Seuraavaksi tapahtuva tapahtuma ilman poistoa.
        System.out.println("Seuraava tapahtuma: " + tapahtumaLista.nextTapahtuma().getNimi());
        // Poistetaan seuraavaksi tapahtuva tapahtuma.
        tapahtumaLista.removeNextTapahtuma();
        System.out.println("Seuraava tapahtuma: " + tapahtumaLista.nextTapahtuma().getNimi());
        tapahtumaLista.removeNextTapahtuma();
        // Tulostetaan tapahtumat-listalla olevat tapahtumat.
        System.out.println("Tapahtumat:");
        tapahtumaLista.printTapahtumat();

    }
}
