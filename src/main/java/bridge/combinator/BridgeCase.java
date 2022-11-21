package bridge.combinator;

public enum BridgeCase {
    TRUE_ZERO_UP(true, true, "U") {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge) {
            upSideBridge.insert(2, "O");
            downSideBridge.insert(2, " ");
        }
    },
    TRUE_POSITIVE_UP(true, false, "U") {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge) {
            upSideBridge.insert(upSideBridge.length() - 1, "| O ");
            downSideBridge.insert(downSideBridge.length() - 1, "|   ");
        }
    },
    TRUE_ZERO_DOWN(true, true, "D") {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge) {
            upSideBridge.insert(2, " ");
            downSideBridge.insert(2, "O");
        }
    },
    TRUE_POSITIVE_DOWN(true, false, "D") {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge) {
            upSideBridge.insert(upSideBridge.length() - 1, "|   ");
            downSideBridge.insert(downSideBridge.length() - 1, "| O ");
        }
    },
    FALSE_ZERO_UP(false, true, "U") {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge) {
            upSideBridge.insert(2, "X");
            downSideBridge.insert(2, " ");
        }
    },
    FALSE_POSITIVE_UP(false, false, "U") {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge) {
            upSideBridge.insert(upSideBridge.length() - 1, "| X ");
            downSideBridge.insert(downSideBridge.length() - 1, "|   ");
        }
    },
    FALSE_ZERO_DOWN(false, true, "D") {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge) {
            upSideBridge.insert(2, " ");
            downSideBridge.insert(2, "X");
        }
    },
    FALSE_POSITIVE_DOWN(false, false, "D") {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge) {
            upSideBridge.insert(upSideBridge.length() - 1, "|   ");
            downSideBridge.insert(downSideBridge.length() - 1, "| X ");
        }
    },
    NOTHING(false, false, "NOT") {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge) { }
    };

    private final boolean isAnswer;
    private final boolean isFirst;
    private final String mark;

    BridgeCase(boolean isAnswer, boolean isFirst, String mark) {
        this.isAnswer = isAnswer;
        this.isFirst = isFirst;
        this.mark = mark;
    }

    public boolean isAnswer() {
        return isAnswer;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public String getMark() {
        return mark;
    }

    abstract public void add(StringBuilder upSideBridge, StringBuilder downSideBridge);
}
