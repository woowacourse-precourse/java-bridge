package bridge.domain.oxbridgebuilder;

import bridge.domain.resources.UpOrDown;
import java.util.List;

public class OXBridge {

    private final List<String> upBridge;
    private final List<String> downBridge;

    private OXBridge(List<String> upBridge, List<String> downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
    }

    public static OXBridge from(List<String> emptyUp, List<String> emptyDown) {
        return new OXBridge(emptyUp, emptyDown);
    }

    public void addUD(UpOrDown upOrDown, boolean correctOrWrong) {
        String UD = upOrDown.getInputUD();
        String ox = OXBridgeUtils.makeOX(correctOrWrong);

        InputIsU(UD, ox);
        InputIsD(UD, ox);
    }

    private void InputIsU(String UD, String ox) {
        if (UD.equals(UpOrDown.UP)) {
            upBridge.add(ox);
            downBridge.add(OXBridgeUtils.SPACE);
        }
    }

    private void InputIsD(String UD, String ox) {
        if (UD.equals(UpOrDown.DOWN)) {
            upBridge.add(OXBridgeUtils.SPACE);
            downBridge.add(ox);
        }
    }

    public int sizeOfOXBridge() {
        return upBridge.size();
    }

    public String toString() {
        return OXBridgeUtils.makingResult(upBridge, downBridge);
    }
}
