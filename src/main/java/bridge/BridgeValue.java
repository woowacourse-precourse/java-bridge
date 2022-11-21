package bridge;

public class BridgeValue {

    public static int tryCounts = 1;

    public static int getTryCounts() {
        return tryCounts;
    }


    public static String getDivisionOrBracket(int size, int index) {
        if (size == index) {
            return getNothing();
        }
        return getDivision();
    }
    public static String getMoveState(String computerState, String userState) {
        if (computerState.equals(userState)) {
            return getMoveAble();
        }
        return getMoveUnable();
    }

    public static boolean checkUpState(String state) {
        if (state.equals(getUp())) {
            return true;
        }
        return false;
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

    public static String getSpace() {
        return Drawing
                .SPACE
                .getStructure();
    }

    public static String getComma() {
        return Drawing
                .COMMA
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
        RE_TRY("R"),
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
        DIVISION("|"),
        MOVE_ABLE_VALUE("O"),
        MOVE_UNABLE_VALUE("X"),
        COMMA(","),
        SPACE(" "),
        NOTHING("");

        private final String structure;

        Drawing(String structure) {
            this.structure = structure;
        }

        public String getStructure() {
            return structure;
        }
    }
}
