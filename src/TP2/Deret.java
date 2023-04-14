package TP2;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Yosepri Disyandro Berutu (yosepri.disyandro@dana.id)
 * @version $Id: Deret.java , v 0.1 2023-04-14 23.52 Yosepri Disyandro Berutu Exp $$
 */
public class Deret {

    /** min and max of input num that want to print the sequence */
    public static int minInputLengthSequenceNum = 2;
    public static int maxInputLengthSequenceNum = 10;

    /** min and max of input num that will be used as difference/ratio */
    public static int minInputDiffNumber = 2;
    public static int maxInputDiffNumber = 9;

    /** scanner will be used in this program */
    public static Scanner scanner = new Scanner(System.in);

    public static int inputLengthSequenceNum;
    public static int inputDiffNum;

    public static void main(String[] args) throws InvalidInputNumberException, IOException {
        char repeat;
        do {
            getUserInput();
            printArithmeticSequence(inputLengthSequenceNum, inputDiffNum);
            printGeometricSequence(inputLengthSequenceNum, inputDiffNum);
            printFactorialSequence(inputLengthSequenceNum);

            System.out.print("Anda mau ulang [y/t] : ");
            repeat = scanner.next().charAt(0);
            if((repeat != 'y') && (repeat != 't')){
                throw new IOException("Wrong input number for repeat. The valid is 't' or 'y'");
            }
        } while (repeat == 'y');
    }

    /**
     * This procedure is to get user input
     * @throws InvalidInputNumberException
     */
    private static void getUserInput() throws InvalidInputNumberException {
        System.out.println("Belajar Deret Aritmatika, Geometri, dan menghitung Faktorial");

        System.out.printf("Masukkan banyak angka yang mau dicetak [%d..%d] : ", minInputLengthSequenceNum, maxInputLengthSequenceNum);
        inputLengthSequenceNum = scanner.nextInt();
        scanner.nextLine();
        checkValidInput(inputLengthSequenceNum, "lengthSequence");

        System.out.printf("Masukkan beda masing-masing angka [%d..%d] : ", minInputDiffNumber, maxInputDiffNumber);
        inputDiffNum = scanner.nextInt();
        scanner.nextLine();
        checkValidInput(inputDiffNum, "diff");
    }

    /**
     * This method is to print sequence of arithmetic based on param
     * @param len
     * @param dif
     */
    private static void printArithmeticSequence(int len, int dif) {
        System.out.println("Deret Aritmatika: ");
        int num = 1;
        for(int i=0; i<len; i++){
            System.out.print(num + " ");
            num += dif;
        }
        System.out.println();
    }

    /**
     * This method is to print geometric sequence based on param
     * @param len
     * @param dif
     */
    private static void printGeometricSequence(int len, int dif) {
        System.out.println("Deret Geometri: ");
        int num = 1;
        for(int i=0; i<len; i++){
            System.out.print(num + " ");
            num *= dif;
        }
        System.out.println();
    }

    /**
     * This method is to print factorial sequence based on input
     * @param len
     */
    private static void printFactorialSequence(int len){
        System.out.printf("Faktorial dari %d :\n", len);
        int factorialResult = 1;
        for(int i=len; i>=1; i--){
            System.out.print(i);
            if(i != 1)
                System.out.printf(" * ");
            factorialResult *= i;
        }
        System.out.println(" = " + factorialResult);
    }

    /**
     * This method is to validate input number. If not valid, it will throw exception
     * @param num
     * @param type
     * @throws InvalidInputNumberException
     */
    private static void checkValidInput(int num, String type) throws InvalidInputNumberException {
        switch (type){
            case "lengthSequence":
                if((num < minInputLengthSequenceNum)){
                    throw new InvalidInputNumberException("input sequence length cannot be smaller than " + minInputLengthSequenceNum);
                }
                if((num > maxInputLengthSequenceNum)){
                    throw new InvalidInputNumberException("input sequence length cannot be bigger than " + maxInputLengthSequenceNum);
                }
                break;
            case "diff":
                if((num < minInputDiffNumber)){
                    throw new InvalidInputNumberException("input diff cannot be smaller than " + minInputLengthSequenceNum);
                }
                if((num > maxInputDiffNumber)){
                    throw new InvalidInputNumberException("input diff length cannot be bigger than " + maxInputLengthSequenceNum);
                }
                break;
        }
    }
}

/**
 * This is exception class of invalid input number
 */
class InvalidInputNumberException extends Exception{

    InvalidInputNumberException(String message){
        super(message);
    }
}
