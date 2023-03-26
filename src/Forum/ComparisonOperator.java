package Forum;

/**
 * @author Yosepri Disyandro Berutu (yosepri.disyandro@dana.id)
 * @version $Id: ComparisonOperator.java , v 0.1 2023-03-22 21.21 Yosepri Disyandro Berutu Exp $$
 */
public class ComparisonOperator {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 1;
        // 1. equals
        if (a == c) {
            System.out.println("a equals to c");
        }
        // 2. less than
        if (a < b) {
            System.out.println("a less than b");
        }
        // 3. greater than
        if (b > a) {
            System.out.println("b greater than a");
        }
        // 4. not equals to
        if (a != b) {
            System.out.println("a not equals to b");
        }
        // 5. greater than or equals to
        if (b >= a) {
            System.out.println("a greater than or equals to a");
        }
        // 6. less than of equals to
        if (a <= b) {
            System.out.println("a less than or equals to b");
        }
    }
}
