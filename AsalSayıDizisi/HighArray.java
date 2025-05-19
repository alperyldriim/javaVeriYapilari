import java.util.Random;
import java.util.Scanner;

public class HighArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        
        System.out.print("Dizi Boyutunu Giriniz: ");
        int boyut = sc.nextInt() ;

        HighArray dizi = new HighArray(boyut) ;

        dizi.fillRandom(boyut) ;
        dizi.display() ;

        dizi.primeNumbersInfo() ;

        dizi.removeNonPrimeNumbers() ;
        dizi.display() ;

        dizi.sort() ;
        dizi.display() ;
        sc.close() ;
    }

    Random rand = new Random() ;
    int[] dizi ;
    int elemanSayisi , sayi , index;

    public HighArray(int boyut) {
        dizi = new int[boyut] ;
        elemanSayisi = boyut ;
    }

    void fillRandom(int boyut) {
        if (boyut <= 100) {
            for (int i = 0; i < boyut ; i++) {
                sayi = rand.nextInt(100)+1 ;
                while(kontrol(i, sayi)) {
                    sayi = rand.nextInt(100)+1 ;
                }
                dizi[i] = sayi ;
            }
        }
    }

    boolean kontrol(int index , int sayi) {
        if (index == 0) {
            return false ;
        }

        for (int i = 0; i < index; i++) {
            if (dizi[i] == sayi) {
                return true ;
            }
        }
        return false ;
    }

    void display() {
        System.out.println("\nDizi Sıralaması; ");
        for (int i = 0; i < elemanSayisi; i++) {
            System.out.print(dizi[i] + " ");
        }
        System.out.println("\n");
    }

    boolean asalMi(int sayi) {
        if (sayi == 1) {
            return false;
        }
        for (int i = 2; i < sayi ; i++) {
            if (sayi % i == 0) {
                return false;
            }
        }
        return true;
    }

    void primeNumbersInfo() {
        int asalSayıSayısı = 0;
        System.out.println("Asal Sayı Dizisi: ");
        for (int i = 0; i < elemanSayisi ; i++) {
            if (asalMi(dizi[i])) {
                System.out.print(dizi[i] + " ");
                asalSayıSayısı++;
            }
        }
        System.out.println("\nAsal Sayı Miktarı: " + asalSayıSayısı);
    }

    void removeNonPrimeNumbers() {
        System.out.println("\nSilinen Asal Olmayan Sayı Dizisi: ");
        for (int i = 0 ; i < elemanSayisi ; i++) {
            if (!asalMi(dizi[i])) {
                System.out.print("{" + dizi[i] + "} ");
                dizi = kaydir(dizi , i , elemanSayisi);
                elemanSayisi-- ;
                i--;
            }
        }
        System.out.println("\nAsal Olmayan Sayı Dizisi Başarıyla Silindi!");
    }

    static int[] kaydir(int[] dizi ,int index , int elemanSayisi) {
        int temp ;
        for (int j = index; j < elemanSayisi-1 ; j++) {
            temp = dizi[j] ;
            dizi[j] = dizi[j+1] ;
            dizi[j+1] = temp ;
        }
        return dizi ;
    }

    void sort() {
        int temp ;
        for (int i = 0; i < elemanSayisi ; i++) {
            int min = dizi[i] ;
            for (int j = i; j < elemanSayisi; j++) {
                if (min > dizi[j]) {
                    min = dizi[j] ;
                    temp = dizi[i] ;
                    dizi[i] = min ;
                    dizi[j] = temp ;
                }
            }
        }
        System.out.println("Sayı Dizisi Küçükten Büyüğe Sıralandı!");
    }
}
