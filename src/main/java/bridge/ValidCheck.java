package bridge;

public class ValidCheck {
    public static boolean isString_in_1to9(String str) {
        return str.matches("[0-9.]+");
    }

    public static boolean isRange_3to20(int num) {
        return num >= 3 && num <= 20;
    }

    public static boolean isUorD(String str) {
        return str.matches("[U,D]+");
    }

    public static boolean isRorQ(String str) {
        return str.matches("[R,Q]+");
    }

    public static boolean isLength1(String str) {
        return str.length() == 1;
    }
}
