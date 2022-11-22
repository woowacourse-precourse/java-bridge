package bridge.domain.oxbridgebuilder;

import bridge.domain.resources.UpOrDown;

public class OXBridge {

    private static int tries;

    private final UDBridge upBridge;
    private final UDBridge downBridge;
    private boolean correctOrWrong;

    private OXBridge() {
        this.upBridge = UDBridge.of();
        this.downBridge = UDBridge.of();
    }

    public static OXBridge from() {
        tries++;
        return new OXBridge();
    }

    public void addUD(UpOrDown upOrDown, boolean correctOrWrong) {
        String UD = upOrDown.getInputUD();
        String ox = OXBridgeUtils.makeOX(correctOrWrong);
        this.correctOrWrong = correctOrWrong;

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

    public boolean isCorrectOrWrong() {
        return correctOrWrong;
    }

    public int getTries() {
        return tries;
    }

    @Override
    public String toString() {
        return String.valueOf(upBridge) + downBridge;
    }
}
