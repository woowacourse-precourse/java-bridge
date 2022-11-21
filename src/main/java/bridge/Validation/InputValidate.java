package bridge.Validation;

public class InputValidate {
    private static final String BRIDGE_SIZE_MESSAGE = "[ERROR] 3 이상 20 이하의 길이를 입력해주세요";
    private static final String MOVING_FORMAT_MESSAGE = "[ERROR] U 나 D 만 입력해주세요";

    public void validateSizeFormat(int length){
        if(length < 3 && length > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_MESSAGE);
        }
    }
    public void validateMovingFormat(String moving){
        if(!moving.equals("U") || !moving.equals("D")){
            throw new IllegalArgumentException(MOVING_FORMAT_MESSAGE);
        }
    }
}