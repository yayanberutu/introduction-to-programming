package TK2;

import java.util.Scanner;

/**
 * @author Yosepri Disyandro Berutu (yosepri.disyandro@dana.id)
 * @version $Id: DeretBilangan.java , v 0.1 2023-03-20 00.24 Yosepri Disyandro Berutu Exp $$
 */
public class DeretBilangan {

    /** min length of nama */
    public static int minNamaLength = 1;

    /** max length of nama */
    public static int maxNamaLength = 25;

    /** length of nim */
    public static int nimLength = 10;

    /** minimal number to be printed as deret */
    public static int minNum = 5;

    /** maximum number to be printed as deret */
    public static int maxNum = 20;

    /** variable to be used to temp input number */
    public static int inputNum = 0;

    /** scanner will be used on all program */
    public static Scanner scanner = new Scanner(System.in);

    /**
     * this method is the main method
     * @param args
     */
    public static void main(String[] args) {
        Mahasiswa mahasiswa = new Mahasiswa();
        char repeat;
        do {
            scanDataMahasiswa(mahasiswa);
            scanNumber();
            printDeret();

            System.out.print("Anda ingin mengulang [y/t] : ");
            repeat = scanner.next().charAt(0);
            scanner.nextLine();
        } while (repeat == 'y');
    }

    /**
     * This procedure will print deret genap, ganjil, and fibonacci
     */
    private static void printDeret() {
        System.out.println("Deret Bilangan");
        System.out.println("###############");

        printBilangan("Genap", inputNum);
        printBilangan("Ganjil", inputNum);
        printBilangan("Fibonacci", inputNum);
    }

    /**
     * This procedure is used to scan number to be used to print deret
     * If scanned number is outside of range, program will ask the input number again
     */
    private static void scanNumber() {
        System.out.println("Mari belajar macam-macam deret bilangan..");
        do {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
            System.out.printf("Masukkan Sembarang Angka [%d..%d] : ", minNum, maxNum);
            inputNum = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
        } while (!isValidInputNumber());
    }

    /**
     * this method is to check if inputted number is valid
     * input number categorized as valid if only the input number equals or between min and max number
     * @return
     */
    private static boolean isValidInputNumber() {
        return inputNum >= minNum && inputNum <= maxNum;
    }

    /**
     * This method is used to scan data mahasiswa.
     * If nama and nim length inputted is outside of the range,
     *  the program will ask the nama and nim again
     * @param mahasiswa
     */
    private static void scanDataMahasiswa(Mahasiswa mahasiswa) {
        if(null == mahasiswa) return;

        do {
            System.out.printf("Masukkan Nama anda [%d..%d] : ", minNamaLength, maxNamaLength);
            mahasiswa.setNama(scanner.nextLine());
        } while (!isValidDataMahasiswa("nama", mahasiswa.getNama()));

        do {
            System.out.printf("Masukkan NIM Anda [harus %d karakter] : ", nimLength);
            mahasiswa.setNim(scanner.nextLine());
        } while (!isValidDataMahasiswa("nim", mahasiswa.getNim()));

        System.out.println("\n\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");

        System.out.println("Registrasi Sukses..");
        System.out.printf("Selamat datang %s [NIM : %s].. ^^v\n\n", mahasiswa.getNama(), mahasiswa.getNim());

    }

    /**
     * This method is used to check if nama and nim is in valid length
     * Nama is valid if the length of nama is between min and max length of name
     * Nim is valid if only the length of nim equals to nimLength
     * @param kind
     * @param value
     * @return
     */
    private static boolean isValidDataMahasiswa(String kind, String value) {
        if(kind.equals("nama")){
            return value.length() >= minNamaLength && value.length() <= maxNamaLength;
        }
        if(kind.equals("nim")){
            return value.length() == nimLength;
        }

        return false;
    }

    /**
     * This method is to print deret bilangan
     * Consists of 3 mode:
     *  1. Genap: to print n (input number) deret genap
     *  2. Ganjil: to print n (input number) deret ganjil
     *  3. Fibonacci: to print n (input number) deret fibonacci
     * @param mode
     * @param count
     */
    private static void printBilangan(String mode, int count) {
        System.out.printf(" %d Bilangan %s :", count, mode);

        if(mode.equals("Genap")){
            int num = 2;
            int sum = 0;
            for(int i=0; i<count; i++){
                System.out.print(num + " ");
                sum += num;
                num += 2;
            }
            System.out.printf("\nHasil Penjumlahan = %d\n\n", sum);
            return;
        }

        if(mode.equals("Ganjil")){
            int num = 1;
            int sum = 0;
            for(int i=0; i<count; i++){
                System.out.print(num + " ");
                sum += num;
                num += 2;
            }
            System.out.printf("\nHasil Penjumlahan = %d\n\n", sum);
            return;
        }

        if(mode.equals("Fibonacci")){
            int num1 = 0;
            int num2 = 1;
            int sum = 0;
            for(int i=0; i<count; i++){
                System.out.print(num2 + " ");
                sum += num2;
                int temp = num1;
                num1 = num2;
                num2 = temp + num1;
            }
            System.out.printf("\nHasil Penjumlahan = %d\n\n", sum);
            return;
        }
    }
}

class Mahasiswa{

    /**
     * nama mahasiswa
     */
    private String nama;


    /**
     * nim mahasiswa
     */
    private String nim;

    public Mahasiswa() {
    }

    /**
     * getter for attribute nama
     * @return
     */
    public String getNama() {
        return nama;
    }

    /**
     * setter for attribute nama
     * @param nama
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * getter for attribute nim
     * @return
     */
    public String getNim() {
        return nim;
    }

    /**
     * setter for attribute nikm
     * @param nim
     */
    public void setNim(String nim) {
        this.nim = nim;
    }
}
