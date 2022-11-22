package bridge.presentation.dto;

import bridge.support.Validator;

public class BridgeSize {
    private final Integer size;

    public BridgeSize(String input){
        validate(input);
        size=Integer.parseInt(input);
    }
    private void validate(String input){
        Validator.checkInteger(input);
        Validator.checkRange(input);
    }
    public Integer getSize() {
        return size;
    }
}
