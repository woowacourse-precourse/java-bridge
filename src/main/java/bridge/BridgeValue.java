package bridge;

public class BridgeValue {

    public enum Information {
        UP("U"),
        DOWN("D"),
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
}
