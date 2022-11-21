package bridge.util;

public class NumericConverter {

    private static final String ERROR_MESSAGE = "숫자로 변환할 수 없는 입력입니다. 입력 : %s";

    private NumericConverter() {
    }

    public static int convert(String from) {
        try {
            return Integer.parseInt(from);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, from));
        }
    }

}
