class Huffman {

    HuffmanNode root ;
    int[] frekans = new int[256] ;
    String[] huffmanKodlari = new String[256] ;
    HuffmanNode[] parentGrubuListesi = new HuffmanNode[256] ;
    int elemanSayisi = 0 ;
    
    void KoduCalistir(String metin) {
        frekansTablosuOlustur(metin);
        huffmanAgaciOlustur();
        huffmanKoduOlustur(root);
        verimlilik(metin);
    }

    //*** Huffman ağacını oluşturur
    void huffmanAgaciOlustur() {
        LinkList linkList = new LinkList() ;
        for (int i = 0; i < frekans.length; i++) 
            if (frekans[i] != 0) 
                linkList.elemanEkle((char) i, frekans[i]); 

        while (linkList.charSayisi(linkList.head) != 1) {
            HuffmanNode min1 = parentGonder(linkList.bastakiElemanSilGoster(), elemanSayisi-1); 
            HuffmanNode min2 = parentGonder(linkList.bastakiElemanSilGoster(), elemanSayisi-1) ; 
            HuffmanNode newNode = new HuffmanNode('\0' , min1.frekans + min2.frekans) ;
            newNode.leftChild = min1 ;
            newNode.rightChild = min2 ;
            linkList.elemanEkle(newNode.ch, newNode.frekans);
            parentGrubuListesi[elemanSayisi++] = newNode ;
            if (linkList.charSayisi(linkList.head) == 1)
                root = parentGrubuListesi[0] ;
        }
    }


    //*** HuffmanNode içerisindeki nodeları direkt olarak Link'e dönüştürülmediğinden LinkList'e eklenen nodeları kaybetmemek için parentGrubuListesi oluşturup 
    //*** nodeları burada tutar ve bu metod çağrıldığında LinkList'teki ilk elemanı silip node olup olmadığını kontrol eder
    HuffmanNode parentGonder(Link link , int elemanSayisi) {
        if (link.ch == '\0' && elemanSayisi != -1) {
            if (link.frekans == parentGrubuListesi[elemanSayisi].frekans) {
                HuffmanNode kopya = parentGrubuListesi[elemanSayisi] ;
                ParentGrubuListesiDuzenle(elemanSayisi);
                return kopya;
            }
            return parentGonder(link, elemanSayisi-1) ;
        } return new HuffmanNode(link.ch, link.frekans);
    }


    //*** LinkList'ten alınan Link eğer node ise bu node'u parentGrubuListesi'nden siliyoruz
    void ParentGrubuListesiDuzenle(int indis) {
        for (int i = indis; i < parentGrubuListesi.length-1; i++) 
            if (parentGrubuListesi[i+1] != null) 
                parentGrubuListesi[i] = parentGrubuListesi[i+1];
        this.elemanSayisi--;
    }
    

    //*** Frekans Tablosunu Gösterir
    void frekansTablosuGoster() {
        System.out.println("--------------------------------------");
        System.out.println("Karakter - Frekans Tablosu: \n");
        for (int i = 0; i < frekans.length; i++) 
            if (frekans[i] != 0) 
                System.out.println((char) i + ": " + frekans[i]);
        System.out.println();
    }

    //*** Frekans Tablosunu Oluşturu
    void frekansTablosuOlustur(String metin) {
        for (int i = 0; i < metin.length(); i++) 
            frekans[metin.charAt(i)]++ ;
    }

    //*** Sıkıştırılmış veriyi ekrana yazar
    String kodlanmısData(String metin) {
        String sonuc = "";
        for (int i = 0; i < metin.length(); i++) {
            sonuc += huffmanKodlari[metin.charAt(i)]  ;
        }
        return sonuc ;
    }


    //*** Huffman Kodunu Oluşturur
    void huffmanKoduOlustur(HuffmanNode root) {
        String kod = "" ;
        HuffmanNode child = root ;
        while (root != null) {
            if (child == null) {
                kod = "" ;
                child = root ;
            } else if (child.leftChild == null && child.rightChild == null) {
                if (kod == "")
                    break;
                huffmanKodlari[child.ch] = kod ;
                nodeSil(root, kod);
                child = null ;
            } else if (child.leftChild != null) {
                kod += "0" ;
                child = child.leftChild ;
            } else if (child.rightChild != null) {
                kod += "1" ;
                child = child.rightChild ;
            }
        }
    }

    //*** Huffman ağacındaki en soldan başlayarak node'un huffman kodunu öğrenir ve o node'u siler
    void nodeSil(HuffmanNode root , String kod) {
        for (int i = 0; i < kod.length()-1; i++) {
            if (kod.charAt(i) == '0')
                root = root.leftChild ;
            else
                root = root.rightChild ;
        }
        if (kod.charAt(kod.length()-1) == '0') 
            root.leftChild = null ;
        else 
            root.rightChild = null ;
        
    }

    //*** Girilen metindeki her karakterin huffman kodunu ekrana verir
    void huffmanKodunuGoster() {
        System.out.println("--------------------------------------");
        System.out.println("Karakterlerin Huffman Kodları\n");
        for (int i = 1; i < huffmanKodlari.length; i++) 
            if (huffmanKodlari[i] != null)
                System.out.println((char) i + ": " + huffmanKodlari[i]);  
        System.out.println();
    }

    //*** Sıkıştırma boyutunu hesap ederek verimliliği hesaplar
    void verimlilik (String metin) {
        double toplamO = 0 , toplamS = kodlanmısData(metin).length() ;
        double oran ;
        for (int i = 0; i < frekans.length; i++) 
            if (frekans[i] != 0) 
                toplamO += frekans[i];
        toplamO *= 8 ;
        System.out.println("Sıkıştırma Öncesi Dosya Boyutu: " + toplamO + " bit");
        System.out.println("Sıkıştırma Sonrası Dosya Boyutu: " + toplamS + " bit") ;
        oran = toplamS / toplamO ;
        System.out.println("Sıkıştırma Oranı : " + oran + "\n");
    }
}
