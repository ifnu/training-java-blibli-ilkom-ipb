
public class Grader {

    public static void main(String[] args) {

        int mark = 99;
        if (args.length > 0) {
            mark = Integer.parseInt(args[0]);
        }

        if (mark < 0 || mark > 100) {
            System.out.println(
                    "mark " + mark + " is out of range");
        } else if (mark >= 0 && mark < 30) {
            System.out.println(
                    "Grade E");
        } else if (mark >= 30 && mark < 50) {
            System.out.println(
                    "Grade D");
        } else if (mark >= 50 && mark < 70) {
            System.out.println(
                    "Grade C");
        } else if (mark >= 70 && mark < 85) {
            System.out.println(
                    "Grade B");
        } else {
            System.out.println(
                    "Grade A");
        }

    }

}
