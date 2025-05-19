public class Main {
    public static void main(String[] args) {
        
        String dosyaYolu = "C:/Users/Lenovo/Masaüstü/Masaüstü/HuffmanTree Ödevi" ;
        String dosyaAdi1 = "Dataset-0.txt" ;
        String dosyaAdi2 = "EncodeDataset.txt" ;

        FileManagement dosya = new FileManagement(dosyaYolu) ;
        String veriKumesi = dosya.dosyaOku(dosyaAdi1) ;
        System.out.println("\nDosyadaki Veri: " + veriKumesi + "\n");

        Huffman huffman = new Huffman() ;
        
        huffman.KoduCalistir(veriKumesi);

        huffman.frekansTablosuGoster();
        huffman.huffmanKodunuGoster() ;

        String encodeDataset = huffman.kodlanmısData(veriKumesi) ;
        dosya.dosyaYaz(dosyaAdi2 , encodeDataset);
        System.out.println("Sıkıştırılmış Veri: " + encodeDataset + "\n");
    }
}















