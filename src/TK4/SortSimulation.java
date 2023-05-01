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
}
