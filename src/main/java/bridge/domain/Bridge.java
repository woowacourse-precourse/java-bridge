package bridge.domain;

import bridge.constant.UpDownConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bridge {

    private final List<String> bridge;

    public Bridge() {
        this.bridge = new ArrayList<>();
    }

    public Bridge(final List<String> bridge) {
        this.bridge = bridge;
    }

    public void addBridge(UpDownConstant upDownConstant) {
        bridge.add(upDownConstant.getSymbol());
    }

    public String valueAt(int idx) {
        return bridge.get(idx);
    }

    public int length() {
        return bridge.size();
    }

    public boolean equalsAt(Bridge compareBridge, int idx) {
        return Objects.equals(valueAt(idx), compareBridge.valueAt(idx));
    }

    public boolean equalsLength(Bridge compareBridge) {
        return length() == compareBridge.length();
    }

    public String toString(final Bridge compareBridge) {
        StringBuilder bridgeBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            toStringRow(compareBridge, bridgeBuilder, i);
        }
        return bridgeBuilder.toString();
    }

    private void toStringRow(Bridge compareBridge, StringBuilder bridgeBuilder, int row) {
        bridgeBuilder.append("[");
        for (int j = 0; j < length(); j++) {
            bridgeBuilder.append(toStringRowCol(compareBridge, row, j));
            if (this.hasNextIdx(j)) {
                bridgeBuilder.append("|");
            }
        }
        bridgeBuilder.append("]\n");
    }

    private String toStringRowCol(Bridge compareBridge, int row, int col) {
        if (UpDownConstant.of(this.valueAt(col)).isSameRow(row)) {
            if (this.equalsAt(compareBridge, col)) {
                return " O ";
            }
            return " X ";
        }
        return "   ";
    }

    private boolean hasNextIdx(int idx) {
        return idx + 1 < length();
    }
}
