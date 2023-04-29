package Forum;

import java.util.Scanner;

/**
 * @author Yosepri Disyandro Berutu (yosepri.disyandro@dana.id)
 * @version $Id: EvenOdd.java , v 0.1 2023-03-29 20.18 Yosepri Disyandro Berutu Exp $$
 */
public class EvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();

        if(num % 2 == 0){
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }

        if(num > 10){
            System.out.println("Diluar nalar");
        } else {
            if(num % 2 == 0){
                System.out.println("Ganjil");
            } else {
                System.out.println("Genap");
            }
        }

        int angka = 5;
        switch(angka){
            case (5):
                System.out.println("a");
        }
    }
}
