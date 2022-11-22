package bridge.domain;

import static bridge.utils.Constant.POOR_CONSTRUCTION;
import static bridge.utils.Constant.POOR_CONSTRUCTION_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge() {
        this.bridge = new ArrayList<>();
    }

    public void createBridge(List<String> makeBridge) {
        checkPoorConstruction(makeBridge);
        this.bridge.addAll(makeBridge);
    }

    private void checkPoorConstruction(List<String> bridge) {
        for (String position : bridge) {
            validPosition(position);
        }
    }

    private void validPosition(String position) {
        if (position.equals(POOR_CONSTRUCTION)) {
            throw new IllegalArgumentException(POOR_CONSTRUCTION_MESSAGE);
        }
    }

    public boolean isCorrectLastPosition(int lastIndex, String nextMove) {
        return bridge.get(lastIndex).equals(nextMove);
    }

    public int size() {
        return bridge.size();
    }
}
