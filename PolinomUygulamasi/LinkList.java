public class LinkList {
    Link head = null , tail = null, current = null , temp = head;
    int polynomialId ;
    

    LinkList(int polynomialId) {
        this.polynomialId = polynomialId;

    }

    void insertLast(int coeff , int exp) {
        Link eleman = new Link(coeff , exp);
        if (head == null) 
            head = eleman ;
        else 
            tail.next = eleman ;
        tail = eleman ;
    }

    void sortPolynomialFunction() {
        int tempExp , tempCoeff ;
        if (head == null) 
            System.out.println("Polinom İçerisinde Değer Bulunmamaktadır!");
        else {
            current = head ;
            while (current != null) {
                temp = current.next ;
                while (temp != null) {
                    if (temp.exp > current.exp) {
                        tempCoeff = current.coeff ;
                        tempExp = current.exp ;
                        current.exp = temp.exp ;
                        current.coeff = temp.coeff ;
                        temp.coeff = tempCoeff ;
                        temp.exp = tempExp ;
                    }
                    temp = temp.next ;    
                }
                current = current.next ;
            }
        }      
    }
    

    void displayPolynomial() {
        if (head == null) 
            System.out.println("Polinom İçerisinde Değer Bulunmamaktadır!");
        else {
            System.out.print("POL-" + polynomialId + " Polynomial equation (Head --> Tail): { ");
            temp = head ;
            while (temp != null) {
                if (temp.coeff == 0) 
                    temp.exp = 0 ;
                else if (temp.coeff > 0) 
                    System.out.print("+ ");
                else 
                    System.out.print("- ");
                if (temp.coeff == 1 || temp.coeff == -1)
                    System.out.print("x^" + temp.exp + " ");
                else if (temp.exp != 1 && temp.exp != 0) 
                    System.out.print(Math.abs(temp.coeff) + "x^" + temp.exp + " ");
                else if (temp.exp == 1) 
                    System.out.print(Math.abs(temp.coeff) + "x ");
                else if (temp.coeff != 0) 
                    System.out.print(Math.abs(temp.coeff) + " ");
                temp = temp.next ;
            }
            System.out.println("} ");
        }
    }

    void deleteParameter(int exp) {
        int sayac = 1 , index = 1;
        current = head ;
        while (current != null) {
            if (current.exp == exp) 
                break ;
            sayac++;
            current = current.next ;
        } current = head ;

        if (sayac == 1) 
            head = head.next ;
        else if (sayac == kacDegiskenVar()) 
            while (index < sayac) {
                if (index == (sayac-1)) {
                    current.next = null ;
                    tail = current ;
                }
                current = current.next ;
                index++;
            }
        else 
            while (index < sayac) {
                if (index == (sayac-1)) 
                    current.next = current.next.next ;
                current = current.next ;
                index++;
            }
    }
    
    // Toplama İşlemi For Döngüsü İle
    // void sumPolynomial(LinkList pol) {
    //     temp = pol.head ;
    //     for ( ;  temp != null ; temp = temp.next ) {
    //         int control = 0 ;
    //         current = head ;
    //         for (;current != null; current = current.next) {
    //             if (current.exp == temp.exp) {
    //                 current.coeff += temp.coeff ;
    //                 control = 1 ;
    //                 break ;
    //             }
                // current = current.next ;
    //         }
    //         if (control == 0) {
    //             System.out.println("girdi");
    //             insertLast(temp.coeff, temp.exp);
    //         }
            // temp = temp.next ;
    //     }
    //     sortPolynomialFunction();
    // }

    void sumPolynomial(LinkList pol) {
        temp = pol.head ;
        while (temp != null) {
            int control = 0 ;
            current = head ;
            while (current != null) {
                if (current.exp == temp.exp) {
                    current.coeff += temp.coeff ;
                    control = 1 ;
                    break ;
                } 
                current = current.next ;
            }
            if (control == 0)
                insertLast(temp.coeff, temp.exp);
            temp = temp.next ;
        }
        sortPolynomialFunction();
    }

    void subtractPolynomial(LinkList pol) {
        temp = pol.head ;
        while (temp != null) {
            int control = 0 ;
            current = head ;
            while (current != null) {
                if (current.exp == temp.exp) {
                    current.coeff -= temp.coeff ;
                    control = 1 ;
                    break ;
                } 
                current = current.next ;
            }
            if (control == 0)
                insertLast((temp.coeff)*-1, temp.exp);
            temp = temp.next ;
        }
        sortPolynomialFunction();
    }

    void calculatePolynomial(int x) {
        current = head ;
        double sum = 0 , result;
        while (current != null) {
            result = Math.pow(x, current.exp) ;
            result *= current.coeff ;
            sum += result ;
            current = current.next ;
        }
        System.out.println("Pol" + polynomialId + "(" + x + ") : " + (int) sum);
    }

    void calculateSumOfCoefficients() {
        System.out.print("Katsayılar Toplamı ");
        calculatePolynomial(1);
        System.out.println();
    }

    int kacDegiskenVar() {
        int sayac = 0 ;
        temp = head ;
        while (temp != null) {
            temp = temp.next ;
            sayac++;
        } return sayac;
    }
}

