package QuickSort;
public class QuickSortApp {
    public static void main(String[] args) {
        QuickSort theQuick = new QuickSort(10);

        theQuick.insert(66); //insert ile veri ekliyoruz
        theQuick.insert(64);
        theQuick.insert(29);
        theQuick.insert(57);
        theQuick.insert(10);
        theQuick.insert(61);
        theQuick.insert(9);
        theQuick.insert(56);
        theQuick.insert(74);
        theQuick.insert(63);

        System.out.print("Siralanmadan once:");
        theQuick.display();

        theQuick.quickSort(); //diziyi siralar

        System.out.print("Siralandiktan sonra:");
        theQuick.display();
    } }
