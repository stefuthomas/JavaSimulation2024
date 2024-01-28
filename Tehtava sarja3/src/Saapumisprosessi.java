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
        System.out.println("Saapumisaika: " + saapumisaika);
        tapahtumalista.lisaaTapahtuma(new Tapahtuma(tapahtumanTyyppi, saapumisaika));
        Kello kello = Kello.getInstance();
        kello.siirraKelloa(0, (int) saapumisaika);
        System.out.println(kello.getAika());
    }
}

class Tapahtuma {
    private String tapahtumanTyyppi;
    private double aika;

    public Tapahtuma(String tapahtumanTyyppi, double aika) {
        this.tapahtumanTyyppi = tapahtumanTyyppi;
        this.aika = aika;
    }

    public String toString() {
        return "Tapahtuma: " + tapahtumanTyyppi + " " + Math.round(aika);
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
    }
}