package bridge.exception;

public class BridgeSizeException {

    private final static int MIN_SIZE = 3;
    private final static int MAX_SIZE = 20;
    private final static String REGULAR_EXPRESSION = "^[0-9]*$";
    private final static String ERROR = "[ERROR] ";

    public void isValidSize(String input){
        isNull(input);
        isNumber(input);
        isValidNumber(input);
    }

    public void isNull(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException(ERROR + "입력값이 비었습니다.");
        }
    }

    public void isNumber(String input){
        if(!input.matches(REGULAR_EXPRESSION)){
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
