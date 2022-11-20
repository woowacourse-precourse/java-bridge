package bridge.Model;

public class BridgeSizeValidator implements Validator {
    private static final String ERROR_NON_NUMERIC_VALUE = "[ERROR] 숫자 이외의 값을 입력할 수 없습니다.";
    private static final String ERROR_OUT_OF_RANGE = "[ERROR] 입력 가능한 범위를 초과하였습니다.(3 <= N <= 20)";

    public void validate(String input) {

    }

    private void validateNumericInput(String input){
        try{
             Integer.parseInt(input);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_VALUE);
        }
    }
}
