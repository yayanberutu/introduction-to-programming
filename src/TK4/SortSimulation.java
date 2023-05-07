package TK4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Yosepri Disyandro Berutu (yosepri.disyandro@dana.id)
 * @version $Id: SortSimulation.java , v 0.1 2023-05-01 22.09 Yosepri Disyandro Berutu Exp $$
 */
public class SortSimulation {

    /** Size of random number that will be generated */
    public static final int generatedRandomNumberSize = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMenu();

        int batasBawah, batasAtas;
        List<Integer> randomNumbers = new ArrayList<>();

        int selectedMenu;
        do {
            System.out.println("Masukkan Pilihan Anda");
            selectedMenu = scanner.nextInt();
            scanner.nextLine();
            switch (selectedMenu){
                case 1:
                    System.out.print("Batas Bawah = ");
                    batasBawah = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Batas Atas = ");
                    batasAtas = scanner.nextInt();
                    scanner.nextLine();

                    generateRandomNumber(randomNumbers, batasBawah, batasAtas);
                    break;
                case 2:
                    simulateAscendingBubbleSort(randomNumbers);
                    break;
                case 3:
                    simulateAscendingSelectionSort(randomNumbers);
                    break;
                case 4:
                    simulateDescendingBubbleSort(randomNumbers);
                    break;
                case 5:
                    simulateDescendingSelectionSort(randomNumbers);
                    break;
                case 6:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!\n");
                    break;
            }
        } while(selectedMenu != 6);
    }

    /**
     *
     */
    private static void printMenu() {
        System.out.println("Selamat Datang di Program Simulasi");
        System.out.println("Menu");
        System.out.println("1. Random Data");
        System.out.println("2. Simulasi Bubble Sort - Ascending");
        System.out.println("3. Simulasi Selection Sort - Ascending");
        System.out.println("4. Simulasi Bubble Sort - Descending");
        System.out.println("5. Simulasi Selection Sort - Descending");
        System.out.println("6. Keluar");
    }

    /**
     * Method ini untuk melakukan generate 5 random number berdasarkan batas bawah dan batas atas
     * @param randomNumbers
     * @param batasBawah
     * @param batasAtas
     */
    private static void generateRandomNumber(List<Integer> randomNumbers, int batasBawah, int batasAtas) {
        // Declare object
        Random randObj = new Random();
        // Loop for 5 times
        for(int i=0; i < 5; i++){
            // Generate 5 random number between batas bawah dan batas atas
            int rNumber = randObj.nextInt((batasAtas - batasBawah)+1)+batasBawah;
            randomNumbers.add(rNumber);
        }
        // print hasil generate
        printNumberList(randomNumbers);
    }

    /**
     * This method is to print list of number
     * @param randomNumbers
     */
    public static void printNumberList(List<Integer> randomNumbers){
        for(Integer num : randomNumbers){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * This method is to simulate how ascending bubble sort works
     * @param randomNumbers
     */
    private static void simulateAscendingBubbleSort(List<Integer> randomNumbers) {
        int listSize = randomNumbers.size();
        for(int i=0; i<listSize-1; i++){
            System.out.println("Pass " + (i+1));
            printNumberList(randomNumbers);
            for(int j=0; j<listSize-i-1; j++){
                if(randomNumbers.get(j) > randomNumbers.get(j+1)){
                    int temp = randomNumbers.get(j);
                    randomNumbers.set(j, randomNumbers.get(j+1));
                    randomNumbers.set(j+1, temp);
                }
                printNumberList(randomNumbers);
            }
            System.out.println("\nResult of Pass " + (i+1));
            printNumberList(randomNumbers);
            System.out.println("\n");
        }
    }

    /**
     * This method is to simulate how ascending selection sort works
     * @param randomNumbers
     */
    private static void simulateAscendingSelectionSort(List<Integer> randomNumbers) {
    int listSize = randomNumbers.size();
        for(int i=0; i<listSize; ++i){
            System.out.println("Pass " + (i+1));
            printNumberList(randomNumbers);
            int key = randomNumbers.get(i);
            int k = i-1;
            
            while (k >= 0 && randomNumbers.get(k)>key){
                randomNumbers.set(k+1,randomNumbers.get(k));
                k = k-1;
                printNumberList(randomNumbers);
            }
            randomNumbers.set(k+1,key);

            System.out.println("\nResult of Pass " + (i+1));
            printNumberList(randomNumbers);
            System.out.println("\n");
        }
    }

    /**
     * This method is to simulate how descending bubble sort works
     * @param randomNumbers
     */
    private static void simulateDescendingBubbleSort(List<Integer> randomNumbers) {
        int listSize = randomNumbers.size();
        for(int i=0; i<listSize-1; i++){
            System.out.println("Pass " + (i+1));
            printNumberList(randomNumbers);
            for(int j=0; j<listSize-i-1; j++){
                if(randomNumbers.get(j) < randomNumbers.get(j+1)){
                    int temp = randomNumbers.get(j);
                    randomNumbers.set(j, randomNumbers.get(j+1));
                    randomNumbers.set(j+1, temp);
                }
                printNumberList(randomNumbers);
            }
            System.out.println("\nResult of Pass " + (i+1));
            printNumberList(randomNumbers);
            System.out.println("\n");
        }
    }

    /**
     * This method is to simulate how descending selection sort works
     * @param randomNumbers
     */
    private static void simulateDescendingSelectionSort(List<Integer> randomNumbers) {
        int listSize = randomNumbers.size();
        for(int i=0; i<listSize; ++i){
            System.out.println("Pass " + (i+1));
            printNumberList(randomNumbers);
            int key = randomNumbers.get(i);
            int k = i-1;
            
            while (k >= 0 && randomNumbers.get(k)<key){
                randomNumbers.set(k+1,randomNumbers.get(k));
                k = k-1;
                printNumberList(randomNumbers);
            }
            randomNumbers.set(k+1,key);

            System.out.println("\nResult of Pass " + (i+1));
            printNumberList(randomNumbers);
            System.out.println("\n");
        }
    }
}
