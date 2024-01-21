import java.util.Random;
import java.text.DecimalFormat;
public class IkaJakauma {
    public static void main(String[] args) {
        Random random = new Random();
        // alle 20, 20-23, 24-29, yli 30 - muuttujat.
        int alle20 = 0;
        int _20_23 = 0;
        int _24_29 = 0;
        int yli30 = 0;
        // 1000 kertaa arvotaan luku ja kasvatetaan oikeaa muuttujaa sen mukaan.
        for (int i = 0; i < 1000; i++) {
            int num = random.nextInt(100);
            // alle 20v ovat 0-10, 20-23v ovat 11-45, 24-29v ovat 46-95 ja yli 30v ovat 96-100.
            if (num >= 0 && num <= 10) {
                alle20++;
            } else if (num >= 11 && num <= 45) {
                _20_23++;
            } else if (num >= 46 && num <= 95) {
                _24_29++;
            } else if (num >= 96 && num <= 100) {
                yli30++;
            }
        }
        // luodaan jokaisesta muuttujasta prostentuaalinen arvo.
        int total = alle20 + _20_23 + _24_29 + yli30;
        double alle20P = (double) alle20 / total * 100;
        double _20_23P = (double) _20_23 / total * 100;
        double _24_29P = (double) _24_29 / total * 100;
        double yli30P = (double) yli30 / total * 100;
        // luodaan desimaaliformaatti.
        DecimalFormat df = new DecimalFormat("0.00");
        // tulostetaan prosentuaaliset arvot.
        System.out.println("Alle 20: " + df.format(alle20P)+ "%");
        System.out.println("20-23: " + df.format(_20_23P) + "%");
        System.out.println("24-29: " + df.format(_24_29P) + "%");
        System.out.println("Yli 30: " + df.format(yli30P) + "%");

    }
}
