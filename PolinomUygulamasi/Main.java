public class Main {
    public static void main(String[] args) {
        LinkList pol1 = new LinkList(1);
        LinkList pol2 = new LinkList(2);

        pol1.insertLast(7 , 1);
        pol1.insertLast(2 , 2);
        pol1.insertLast(5 , 4);
        pol1.insertLast(12 , 0);

        pol2.insertLast(-7 , 0);
        pol2.insertLast(2 , 2);
        pol2.insertLast(-5 , 1);
        pol2.insertLast(3 , 3);

        System.out.println("\nPol1 - Pol2 Polinomları Oluşturuldu\n");
        pol1.displayPolynomial();
        pol2.displayPolynomial();

        System.out.println("\nPolinomlar Düzenlendi!\n");
        pol1.sortPolynomialFunction();
        pol2.sortPolynomialFunction();

        pol1.displayPolynomial();
        pol2.displayPolynomial();   

        System.out.println("\nPol1 - Pol2 İçerisindeki Parametreler Silindi");
        pol1.deleteParameter(2);
        pol2.deleteParameter(1);

        pol1.displayPolynomial();
        pol2.displayPolynomial();

        System.out.println("\nPol1 = Pol1 + Pol2 Polinomu Üzerinde Toplama İşlemi Yapıldı");
        pol1.sumPolynomial(pol2);
        pol1.displayPolynomial();

        System.out.println("\nPol1 = Pol1 - Pol2 Polinomu Üzerinde Çıkarma İşlemi Yapıldı");
        pol2.subtractPolynomial(pol1);
        pol2.displayPolynomial();

        System.out.println("\nPol1(x) Sonucunun Bulunması");
        pol1.displayPolynomial();
        pol1.calculatePolynomial(2);

        System.out.println("\nPol1(x) Polinomunun Katsayılar Toplamının Bulunması");
        pol1.calculateSumOfCoefficients();

    }
}

