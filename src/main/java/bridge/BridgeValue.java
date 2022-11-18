package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeValue {

    public static final int BRIDGE_LINE = 2;

    public static String getDivisionOrBracket(int size, int index) {
        if (size == index) {
            return getRightSide();
        }
        return getDivision();
    }

    public static String getUpState(String rightState, String userState) {
        if (rightState.equals(userState)) {
            String upState = getUp();
            if (upState.equals(userState)) {
                return getMoveAble();
            }
            return getNothing();
        }
        return getMoveUnable();
    }

    public static String getDownState(String rightState, String userState) {
        if (rightState.equals(userState)) {
            String downState = getDown();
            if (downState.equals(userState)) {
                return getMoveAble();
            }
            return getNothing();
        }
        return getMoveUnable();
    }

    public static String getDivision() {
        return Drawing
                .DIVISION
                .getStructure();
    }

    public static String getNothing() {
        return Drawing
                .NOTHING
                .getStructure();
    }

    public static String getMoveAble() {
        return Drawing
                .MOVE_ABLE_VALUE
                .getStructure();
    }

    public static String getMoveUnable() {
        return Drawing
                .MOVE_UNABLE_VALUE
                .getStructure();
    }

    public static List<String> getLeftSide() {
        List<String> bridgeMap = new ArrayList<>();
        String leftSide = Drawing
                .LEFT_SIDE
                .getStructure();

        bridgeMap.add(leftSide);
        return bridgeMap;
    }

    public static String getRightSide() {
        return Drawing
                .RIGHT_SIDE
                .getStructure();
    }

    public static String getDown() {
        return Information
                .DOWN
                .getValue();
    }

    public static String getUp() {
        return Information
                .UP
                .getValue();
    }

    public static int stringToInt(String input) {
        return Integer.valueOf(input);
    }

    public enum Information {
        UP("U"),
        DOWN("D"),
        UP_VALUE("1"),
        DOWN_VALUE("0"),
        QUIT("Q"),
        RE_START("R"),
        MINIMUM_LENGTH("3"),
        MAXIMUM_LENGTH("20");

        private final String value;

        Information(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Drawing {
        LEFT_SIDE("[ "),
        RIGHT_SIDE("]"),
        DIVISION("| "),
        MOVE_ABLE_VALUE("O "),
        MOVE_UNABLE_VALUE("X "),
        NOTHING("  ");

        private final String structure;

        Drawing(String structure) {
            this.structure = structure;
        }

        public String getStructure() {
            return structure;
        }
    }
}
