package bridge;

import java.util.List;

public class UsersBridgeCrossStatus {
    private final List<List<String>> currentBridge;
    private final int length;
    private static final String BLANK = " ";
    private static final String DELIMITER = "|";

    public UsersBridgeCrossStatus(List<List<String>> currentBridge, int length) {
        this.currentBridge = currentBridge;
        this.length = length;
    }

    public void addCrossingResult(Space selectedSpace, int currBridgeOrder, String movingResult) {
        if (currBridgeOrder != FIRST_BRIDGE) {
            int spaceIdx = selectedSpace.getIndex();
            addDelimiter(currentBridge.get(spaceIdx).size());
        }

        addResultsForEachSpace(true, selectedSpace, movingResult);
        Space otherSpace = Space.getOtherSpace(selectedSpace);
        addResultsForEachSpace(false, otherSpace, movingResult);
    }


    private void addResultsForEachSpace(boolean isSelected, Space objectSpace, String movingResult) {
        int objectSpaceIndex = objectSpace.getIndex();
        int objectSpaceSize = currentBridge.get(objectSpaceIndex).size();

        // objectSpaceSize - 2 : 다리의 끝인 "]"가 저장된 인덱스의 직전 인덱스 값.
        if (isSelected) {
            currentBridge.get(objectSpaceIndex).addAll(objectSpaceSize - 2, List.of(BLANK, movingResult, BLANK));
            return;
        }
        currentBridge.get(objectSpaceSize).addAll(objectSpaceSize - 2, List.of(BLANK, BLANK, BLANK));
    }

    private void addDelimiter(int size) {
        currentBridge.get(Space.UP.getIndex()).add(size - 2, DELIMITER);
        currentBridge.get(Space.DOWN.getIndex()).add(size - 2, DELIMITER);
    }

    public List<List<String>> getCurrentBridge() {
        return currentBridge;
    }

    public int getLength() {
        return length;
    }
}
