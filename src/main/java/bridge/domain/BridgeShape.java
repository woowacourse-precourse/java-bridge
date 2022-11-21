package bridge.domain;

import java.util.Arrays;

public enum BridgeShape {
    UP(1,"U"),
    DOWN(0,"D"),
    NONE(-1,"NONE");

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
