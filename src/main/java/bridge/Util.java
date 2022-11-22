package bridge;

public class Util {

    /**
     * 숫자인가?
     */
    public static boolean isNumber(final String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * 문자인가?
     */
    public static boolean isLetter(final String input) {
        try {
            Double.parseDouble(input);
            return false;
        } catch (NumberFormatException nfe) {
            return true;
        }
    }

    /**
     * 한 글자인가?
     */
    public static boolean isOneLetter(final String input) {
        return input.length() == 1;
    }

    /**
     * 여러 글자인가?
     */
    public static boolean isString(final String input) {
        return input.length() != 1;
    }

    /**
     * 1, 0 입력받고 U, D 리턴(어디론가 이관해야하는가? 생각)
     */
    public static String convertBridgeNumberGenerator(final int number) {
        if (number == 1) {
            return "U";
        }

        return "D";
    }

    /**
     * 문자열인 숫자열을 정수로 바꿔준다
     */
    public static Integer stringToInteger(final String input) throws IllegalArgumentException {
        try {
            ExceptionBasket.inputIsNotNumberException(input);
            ExceptionBasket.inputIsNotRangeException(input);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(iae);
        }

        Integer convertInput = Integer.valueOf(input);
        return convertInput;
    }

}
