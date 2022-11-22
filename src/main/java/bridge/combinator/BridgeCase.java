package bridge.combinator;

import bridge.constant.BridgeDirection;

public enum BridgeCase {
    FIRST_UP(true, BridgeDirection.UP.getMark()) {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge, String bridgeState) {
            upSideBridge.insert(2, bridgeState);
            downSideBridge.insert(2, " ");
        }
    },
    NOT_FIRST_UP(false, BridgeDirection.UP.getMark()) {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge, String bridgeState) {
            upSideBridge.insert(upSideBridge.length() - 1, "| " + bridgeState + " ");
            downSideBridge.insert(downSideBridge.length() - 1, "|   ");
        }
    },
    FIRST_DOWN(true, BridgeDirection.DOWN.getMark()) {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge, String bridgeState) {
            upSideBridge.insert(2, " ");
            downSideBridge.insert(2, bridgeState);
        }
    },
    NOT_FIRST_DOWN(false, BridgeDirection.DOWN.getMark()) {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge, String bridgeState) {
            upSideBridge.insert(upSideBridge.length() - 1, "|   ");
            downSideBridge.insert(downSideBridge.length() - 1, "| " + bridgeState + " ");
        }
    },
    NOTHING(false, "NOT") {
        @Override
        public void add(StringBuilder upSideBridge, StringBuilder downSideBridge, String bridgeState) {
        }
    };

    private final boolean isFirst;
    private final String mark;

    BridgeCase(boolean isFirst, String mark) {
        this.isFirst = isFirst;
        this.mark = mark;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public String getMark() {
        return mark;
    }

    abstract public void add(StringBuilder upSideBridge, StringBuilder downSideBridge, String bridgeState);
}
