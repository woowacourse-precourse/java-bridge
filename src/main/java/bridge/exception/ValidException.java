package bridge.exception;

public class ValidException {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String INPUT_INTEGER = "다리 길이는 정수형으로 입력되어야 합니다.";
    private static final String INPUT_VALID_RANGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public void validInteger(String inputString){
        try{
            Integer.parseInt(inputString);
        } catch (NumberFormatException e){
            System.out.println(ERROR_MESSAGE + INPUT_INTEGER);
            throw new IllegalArgumentException();
        }
    }

    public void validIntegerRange(int length){
        if(!(3 <= length && length <= 20)){
            System.out.println(ERROR_MESSAGE + INPUT_VALID_RANGE);
            throw new IllegalArgumentException();
        }
    }
}
