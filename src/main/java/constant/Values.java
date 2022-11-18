package constant;

public class Values {
    public enum BridgeCase {
        POSITIVE(1, "U"),
        NEGATIVE(0, "D");
        private int flag;
        private String value;

        private BridgeCase(int flag, String value) {
            this.flag = flag;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getFlag() {
            return flag;
        }

    }
}
