package bridge;

import java.util.Arrays;

public enum GameResultCondition {
    UPPERPASS("O","U","U"),
    LOWERPASS("O","D","D"),
    FAIL("X","U","D");

    private String result;
    private String inputMoving;
    private String bridge;

    GameResultCondition(String result, String inputMoving, String bridge) {
        this.inputMoving = inputMoving;
        this.bridge = bridge;
        this.result = result;
    }
    public String getResult(){
        return result;
    }
    public String getInputMoving(){
        return inputMoving;
    }
    public String getBridge(){
        return bridge;
    }

    public static GameResultCondition of(final String inputMoving, final String bridge){
        return Arrays.stream(values())
                .filter(v -> inputMoving.equals(bridge))
                .filter(v -> inputMoving.equals(v.inputMoving))
                .filter(v -> bridge.equals(v.bridge))
                .findFirst()
                .orElse(FAIL);
    }


}
