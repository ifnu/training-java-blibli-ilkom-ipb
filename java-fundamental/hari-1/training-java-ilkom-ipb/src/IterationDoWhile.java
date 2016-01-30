
public class IterationDoWhile {

    public static void main(String[] args) {
        int x = 0;
        do {
            x++;

            if (x == 8) {
                break;
            } else if (x == 6) {
                continue;
            }

            System.out.println(
                    "iteration : " + x);

        } while (x <= 10);

    }

}
