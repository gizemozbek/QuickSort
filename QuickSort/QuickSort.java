package QuickSort;
public class QuickSort {
    private long[] dizi;
    private int elemanSayisi;

    public QuickSort(int max) { //diziyi kullanici ne kadar girerse o kadar olusturur
        dizi = new long[max];
        elemanSayisi = 0;
    }
    public void insert(long d){
        //yeni ekleme yapilan metotlarda parametre kullanilir
        //eleman diziye eklenir
        dizi[elemanSayisi] = d;
        elemanSayisi++;
    }

    public void display(){
        for (int i = 0;  i<elemanSayisi; i++){
            System.out.print(dizi[i] + " ");
        }
        System.out.println(" ");
    }

    //QUİCK SORT
    //siralama algoritmasini baslatan metot
    // bir pivot secilir ve ona gore ikiye ayrilir ve ona gore siralama islemi yapilir
    public void quickSort(){
        recQuickSort(0, elemanSayisi - 1);
        //left baslangic indisi, right bitis indisi
    }
    //diziyi bolerek siralama islemini rekursif yapacak
    private void recQuickSort(int left, int right){
        if(right - left <= 0){
            //tek elemanli oldugu icin zaten siralidir
            return; } else {
            //pivot secme (son elemani)
            long pivot = dizi[right];
            //pivotun dogru poziyonu
            //siralanmis dizide bulunacagi indisi
            int partition = partitionIt(left,right,pivot);
            //sol taraf (pivotun solundaki elemanlar) siralanir
            recQuickSort(left, partition - 1);
            //sag taraftaki (pivotun sagindaki elemanlar) siralanir
            recQuickSort(partition + 1, right);
        } }

    //pivotun dogru konumunu bulmak icin
    private int partitionIt(int left, int right, long pivot) {
        //leftPtr -> sol tarafta baslangic noktasindan 1 once baslamalidir
        //++leftPtr sonrasi left olacak (karsilastirma icin)
        int leftPtr = left - 1;
        //rightPtr ise sag tarafta dizinin en son elemanini isaret edecek sekilde right'a esitlenmelidir
        //--right sonrasi right -1 olacak
        //sondan baslamasini istedigimizde yapiyoruz
        int rightPtr = right;

        while (true) {
            //sol tarafta eleman arama
            //leftPtr pivottan buyuk veya esit bir eleman bulana kadar
            //en buyuk sayi bulunur (her adimda leftPtrbir arttirilir)
            //pivottan buyuk bir sayi bulunca durulur
            while (dizi[++leftPtr] < pivot) ;


            //sag tarafta kucuk eleman varsa
            //rightPtr pivottan kucuk veya esit elaman bulana kadar
            //en kucuk sayi bulunur(her adimda rightPtr bir azaltilir)
            //pivottan daha kucuk bir sayi bulunca durulur)
            while (rightPtr > 0 && dizi[--rightPtr] > pivot) ;
            //soldaki kucukler ve sagdaki buyukler birbirleriyle cakisiyorsa dongu sona erer
            if (leftPtr >= rightPtr) {
                break;
            }
            //sol ve sagda yanlis yerde elemanlar varsa birbirleriyle yer degistirilmelidir
            else {
                swap(leftPtr, rightPtr);
            }
        }

        //right pivotunu yerine yerlestir
        //leftPtr>= rightPtr saglanmis oldu
        swap(leftPtr, right);
        //pivotun konumu dondurulerek alt dizilerin sinirlarini belirleme
        return leftPtr;
    }

    private void swap(int index1, int index2){
        long temp = dizi[index1];
        dizi[index1] = dizi[index2];
        dizi[index2] = temp;
    }
}


