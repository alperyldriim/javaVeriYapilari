import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input ;
        while (true) {
            System.out.print("Parantez İçeren Metin Giriniz:   ");
            input = getString() ;

            if (input.equals(""))
                break ;

            BracketChecker theChecker = new BracketChecker(input) ;
            boolean control = theChecker.check();

            if (control)
                System.out.println("İfade Uyumlu\n");
            else 
                System.out.println("İfade Uyumlu Değil\n");
        }
    }

    public static String getString() {
        Scanner input = new Scanner(System.in) ;
        String s = input.nextLine() ;
        return s ;
    }
}







