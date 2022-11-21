package bridge;

import java.util.List;

public class BridgePainter {
    StringBuilder upBridge;
    StringBuilder downBridge;

    private String bridgePainting;

    public String getBridgePainting() {
        return bridgePainting;
    }

    public String paintBridge(List<String> bridge, int bridgeIdx, boolean result) {
        sbInit();
        paintBefore(bridge, bridgeIdx);
        paintCurrent(bridge, bridgeIdx, result);
        combineStr();
        bridgePainting = upBridge.toString();
        return bridgePainting;
    }

    public void sbInit() {
        upBridge = new StringBuilder("[");
        downBridge = new StringBuilder("[");
    }

    public void paintBefore(List<String> bridge, int bridgeIdx) {
        for (int i = 0; i < bridgeIdx; i++) {
            paint(bridge.get(i));
            divide();
        }
    }

    public void paint(String uOrD) {
        if (uOrD.equals("U")) {
            upBridge.append(" O ");
            downBridge.append(("   "));
        }
        if (uOrD.equals(("D"))) {
            upBridge.append("   ");
            downBridge.append(" O ");
        }
    }

    public void divide() {
        upBridge.append("|");
        downBridge.append("|");
    }

    public void paintCurrent(List<String> bridge, int bridgeIdx, boolean result) {
        if (result) {
            currentO(bridge, bridgeIdx);
        }
        if (!result) {
            currentX(bridge, bridgeIdx);
        }
    }

    public void currentO(List<String> bridge, int bridgeIdx) {
        if (bridge.get(bridgeIdx).equals("U")) {
            upBridge.append(" O ]");
            downBridge.append("   ]");
        }
        if (bridge.get(bridgeIdx).equals("D")) {
            upBridge.append("   ]");
            downBridge.append(" O ]");
        }
    }

    public void currentX(List<String> bridge, int bridgeIdx) {
        if (bridge.get(bridgeIdx).equals("U")) {
            upBridge.append("   ]");
            downBridge.append(" X ]");
        }
        if (bridge.get(bridgeIdx).equals("D")) {
            upBridge.append(" X ]");
            downBridge.append("   ]");
        }
    }

    public void combineStr() {
        upBridge.append("\n");
        upBridge.append(downBridge);
    }

}
