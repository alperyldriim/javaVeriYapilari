class LinkList {
    
    Link head , tail ;;

    LinkList () {
        head = null ;
        tail = null ;
    }

    //*** LinkList'e küçükten büyüğe sıralı bir şekilde eleman yerleştirir
    void elemanEkle(char ch , int frekans) {
        Link eleman = new Link(ch , frekans) ;
        if (head == null) {
            head = eleman ;
            tail = eleman ;
        } else {
            Link kopya = head.next , current = head;
            int maxFrekans = tail.frekans , minFrekans = head.frekans ;
            if ((eleman.frekans < minFrekans) || ((eleman.frekans == minFrekans) && (head.indis > eleman.indis))) {
                eleman.next = head ;
                head.prev = eleman ;
                head = eleman ;
            } else if ((eleman.frekans > maxFrekans) || (eleman.frekans == maxFrekans && eleman.indis > tail.indis)) {
                tail.next = eleman ;
                eleman.prev = tail ;
                tail = eleman ;
            } else {
                while (kopya != null) {
                    if ((eleman.frekans < kopya.frekans) || ((eleman.frekans == kopya.frekans) && (eleman.indis < kopya.indis))) {
                        eleman.next = kopya ;
                        current.next = eleman ;
                        eleman.prev = current ;
                        kopya.prev = eleman ;
                        return;
                    }
                    kopya = kopya.next ;
                    current = current.next ;
                }
            }  
        }
    }

    //***  LinkList içerisindeki Link sayısını hesaplar
    int elemanSayisi(Link head) {
        if (head == null)
            return 0 ;
        return 1 + elemanSayisi(head.next) ;
    }

    //*** LinkList içerisindeki ilk linki siler ve gösterir
    Link bastakiElemanSilGoster() {
        Link temp = head ;
        if (head == null)
            return null ;
        if (head.next == null) 
            tail = null ;
        else 
            head.next.prev = null ;
        head = head.next ;
        return temp ;  
    }

    //*** LinkList içerisindeki Linklerin özelliklerini yazar
    void yazdir () {
        if (head == null) 
            return ;
        else {
            Link kopya = head ;
            int topChar = topChar(kopya) ;
            System.out.println("\nFarklı Çeşitteki Char Sayısı: " + charSayisi(kopya));
            System.out.println("Metindeki Toplam Char Sayısı: " + topChar);
            System.out.println("Sıralama Sırası (Min Adet --> Max Adet); ");
            while (kopya != null) {
                System.out.println("\nChar       : "  + kopya.ch);
                System.out.println("Char İndisi: "  + kopya.indis);
                System.out.println("Frekans    : "  + kopya.frekans);
                System.out.println("Yüzde Kaç  : %" + (100 * kopya.frekans / (double) topChar)  + "\n");
                kopya = kopya.next ;
            }
        }
    }

    //*** Kaç çesit char olduğunu hesaplar
    int charSayisi(Link head) {
        if (head == null) 
            return 0;
        return 1 + charSayisi(head.next);
    }

    //*** Toplam char sayısını hesaplar
    int topChar(Link head) {
        if (head == null)
            return 0;
        return head.frekans + topChar(head.next) ;
    }
}

