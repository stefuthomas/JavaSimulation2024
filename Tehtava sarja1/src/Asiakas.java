public class Asiakas {

    private static int seuraavaId = 1;     //luokkamuuttuja asiakkaan id:n asettamiseen

    //asiakkaan id, sekä aloitus- ja lopetusaika attribuutit
    private int id;
    private long aloitusAika;
    private long lopetusAika;


    public Asiakas() {     //konstruktori, jonka avulla asetetaan asiakkaan id
        this.id = seuraavaId++;
    }
    public int getId() {     //getteri asiakkaan id:lle
        return id;
    }

    public void setAloitusAika(long aloitusAika) {     //setteri asiakkaan aloitusajalle
        this.aloitusAika = aloitusAika;
    }

    public long getAloitusAika() {    //getteri asiakkaan aloitusajalle
        return aloitusAika;
    }

    public void setLopetusAika(long lopetusAika) {    //setteri asiakkaan lopetusajalle
        this.lopetusAika = lopetusAika;
    }

    public long getLopetusAika() {     //getteri asiakkaan lopetusajalle
        return lopetusAika;
    }

    public long kulutettuAika() {    //metodi, joka palauttaa asiakkaan kuluttaman ajan
        if (aloitusAika == 0 || lopetusAika == 0) { //jos asiakkaan aloitus- tai lopetusaika on 0, palautetaan 0
            return 0;
        }
        return lopetusAika - aloitusAika;
    }

}