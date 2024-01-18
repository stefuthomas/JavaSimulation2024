public class AsiakasTest {
    public static void main(String[] args) {
        //luodaan asiakasolioita ja asetetaan niille aloitus- ja lopetusaika
        Asiakas asiakas1 = new Asiakas();
        Asiakas asiakas2 = new Asiakas();
        Asiakas asiakas3 = new Asiakas();
        asiakas1.setAloitusAika(System.currentTimeMillis() - 10000);
        asiakas1.setLopetusAika(System.currentTimeMillis());
        asiakas2.setAloitusAika(System.currentTimeMillis() - 5000);
        asiakas2.setLopetusAika(System.currentTimeMillis());
        asiakas3.setAloitusAika(0);
        asiakas3.setLopetusAika(0);

        //tulostetaan asiakkaiden id:t ja kulutettu aika
        System.out.println("Asiakas" + asiakas1.getId() + " Kulutettu aika: " + asiakas1.kulutettuAika() + " ms");
        System.out.println("Asiakas" + asiakas2.getId() + " Kulutettu aika: " + asiakas2.kulutettuAika() + " ms");
        System.out.println("Asiakas" + asiakas3.getId() + " Kulutettu aika: " + asiakas3.kulutettuAika() + " ms");

    }
}