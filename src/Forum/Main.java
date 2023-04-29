package Forum;

/**
 * @author Yosepri Disyandro Berutu (yosepri.disyandro@dana.id)
 * @version $Id: Main.java , v 0.1 2023-03-31 23.23 Yosepri Disyandro Berutu Exp $$
 */
public class Main {
    public static void main(String args[]){
        boolean val;
        int x = 2;

        int y = 0;

        for ( ; y < 10; ++y)

        {

            if (y % x == 0)
                continue;

            else if (y == 8)
                break;
            else
                System.out.print(y + " ");

        }
    }
}
