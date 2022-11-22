package console;

public enum Ladder {
        START("[ "),
        SPACE(" "),
        END(" ]"),
        DIVIDER(" | "),
        CORRECT("O"),
        WRONG("X");

        private final String sign;

        Ladder(String sign) {
            this.sign = sign;
        }

        public String getSign() {
            return this.sign;
        }

}
