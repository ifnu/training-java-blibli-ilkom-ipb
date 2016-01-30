
public class IterationWhile {

    public static void main(String[] args) {
        int x = 0;
        while (x <= 10) {
            x++;

            if (x == 8) {
                break;
            } else if (x == 6) {
                continue;
            }

            System.out.println(
                    "iteration : " + x);

        }

    }

}
