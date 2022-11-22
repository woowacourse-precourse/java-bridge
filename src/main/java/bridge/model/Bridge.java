package bridge.model;

import java.util.List;

public class Bridge {

    private final List<String> upBridge;
    private final List<String> downBridge;

    public Bridge(final List<String> upBridge, final List<String> downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
    }

    public void moveUpBridgeCorrect() {
        upBridge.add("O");
        moveNothing(downBridge);
    }

    public void moveDownBridgeCorrect() {
        moveNothing(upBridge);
        downBridge.add("O");
    }

    public void moveUpBridgeInCorrect() {
        upBridge.add("X");
        moveNothing(downBridge);
    }

    public void moveDownBridgeInCorrect() {
        moveNothing(upBridge);
        downBridge.add("X");
    }

    private void moveNothing(final List<String> bridge) {
        bridge.add(" ");
    }

    private StringBuilder prettyPrint(final List<String> bridge) {
        StringBuilder stringBuilder = new StringBuilder("[ ");

        stringBuilder.append(String.join(" | ", bridge));

        stringBuilder.append(" ]");

        return stringBuilder;
    }

    @Override
    public String toString() {
        return prettyPrint(upBridge).append("\n")
                                    .append(prettyPrint(downBridge))
                                    .toString();
    }
}
