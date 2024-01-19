import java.util.Queue;
import java.util.LinkedList;

class Palvelupiste {
    private LinkedList<Asiakas> jono = new LinkedList<Asiakas>();
    private int palvellutAsiakkaat = 0;
    private long jonotettuAika = 0;

    public void lisaaJonoon(Asiakas a) {
        jono.add(a);
    }

    public Asiakas poistaJonosta() {
        return jono.poll();
    }

    public int getPalvellutAsiakkaat() {
        return palvellutAsiakkaat;
    }

    public long getJonotettuAika() {
        return jonotettuAika;
    }

    public double getKeskimPalveluaika() {
        return (double) jonotettuAika / palvellutAsiakkaat;
    }

    public void palvele() {
        long aloitus = System.currentTimeMillis();
        while (!jono.isEmpty()) {
            Asiakas palveltava = poistaJonosta();
            palvellutAsiakkaat++;
            if (palveltava != null) {
                long palveluaika = (long) (Math.random() * 10000) + 1000;
                try {
                    System.out.println("Asiakasta " + palveltava.getId() + " palvellaan...");
                    Thread.sleep(palveluaika);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Asiakasta " + palveltava.getId() + " palveltu, palveluaika " + (palveluaika / 1000) + "s");
            }
        }
        jonotettuAika += System.currentTimeMillis() - aloitus;
    }
}

public class PalveluPisteSysteemi {
    public static void main(String[] args) {
        Palvelupiste palvelupiste = new Palvelupiste();
        for (int i = 0; i < 5; i++) {
            Asiakas asiakas = new Asiakas();
            palvelupiste.lisaaJonoon(asiakas);
        }
        palvelupiste.palvele();
        System.out.println("Asiakkaat viettivät palvelupisteessä keskimäärin " + (palvelupiste.getKeskimPalveluaika() / 1000) + "s");
    }
}