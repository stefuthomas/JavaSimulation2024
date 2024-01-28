import java.util.ArrayList;
import java.util.List;
import eduni.distributions.Normal;

public class Saapumisprosessi {
    private String tapahtumanTyyppi;
    private Normal saapumisJakauma;

    public Saapumisprosessi(String tapahtumanTyyppi, double mean, double stdDev) {
        this.tapahtumanTyyppi = tapahtumanTyyppi;
        this.saapumisJakauma = new Normal(mean, stdDev);
    }

    public void lisaaTapahtuma(Tapahtumalista tapahtumalista) {
        double saapumisaika = Math.round(saapumisJakauma.sample());
        Kello kello = Kello.getInstance();
        kello.siirraKelloa(0, (int) saapumisaika);
        tapahtumalista.lisaaTapahtuma(new Tapahtuma(tapahtumanTyyppi, kello.getAika()));
        System.out.println("Saapumisaika: " + saapumisaika);
        System.out.println("Kello: " + kello.getAika());
    }
}

class Tapahtuma {
    private static int numero = 0;
    private int tapahtumanNumero;
    private String tapahtumanTyyppi;
    private String aika;

    public Tapahtuma(String tapahtumanTyyppi, String aika) {
        Kello kello = Kello.getInstance();
        this.tapahtumanNumero = ++numero;
        this.tapahtumanTyyppi = tapahtumanTyyppi;
        this.aika = aika;
    }

    public String toString() {
        return tapahtumanNumero + ". " + tapahtumanTyyppi + " Saapumisaika: " + aika;
    }
}

class Tapahtumalista {
    private List<Tapahtuma> tapahtumalista = new ArrayList<Tapahtuma>();


    public void lisaaTapahtuma(Tapahtuma tapahtuma) {
        tapahtumalista.add(tapahtuma);
    }
    public void tulostaTapahtumalista() {
        for (Tapahtuma tapahtuma : tapahtumalista) {
            System.out.println(tapahtuma);
        }
    }
}

class SaapumisprosessiTesti {
    public static void main(String[] args) {
        Saapumisprosessi saapumisprosessi = new Saapumisprosessi("Saapuminen", 10, 2);
        Tapahtumalista tapahtumalista = new Tapahtumalista();
        Kello.getInstance();
        for (int i = 0; i < 10; i++) {
            saapumisprosessi.lisaaTapahtuma(tapahtumalista);
        }
        tapahtumalista.tulostaTapahtumalista();
    }
}