package bridge;

public class NumberConvertor {

    public static String up = "U";
    public static String down = "D";
    // 여기있으면 안되고 다른 곳에서 선언되어야 할 듯?

    public String convert(int number) {
        if (number == 1) {
            return up;
        }
        return down;
    }

}
