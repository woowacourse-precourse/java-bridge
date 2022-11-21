package bridge.exception;

public class BridgeSizeException {

    private final static int MIN_SIZE = 3;
    private final static int MAX_SIZE = 20;
    private final static String REGULAR_EXPRESSION = "[-+]?\\d*\\.?\\d+";
    private final static String ERROR = "[ERROR] ";

    public void isValidSize(String input){
        isNumber(input);
        isValidNumber(input);
    }

    public static void isNumber(String input){
        if(input == null || !input.matches(REGULAR_EXPRESSION)){
            throw new IllegalArgumentException(ERROR + "숫자만 입력해주세요.");
        }
    }

    public void isValidNumber(String number){
        int size = Integer.parseInt(number);
        if(size < MIN_SIZE || size > MAX_SIZE){
            throw new IllegalArgumentException(ERROR + "다리 길이는 3이상 20 이하의 숫자입니다.");
        }
    }
}
