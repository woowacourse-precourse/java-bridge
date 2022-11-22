package bridge.controller;

import java.util.*;

public enum
InputUpOrDown {
    Up("U", 1),
    Down("D", 0);

    private String upOrDown;
    private int zeroOrOne;

    InputUpOrDown(String upOrDown, int zeroOrOne) {
        this.upOrDown = upOrDown;
        this.zeroOrOne = zeroOrOne;
    }

    public static int getZeroOrOne(String upOrDown) {
        return Arrays.stream(InputUpOrDown.values()).filter(inputUpOrDown -> inputUpOrDown.upOrDown.equals(upOrDown)).map(inputUpOrDown -> inputUpOrDown.zeroOrOne).findAny().orElseThrow(() -> new IllegalArgumentException());
    }

    public static String getUpOrDown(int zeroOrOne){
        return Arrays.stream(InputUpOrDown.values()).filter(inputUpOrDown -> inputUpOrDown.zeroOrOne==zeroOrOne).map(inputUpOrDown -> inputUpOrDown.upOrDown).findAny().orElseThrow(() -> new IllegalArgumentException());
    }
}
