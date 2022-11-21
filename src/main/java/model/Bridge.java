package model;

import static bridge.enums.BridgeElement.BRIDGE_EMPTY_ELEMENT;
import static bridge.enums.BridgeElement.BRIDGE_ENDING_ELEMENT;
import static bridge.enums.BridgeElement.BRIDGE_SEPARATOR_ELEMENT;
import static bridge.enums.BridgeElement.BRIDGE_STARTING_ELEMENT;

import bridge.enums.BridgeElement;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int size() {
        return bridge.size();
    }

    public String get(int index) {
        return bridge.get(index);
    }

    public void add(BridgeElement bridgeElement) {
        bridge.add(bridgeElement.toString());
    }

    public boolean notContains(String element) {
        return !bridge.contains(element);
    }

    public void clear() {
        bridge.clear();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BRIDGE_STARTING_ELEMENT);
        bridgeDirectionToElement(stringBuilder);
        stringBuilder.append(BRIDGE_ENDING_ELEMENT);
        return String.valueOf(stringBuilder);
    }

    private void bridgeDirectionToElement(StringBuilder stringBuilder) {
        bridge.forEach(element -> stringBuilder.append(BRIDGE_EMPTY_ELEMENT)
                .append(element)
                .append(BRIDGE_EMPTY_ELEMENT)
                .append(BRIDGE_SEPARATOR_ELEMENT));
        int index = stringBuilder.lastIndexOf(BRIDGE_SEPARATOR_ELEMENT.toString());
        stringBuilder.deleteCharAt(index);
    }
}
