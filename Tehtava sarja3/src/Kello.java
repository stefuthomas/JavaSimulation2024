public class Kello {
    private int tunnit;
    private int minuutit;
    private static Kello INSTANCE = null;
    private Kello() {}

    public static  Kello getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Kello();
        }
        return INSTANCE;
    }

    public int getTunnit() {
        return tunnit;
    }

    public int getMinuutit() {
        return minuutit;
    }

    public String getAika() {
        return tunnit + ":" + minuutit;
    }
    public void siirraKelloa(int tunnit, int minuutit) {
        this.tunnit += tunnit;
        this.minuutit += minuutit;

        while (this.minuutit > 59) {
            this.minuutit -= 60;
            this.tunnit++;
        }

        while (this.tunnit > 23) {
            this.tunnit -= 24;
        }
    }

}

class KelloTesti {
    public static void main(String[] args) {
        /*Kellon luominen ei toimi "new" operaatiolla.
        Konstruktori on private:
        Kello kello = new Kello(); */

        // Kutsutaan getInstance() (luodaan kello):
        Kello kello = Kello.getInstance();

        // Siirretään kello 12:35
        kello.siirraKelloa(12, 35);

        // Tulostetaan aika:
        System.out.println(kello.getAika());

        // Siirretään kelloa eteenpäin ja tulostetaan aika:
        kello.siirraKelloa(5, 14);
        System.out.println(kello.getAika());
    }
}
