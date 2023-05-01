package TK4;

import java.util.ArrayList;
import java.util.List;
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

        System.out.println("Masukkan Pilihan Anda: ");

        int batasBawah, batasAtas;
        List<Integer> randomNumbers = new ArrayList<>();

        int selectedMenu = scanner.nextInt();
        scanner.nextLine();
        switch (selectedMenu){
            case 1:
                System.out.print("Batas Bawah = ");
                batasBawah = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Batas Atas = ");
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

                break;
        }
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
    }

    /**
     * This method is to simulate how ascending bubble sort works
     * @param randomNumbers
     */
    private static void simulateAscendingBubbleSort(List<Integer> randomNumbers) {
    }

    /**
     * This method is to simulate how ascending selection sort works
     * @param randomNumbers
     */
    private static void simulateAscendingSelectionSort(List<Integer> randomNumbers) {
    }
}
