package bridge;

import java.math.BigInteger;

public class ExceptionBasket {

    public static final int MAX = 20;
    public static final int MIN = 1;

    /**
     * 1 ~ 20이외의 정수나 맨 앞에 0과 +가 나온다면 예외 처리
     */
    public static void inputIsNotRangeException(final String input) throws IllegalArgumentException {
        BigInteger tmpInput;
        try {
            tmpInput = new BigInteger(input);
        } catch (IllegalArgumentException iae) {
            throw OutputExceptionMessage.NOT_RANGE_EXCEPTION.getException();
        }
        if (tmpInput.compareTo(BigInteger.valueOf(MIN)) == -1 || tmpInput.compareTo(BigInteger.valueOf(MAX)) == 1
                || input.indexOf('0') == 0 || input.indexOf('+') == 0) {
            throw OutputExceptionMessage.NOT_RANGE_EXCEPTION.getException();
        }
    }

    /**
     * 숫자가 아닐 경우 예외 처리
     */
    public static void inputIsNotNumberException(final String input) throws IllegalArgumentException {
        if (!Util.isNumber(input)) {
            throw OutputExceptionMessage.NOT_NUMBER_EXCEPTION.getException();
        }
    }

    /**
     * 다리를 이동 중 잘못된 키를 입력시 예외 발생
     */
    public static void invalidGameKey(final String input) throws IllegalArgumentException {
        if (!input.equals("U") && !input.equals("D")) {
            throw OutputExceptionMessage.INVALID_GAME_KEY_EXCEPTION.getException();
        }
    }

    /**
     * 게임을 다시 시작할 때 잘못된 키를 입력 시 예외 발생
     */
    public static void invalidRetryRequestInputKey(final String input) throws IllegalArgumentException {
        if (!input.equals("R") && !input.equals("Q")) {
            throw OutputExceptionMessage.INVALID_RETRY_REQUEST_INPUT_KEY_EXCEPTION.getException();
        }
    }

}
