package TP2;

import java.util.Scanner;

/**
 * @author Yosepri Disyandro Berutu (yosepri.disyandro@dana.id)
 * @version $Id: Fungsi.java , v 0.1 2023-04-14 22.48 Yosepri Disyandro Berutu Exp $$
 */
public class Fungsi {

    public static void main(String[] args) {
        int num = 20;
        System.out.println(isPrime(20)? "prime" : "not prime");

        for (int i=0; i<5; i++) {
            // kode yang akan diulang
        }

        Scanner scanner = new Scanner(System.in);

        String inputPassword = "binusIsTheBest";
        String realPassword = "binusIsTheBest";

        do {
            inputPassword = scanner.nextLine();
        } while (inputPassword.equals(realPassword));



        while(!inputPassword.equals(realPassword)){
            inputPassword = scanner.nextLine();
        }
    }

    /**
     * This method is to check if input number <tt>num</tt> is prime or not
     * @param num
     * @return
     */
    public static boolean isPrime(int num){
        if(num <= 1) return false;
        if(num <= 3) return true;
        if((num % 2 == 0) || (num % 2 == 0)){
            return false;
        }

        for(int i = 5 ; i*i < num; i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }
}
