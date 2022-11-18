package bridge.presentation.dto;

import bridge.support.Validator;

public class BridgeSize {
    private Integer size;

    public BridgeSize(String input){
        validate(input);
        size=Integer.parseInt(input);
    }
    private void validate(String input){
        Validator.checkInteger(input);
    }
    public Integer getSize() {
        return size;
    }
}
