package bridge;

import java.util.List;

public class BridgePainter {
    StringBuilder upBridge = new StringBuilder("[");
    StringBuilder downBridge = new StringBuilder("[");

    public void paint(List bridge, int currentSpot, boolean success) {
        for (int i = 0; i < currentSpot; i++) {
            paintBefore(bridge, i);
        }
        paintCurrent(bridge, currentSpot, success);
        closeBridge();
    }

    private void paintBefore(List bridge, int index) {
        insertO(bridge, index, upBridge, "U");
        divide(upBridge);
        insertO(bridge, index, downBridge, "D");
        divide(downBridge);
    }

    private void insertO(List bridge, int index, StringBuilder sb, String uOrD) {
        if (bridge.get(index).equals(uOrD)) {
            sb.append(" O ");
            return;
        }
        sb.append("   ");
    }

    private void divide(StringBuilder stringBuilder) {
        stringBuilder.append("|");
    }

    private void paintCurrent(List bridge, int index, boolean success) {
        if (success) {
            insertO(bridge, index, upBridge, "U");
            insertO(bridge, index, downBridge, "D");
            return;
        }
        insertX(bridge, index, upBridge, "U");
        insertX(bridge, index, downBridge, "D");
    }

    private void insertX(List bridge, int index, StringBuilder sb, String uOrD) {
        if (bridge.get(index).equals(uOrD)) {
            sb.append("   ");
            return;
        }
        sb.append(" X ");
    }

    private void closeBridge() {
        upBridge.append("]");
        downBridge.append("]");
    }

    @Override
    public String toString() {
        return upBridge.toString() + "\n" + downBridge.toString();
    }
}
