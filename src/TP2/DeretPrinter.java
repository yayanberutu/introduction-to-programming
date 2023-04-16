package TP2;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Yosepri Disyandro Berutu (yosepri.disyandro@dana.id)
 * @version $Id: DeretPrinter.java , v 0.1 2023-04-16 23.20 Yosepri Disyandro Berutu Exp $$
 */
public class DeretPrinter {
    public static void main(String[] args) throws IOException {
        String ulang;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Belajar Deret Aritmatika, Geometri, dan menghitung Faktorial");

            System.out.print("Masukkan banyak angka yang mau dicetak [2..10] : ");
            int length = scanner.nextInt();
            scanner.nextLine();
            if(length < 2 || length > 10){
                throw new IOException("Input untuk length invalid. Input angka harus antara 2 sampai 10");
            }

            System.out.print("Masukkan beda masing-masing angka [2..9] : ");
            int beda = scanner.nextInt();
            scanner.nextLine();
            if(beda < 2 || beda > 9){
                throw new IOException("Input untuk beda invalid. Input angka harus antara 2 sampai 9");
            }

            printDeret(length, beda, "aritmatika");
            printDeret(length, beda, "geometri");
            printDeret(length, beda, "faktorial");

            System.out.print("Anda mau ulang [y/t] : ");
            ulang = scanner.nextLine();
            if(!ulang.equals("y") && !ulang.equals("t")){
                throw new IOException("Input invalid. Input yang valid adalah 'y' atau 't'");
            }

        } while (ulang.equals("y"));


    }

    private static void printDeret(int length, int beda, String tipe) {
        int u1 = 1;

        if(tipe.equals("aritmatika")){
            System.out.println("Deret Aritmatika: ");
            for (int i=0; i< length; i++){
                System.out.print(u1 + " ");
                u1 += beda;
            }
            System.out.println();
            return;
        }

        if(tipe.equals("geometri")){
            System.out.println("Deret Geometri: ");
            for (int i=0; i<length; i++){
                System.out.print(u1 + " ");
                u1 *= beda;
            }
            System.out.println();
            return;
        }

        if(tipe.equals("faktorial")){
            System.out.printf("Faktorial dari %d :\n", length);
            int hasilKali = 1;
            for(int i=length; i>0; i--){
                hasilKali *= i;
                System.out.print(i);
                if(i > 1){
                    System.out.print(" * ");
                }
            }
            System.out.println(" = " + hasilKali);
        }
    }

}
