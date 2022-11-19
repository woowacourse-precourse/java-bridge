package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersBridgeCrossStatus {
    private List<List<String>> currentBridge;
    private final int size;
    private static final int FIRST_BRIDGE = 1;
    private static final int INITIAL_BRIDGE_SIZE = 2;
    private static final String BLANK = " ";
    private static final String DELIMITER = "|";

    public UsersBridgeCrossStatus(List<List<String>> currentBridge, int size) {
        this.currentBridge = currentBridge;
        this.size = size;
    }

    public void addCrossingResult(Space selectedSpace, int currBridgeOrder, String movingResult) {
        if (currBridgeOrder != FIRST_BRIDGE) {
            int spaceIdx = selectedSpace.getIndex();
            addDelimiter(currentBridge.get(spaceIdx).size());
        } // 현재 이동하고 있는 다리가 첫 번째 다리가 아니라면 앞에 구분자 "|"를 추가해서 이전의 이동 결과와 구분함.
        List<String> toBeAddedInSelectedSpace = getCharsNeededToAdd(true, movingResult);
        List<String> toBeAddedInOtherSpace = getCharsNeededToAdd(false, null);

        updateCurrentBridge(selectedSpace.getIndex(), toBeAddedInSelectedSpace, toBeAddedInOtherSpace);
    }

    private List<String> getCharsNeededToAdd(boolean isSelected, String movingResult) {
        List<String> charsNeededToAdd = new ArrayList<>();
        if (isSelected) {
            charsNeededToAdd.addAll(new ArrayList<>(Arrays.asList(BLANK, movingResult, BLANK)));
            return charsNeededToAdd;
        }
        charsNeededToAdd.addAll(new ArrayList<>(Arrays.asList(BLANK, BLANK, BLANK)));
        return charsNeededToAdd;
    }

    private void addDelimiter(int size) {
        currentBridge.get(Space.UP.getIndex()).add(size - 1, DELIMITER);
        currentBridge.get(Space.DOWN.getIndex()).add(size - 1, DELIMITER);
    }

    private void updateCurrentBridge(int selectedIdx, List<String> forSelected, List<String> forNotSelected) {
        int currBridgeSize = currentBridge.get(selectedIdx).size();
        int addPoint = -1;
        if (currBridgeSize == INITIAL_BRIDGE_SIZE) {
            addPoint = 1;
        } else if (currBridgeSize > INITIAL_BRIDGE_SIZE) {
            addPoint = currBridgeSize - 1;
        }
        currentBridge.get(selectedIdx).addAll(addPoint, forSelected);
        currentBridge.get(Space.getOtherSpaceIndex(selectedIdx)).addAll(addPoint, forNotSelected);
    }

    public List<List<String>> getCurrentBridge() {
        return currentBridge;
    }

    public int getSize() {
        return size;
    }

    public void resetCurrentBridge() {
        this.currentBridge.clear();
        currentBridge = BridgeMakerImpl.setHeadAndTail();
    }
}
