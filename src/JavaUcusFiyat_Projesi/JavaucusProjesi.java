package JavaUcusFiyat_Projesi;

import java.util.Scanner;

public class JavaucusProjesi {
    static int mesafeAB = 500;
    static int mesafeAC = 700;
    static int mesafeAD = 900;
    static double toplamUcret = 0;

    public static void main(String[] args) {
         /* A şehrinden uçmak isteyen bir yolcu B şehrine 500km C şehrine  700km  D şehrine  900 km mesafededir.
            Bilet tarifesi:
            km birim fiyati : 0.10$
            yolcu 12 yasindan kucukse toplam fiyat %50 indirim,
            12 ve 24 yas arasindaysa 10% indirim,
            65 yasindan buyukse 30% indirim,
            bilet gidis donus alinirrsa 20% indirim uygulayan bi app create ediniz */

        int yas = 0;
        String yasKategori = "";
        String isimSoyisim;
        String hedefSehir;
        int gidisdonussecim = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println(" UCUS TARİFE PROGRAMİ.");
        System.out.print("İsim Soyisim : ");
        isimSoyisim = scan.nextLine();

        System.out.print("Hedef Sehir (B? / C? / D?) : ");
        hedefSehir = scan.next().substring(0, 1).toUpperCase();
        toplamUcret = toplamUcretSehirBul(hedefSehir);

        System.out.print("Yasiniz : ");
        yas = scan.nextInt();
        yasKategori = yasKategoriBul(yas);

        toplamUcret = toplamUcretYasIndirimi(yasKategori);

        System.out.println("Gidis Donus ise (1), Tek yon ise (2) tiklayiniz. ");
        gidisdonussecim = scan.nextInt();

        toplamUcret = (gidisdonussecim == 1) ? toplamUcret * 0.80 : toplamUcret;
        System.out.println("Toplam Ucret : " + toplamUcret);

    }

    public static double toplamUcretYasIndirimi(String yasKategori) {
        switch (yasKategori) {
            case "cocuk": {
                toplamUcret = toplamUcret * 0.5; break;
            }
            case "genc": {
                toplamUcret = toplamUcret * 0.9; break;
            }
            case "yasli": {
                toplamUcret = mesafeAD * 0.70; break;
            }
            default: break;
        }
        return toplamUcret;
    }

    public static double toplamUcretSehirBul(String hedefSehir) {
        switch (hedefSehir) {
            case "B": {
                toplamUcret = mesafeAB * 0.10; break;
            }
            case "C": {
                toplamUcret = mesafeAC * 0.10; break;
            }
            case "D": {
                toplamUcret = mesafeAD * 0.10; break;
            }
            default: break;
        }
        return toplamUcret;
    }

    public static String yasKategoriBul(int yas) {
        String yasKategori = "";
        if (yas <= 12) yasKategori = "cocuk";
        else if (yas <= 24) yasKategori = "genc";
        else if (yas >= 65) yasKategori = "yasli";
        return yasKategori;
    }

}
