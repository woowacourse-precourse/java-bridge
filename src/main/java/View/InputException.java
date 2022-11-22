package View;

public class InputException {

    /**
     * determine String is U, or D
     * @param str String, input value
     */
    public static void isCorrectRetryCommand(String str) {
        if (str.length() != 1) {
            throw new IllegalArgumentException("하나의 문자만 입력해 주세요.");
        }
        if (!(str.contains("R") || str.contains("Q"))) {
            throw new IllegalArgumentException("'R', 'Q'중 하나의 문자만 입력해 주세요.");
        }
    }


    /**
     * determine String is U, or D
     * @param str String, input value
     */
    public static void isCorrectMoveCommand(String str) {
        if (str.length() != 1) {
            throw new IllegalArgumentException("하나의 문자만 입력해 주세요.");
        }
        if (!(str.contains("U") || str.contains("D"))) {
            throw new IllegalArgumentException("'U', 'D'중 하나의 문자만 입력해 주세요.");
        }
    }

    /**
     * determine String is number and in range
     * @param str input value
     */
    public static void isCorrectBridgeLength(String str) {
        if (!InputException.isDigit(str)) {
            throw new IllegalArgumentException("다리 길이는 숫자여야 합니다.");
        }
        if (!InputException.isRange(Integer.parseInt(str), 3, 20)) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
    /**
     * Determine String is Number
     * @param str input String
     * @return when String is Digits Set return true
     */
    private static boolean isDigit(String str) {
        for(int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if (!Character.isDigit(t)) {
                return false;
            }
        }
        return true;
    }

    /**
     * return n is in range start, end
     * @param n int
     * @param start int range start
     * @param end int range end
     * @return when n in range start, end, return true
     */
    private static boolean isRange(int n, int start, int end) {
        if (n < start || n > end) {
            return false;
        }
        return true;
    }
}
