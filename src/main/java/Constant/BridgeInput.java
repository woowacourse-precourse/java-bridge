package Constant;

import java.util.List;

public enum BridgeInput {
    MOVE_CHOICE(List.of("U","D"),"이동을 위한 값은 U나 D만 가능합니다."),
    GAME_RESTART(List.of("R","Q"),"game command는 Q나 R만 가능합니다.");

    private final List<String> inputRange;
    private static final String errorBase="[ERROR]";
    private final String errorMsg;
    BridgeInput(List<String> inputRange, String errorMsg) {
        this.inputRange = inputRange;
        this.errorMsg = errorMsg;
    }
    public List<String> getValue(){
        return inputRange;
    }
    public String getErrorMsg(){
        return errorBase+errorMsg;
    }
}
