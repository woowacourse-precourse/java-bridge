package bridge.exception;

public class ValidException {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String INPUT_INTEGER = " 다리 길이는 정수형으로 입력되어야 합니다.";
    private static final String INPUT_VALID_RANGE = " 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String UP_STEP = "U";
    private static final String DOWN_STEP = "D";

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

    public void validMoveNextStep(String next){
        validMoveStringLength(next);
        validMoveStringType(next);
    }

    private void validMoveStringLength(String next){
        if(next.length() != 1){
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void validMoveStringType(String next){
        if(!next.equals(UP_STEP) || !next.equals(DOWN_STEP)) {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
