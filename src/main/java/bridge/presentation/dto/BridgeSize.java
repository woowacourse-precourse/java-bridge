package bridge.presentation.dto;

public class BridgeSize {
    private Integer size;

    public BridgeSize(String input){
        validate(input);
        size=Integer.parseInt(input);
    }
    private void validate(String input){

    }
    public Integer getSize() {
        return size;
    }
}
