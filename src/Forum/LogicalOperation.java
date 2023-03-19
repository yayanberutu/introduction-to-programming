package Forum;

/**
 * @author Yosepri Disyandro Berutu (yosepri.disyandro@dana.id)
 * @version $Id: LogicalOperation.java , v 0.1 2023-03-19 00.18 Yosepri Disyandro Berutu Exp $$
 */
public class LogicalOperation {
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;

        if (num1 > 0 && num2 > 0) {
            System.out.println("Both numbers are positive.");
        } else if (num1 > 0 || num2 > 0) {
            System.out.println("At least one number is positive.");
        } else {
            System.out.println("Both numbers are negative.");
        }

        boolean isRaining = true;
        boolean hasUmbrella = false;

        if (isRaining && !hasUmbrella) {
            System.out.println("You will get wet without an umbrella.");
        } else {
            System.out.println("You are prepared for the rain.");
        }
    }
}
