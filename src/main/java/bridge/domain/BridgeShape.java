package bridge.domain;

import bridge.constant.MatchConst;
import bridge.constant.MatchConst.Button;

import java.util.Arrays;

public enum BridgeShape {
    UP(1, Button.UP_BOTTON),
    DOWN(0,Button.DOWN_BOTTON),
    NONE(-1,Button.NONE_BOTTON);

    private final int shapeNumber;
    private final String shapeKeyword;

    BridgeShape(int shapeNumber , String shapeKeyword){
        this.shapeNumber = shapeNumber;
        this.shapeKeyword= shapeKeyword;
    }

    public static BridgeShape findByNumber(int shapeNumber){
        return Arrays.stream(BridgeShape.values())
                .filter(bridgeShape -> bridgeShape.shapeNumber == shapeNumber)
                .findAny()
                .orElse(NONE);
    }

    public String getKeyword(){
        return this.shapeKeyword;
    }
}
