class Link {
    char ch ;
    int frekans , indis;
    double yuzdeKac ;
    Link next , prev ;

    Link (char ch , int frekans) {
        this.ch = ch ; 
        this.indis = (int) ch ;
        this.frekans = frekans ;
        next = null ;
    }   
}