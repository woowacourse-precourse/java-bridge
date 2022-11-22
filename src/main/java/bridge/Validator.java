package bridge;

public class Validator {
    private static final String pattern = "[0-9]*$";

    public static void numberValidate(String number) {
        if (!(number.matches(pattern))) {
            throw new IllegalArgumentException();   //정수 확인
        }
    }

    public static void bridgeSizeValidate(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException();   //3~20
        }
    }
}
