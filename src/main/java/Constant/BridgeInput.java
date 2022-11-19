package Constant;

import java.util.List;

public enum BridgeInput {
    MOVE_CHOICE(List.of("U","D")),
    GAME_RESTART(List.of("R","Q"));

    private final List<String> inputRange;

    BridgeInput(List<String> inputRange) {
        this.inputRange = inputRange;
    }
    public List<String> getValue(){
        return inputRange;
    }

}
