package bridge;

public class Validator {

    public static void validateRangeOfInt(int num, int start, int end) {
        if (start > num || num > end) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDir(String dir) {
        Direction.valueOf(dir);
    }

}
