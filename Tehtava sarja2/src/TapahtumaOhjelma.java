import java.util.PriorityQueue;

class Tapahtuma implements Comparable<Tapahtuma> {
    private String nimi;
    private long aika;

    public Tapahtuma(String nimi, long aika) {
        this.nimi = nimi;
        this.aika = aika;
    }

    public String getNimi() {
        return nimi;
    }

    public long getAika() {
        return aika;
    }

    @Override
    public int compareTo(Tapahtuma tapahtuma) {
        if (this.aika < tapahtuma.aika) {
            return -1;
        } else if (this.aika > tapahtuma.aika) {
            return 1;
        } else {
            return 0;
        }
    }

}

class TapahtumaLista {
    private PriorityQueue<Tapahtuma> tapahtumat;

    public TapahtumaLista() {
        this.tapahtumat = new PriorityQueue<>();
    }

    public void addTapahtuma(Tapahtuma tapahtuma) {
        tapahtumat.add(tapahtuma);
        System.out.println(tapahtuma.getNimi() + " lisätty. " + tapahtuma.getAika() + " minuuuttia");
    }

    public Tapahtuma nextTapahtuma() {
        return tapahtumat.peek();
    }

    public void removeNextTapahtuma() {
        tapahtumat.poll();
    }

    public void printTapahtumat() {
        while (!tapahtumat.isEmpty()) {
            Tapahtuma tapahtuma = tapahtumat.poll();
            System.out.println(tapahtuma.getNimi() + " - Aika: " + tapahtuma.getAika() + "minuuttia");
        }
    }

}

public class TapahtumaOhjelma {
    public static void main(String[] args) {
        TapahtumaLista tapahtumaLista = new TapahtumaLista();
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 1", 15));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 2", 9));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 3", 11));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 4", 20));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 5", 4));
        tapahtumaLista.addTapahtuma(new Tapahtuma("Tapahtuma 6", 7));

        System.out.println("Seuraava tapahtuma: " + tapahtumaLista.nextTapahtuma().getNimi());
        tapahtumaLista.removeNextTapahtuma();
        System.out.println("Seuraava tapahtuma: " + tapahtumaLista.nextTapahtuma().getNimi());
        tapahtumaLista.removeNextTapahtuma();

        System.out.println("Tapahtumat:");
        tapahtumaLista.printTapahtumat();

    }
}
