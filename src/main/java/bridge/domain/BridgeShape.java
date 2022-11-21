package bridge.domain;

import java.util.Arrays;

public enum BridgeShape {
    UP(1,"U"),
    DOWN(0,"D");

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
                .orElseThrow(()-> new IllegalArgumentException("[ERROR] 잘못된 번호를 입력했습니다."));
    }

}
