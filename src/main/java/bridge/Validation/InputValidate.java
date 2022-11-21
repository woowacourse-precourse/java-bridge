package bridge.Validation;

public class InputValidate {
    private static final String BRIDGE_SIZE_MESSAGE = "[ERROR] 3 이상 20 이하의 길이를 입력해주세요";

    public void validateSizeFormat(int length){
        if(length < 3 && length > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_MESSAGE);
        }
    }


}