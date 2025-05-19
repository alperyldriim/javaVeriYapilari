import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class FileManagement {
    private String dosyaYolu ;


    FileManagement(String dosyaYolu) {
        this.dosyaYolu = dosyaYolu ;
    }

    //*** Dosya Okuma İşlemi Yapar
    String dosyaOku(String dosyaAdi) {
        try { 
            FileReader fReader = new FileReader(dosyaYolu + "/" + dosyaAdi);
            BufferedReader bReader = new BufferedReader(fReader) ;  
            String line = bReader.readLine();
            while (line != null) 
                return line ;
        } catch (IOException e) {
            return "Dosya Okuma Hatası: " + e.getMessage();
        }
        return dosyaAdi;
        
    }

    //*** Dosyaya girilen veriyi yazar 
    void dosyaYaz(String dosyaAdi , String metin) {
        try {
            FileWriter fWriter = new FileWriter(dosyaYolu + "/" + dosyaAdi , false) ;
            BufferedWriter bWriter = new BufferedWriter(fWriter) ;
            bWriter.write(metin);
            bWriter.close();
        } catch (IOException e) {
            System.out.println("Dosya Yazdırma Hatası: " + e.getMessage());
        }
    }


}
