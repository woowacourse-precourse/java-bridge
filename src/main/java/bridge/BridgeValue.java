package bridge;

public class BridgeValue {

    public static final int BRIDGE_LINE = 2;

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
        UN_MOVE_ABLE_VALUE("X ");

        private final String structure;

        Drawing(String structure) {
            this.structure = structure;
        }

        public String getStructure() {
            return structure;
        }
    }
}
