package bridge;

import java.math.BigInteger;

public class ExceptionBasket {

    public static final int MAX = 20;
    public static final int MIN = 1;
    public static final String ERROR_MESSAGE = "[ERROR]";

    //1 ~ 20이외의 정수나 맨 앞에 0과 +가 나온다면 예외 처리
    public static void inputIsNotRangeException(String input) throws IllegalArgumentException {
        BigInteger tmpInput;
        try {
            tmpInput = new BigInteger(input);
        }catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 1~20사이의 정수가 아닙니다.");
        }
        if (tmpInput.compareTo(BigInteger.valueOf(MIN)) == -1 || tmpInput.compareTo(BigInteger.valueOf(MAX)) == 1
                || input.indexOf('0') == 0 || input.indexOf('+') == 0){
            throw new IllegalArgumentException(ERROR_MESSAGE + " 1~20사이의 정수가 아닙니다.");
        }
    }

    //숫자가 아닐 경우 예외 처리
    public static void inputIsNotNumberException(String input) throws IllegalArgumentException {
        if (Util.isNumber(input)){
            throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자가 아닙니다!");
        }
    }

    public static void invalidGameKey(String input) throws IllegalArgumentException {
        if (!input.equals("U") || !input.equals("D")){
            throw new IllegalArgumentException(ERROR_MESSAGE + " U나 D를 누르세요!");
        }
    }

    public static void invalidRetryRequestInputKey(String input) throws IllegalArgumentException{
        if (!input.equals("R") || !input.equals("Q")){
            throw new IllegalArgumentException(ERROR_MESSAGE + " R이나 Q를 누르세요!");
        }
    }

    /*public static void invalidNumberic(String input) throws IllegalArgumentException {
        if (input.indexOf('+') == 0
                || input.indexOf('0') == 0
                || input.indexOf('-') == 0){
            throw new IllegalArgumentException(ERROR_MESSAGE + " 잘못된 숫자열입니다.");
        }
    }*/

}
