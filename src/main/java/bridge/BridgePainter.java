package bridge;

import java.util.List;

public class BridgePainter {
    StringBuilder sb1;
    StringBuilder sb2;

    private String bridgePainting;

    public String getBridgePainting() {
        return bridgePainting;
    }

    public String paintBridge(List<String> bridge, int bridgeIdx, boolean result) {
        sbInit();
        paintBefore(bridge, bridgeIdx);
        paintCurrent(bridge, bridgeIdx, result);
        combineStr();
        bridgePainting = sb1.toString();
        return bridgePainting;
    }

    public void sbInit() {
        sb1 = new StringBuilder("[");
        sb2 = new StringBuilder("[");
    }

    public void paintBefore(List<String> bridge, int bridgeIdx) {
        for (int i = 0; i < bridgeIdx; i++) {
            paint(bridge.get(i));
            divide();
        }
    }

    public void paint(String uOrD) {
        if (uOrD.equals("U")) {
            sb1.append(" O ");
            sb2.append(("   "));
        }
        if (uOrD.equals(("D"))) {
            sb1.append("   ");
            sb2.append(" O ");
        }
    }

    public void divide() {
        sb1.append("|");
        sb2.append("|");
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
            sb1.append(" O ]");
            sb2.append("   ]");
        }
        if (bridge.get(bridgeIdx).equals("D")) {
            sb1.append("   ]");
            sb2.append(" O ]");
        }
    }

    public void currentX(List<String> bridge, int bridgeIdx) {
        if (bridge.get(bridgeIdx).equals("U")) {
            sb1.append("   ]");
            sb2.append(" X ]");
        }
        if (bridge.get(bridgeIdx).equals("D")) {
            sb1.append(" X ]");
            sb2.append("   ]");
        }
    }

    public void combineStr() {
        sb1.append("\n");
        sb1.append(sb2);
    }

}
