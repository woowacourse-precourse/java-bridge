package bridge;

import static bridge.constant.Direction.LOWER;
import static bridge.constant.Direction.UPPER;

import bridge.constant.Direction;
import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private static final String EMPTY_ELEMENT = " ";
    private static final String RIGHT_ELEMENT = "O";
    private static final String WRONG_ELEMENT = "X";
    private final Bridge upperBridge = new Bridge(new ArrayList<>());
    private final Bridge lowerBridge = new Bridge(new ArrayList<>());

    public void add(String upperOrLower, boolean moveState) {
        Direction direction = Direction.getDirection(upperOrLower);
        if (direction.equals(UPPER)) {
            addToLowerBridge(EMPTY_ELEMENT);
            addToUpperBridge(getElement(moveState));
        }
        if (direction.equals(LOWER)) {
            addToUpperBridge(EMPTY_ELEMENT);
            addToLowerBridge(getElement(moveState));
        }
    }

    private String getElement(boolean moveStatus) {
        if (moveStatus) {
            return RIGHT_ELEMENT;
        }
        return WRONG_ELEMENT;
    }

    private void addToUpperBridge(String result) {
        upperBridge.add(result);
    }

    private void addToLowerBridge(String result) {
        lowerBridge.add(result);
    }

    public int getGameCount() {
        return upperBridge.getSize();
    }

    public List<String> getUpperBridge() {
        return upperBridge.getBridge();
    }

    public List<String> getLowerBridge() {
        return lowerBridge.getBridge();
    }
}
