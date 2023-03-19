package Forum;

/**
 * @author Yosepri Disyandro Berutu (yosepri.disyandro@dana.id)
 * @version $Id: AugmentedAssignment.java , v 0.1 2023-03-19 00.13 Yosepri Disyandro Berutu Exp $$
 */
public class AugmentedAssignment {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 5;

        // Add and assign num2 to num1 using the += operator
        num1 += num2; // num1 = num1 + num2;
        System.out.println("After adding, num1 = " + num1); // Output: After adding, num1 = 15

        // Subtract and assign num2 from num1 using the -= operator
        num1 -= num2; // num1 = num1 - num2;
        System.out.println("After subtracting, num1 = " + num1); // Output: After subtracting, num1 = 10

        // Multiply and assign num2 to num1 using the *= operator
        num1 *= num2; // num1 = num1 * num2;
        System.out.println("After multiplying, num1 = " + num1); // Output: After multiplying, num1 = 50

        // Divide and assign num2 from num1 using the /= operator
        num1 /= num2; // num1 = num1 / num2;
        System.out.println("After dividing, num1 = " + num1); // Output: After dividing, num1 = 10

        // Modulo and assign num2 to num1 using the %= operator
        num1 %= num2; // num1 = num1 % num2;
        System.out.println("After taking modulo, num1 = " + num1); // Output: After taking modulo, num1 = 0

    }
}
