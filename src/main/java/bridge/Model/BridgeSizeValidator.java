package bridge.Model;

public class BridgeSizeValidator implements Validator {
    private static final String ERROR_NON_NUMERIC_VALUE = "[ERROR] 숫자 이외의 값을 입력할 수 없습니다.";
    private static final String ERROR_OUT_OF_RANGE = "[ERROR] 입력 가능한 범위를 초과하였습니다.(3 <= N <= 20)";

    public void validate(String input) {
        validateNumericInput(input);
        validateRange(input);
    }

    /**
     *  입력 값이 숫자가 아니면 예외 발생
     */
    private void validateNumericInput(String input){
        try{
             Integer.parseInt(input);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_VALUE);
        }
    }

    /**
     *  입력 값이 제한된 범위를 벗어난 값이라면 예외 발생(3 <= N <= 30)
     */
    private void validateRange(String input){
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < 3 || bridgeSize > 30){
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }
}
