package bridge;

public class BridgeInputExceptionValidation {

    private static final String INPUT_INTEGER_NUMBER_ERROR = "[ERROR] 숫자만 입력해주세요.";
    private static final String INPUT_RANGE_NUMBER_ERROR = "[ERROR] 다리 길이는 3~20 이어야 합니다.";
    private static final int MIN_SIZE_RANGE = 3;
    private static final int MAX_SIZE_RANGE = 20;
    public void valid(String input){
        if(!isNumber(input)) {
            throw new IllegalArgumentException(INPUT_INTEGER_NUMBER_ERROR);
        }

    }

    // 다리길이 입력이 숫자인지 예외처리
    private boolean isNumber(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private void isRange(String input){
        int size = Integer.parseInt(input);
        if(size > MAX_SIZE_RANGE || size < MIN_SIZE_RANGE) {
            throw new IllegalArgumentException(INPUT_RANGE_NUMBER_ERROR);
        }

    }
}

