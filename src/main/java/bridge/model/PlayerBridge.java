package bridge.model;

import bridge.enums.BridgeShape;

import java.util.ArrayList;
import java.util.List;

public class PlayerBridge {

    private static final String UP_STEP = "U";
    private static final String DOWN_STEP = "D";
    private static final String BLANK_SHAPE = "   ";

    private final List<String> upShape = new ArrayList<>();
    private final List<String> downShape = new ArrayList<>();

    public void moveNextStep(String inputNextStep, boolean canMove) {
        if (inputNextStep.equals(UP_STEP)) {
            moveUpStep(canMove);
        }
        if (inputNextStep.equals(DOWN_STEP)) {
            moveDownStep(canMove);
        }
    }

    private void moveUpStep(boolean canMove) {
        upShape.add(BridgeShape.getNextShape(canMove));
        downShape.add(BLANK_SHAPE);
    }

    private void moveDownStep(boolean canMove) {
        downShape.add(BridgeShape.getNextShape(canMove));
        upShape.add(BLANK_SHAPE);
    }

    public void initializeShape() {
        upShape.clear();
        downShape.clear();
    }

    public List<String> getUpShape() {
        return upShape;
    }

    public List<String> getDownShape() {
        return downShape;
    }
}
