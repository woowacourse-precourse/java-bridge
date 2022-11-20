package bridge;

import java.util.*;

public enum
InputSort {
    Up("U", 0),
    Down("D", 1);

    private String upOrDown;
    private int zeroOrOne;

    private InputSort(String upOrDown, int zeroOrOne) {
        this.upOrDown = upOrDown;
        this.zeroOrOne = zeroOrOne;
    }

    public static int getZeroOrOne(String upOrDown) {
        return Arrays.stream(InputSort.values()).filter(inputSort -> inputSort.upOrDown.equals(upOrDown)).map(inputSort -> inputSort.zeroOrOne).findAny().orElseThrow(() -> new IllegalArgumentException());
    }
}
