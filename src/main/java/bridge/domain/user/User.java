package bridge.domain.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bridge.domain.utils.Space.*;

public class User {
    private List<List<String>> currentBridge;
    private final int bridgeSize;
    private boolean isSucceeded;
    private int theNumOfTrials;
    private static final String BLANK = CurrentBridgeElement.BLANK.getElement();
    private static final String DELIMITER = CurrentBridgeElement.DELIMITER.getElement();
    private static final int FIRST_BRIDGE = 1;
    private static final int INITIAL_BRIDGE_SIZE = 2;

    public User(List<List<String>> currentBridge, int bridgeSize) {
        this.currentBridge = currentBridge;
        this.bridgeSize = bridgeSize;
        this.isSucceeded = false; // 다리를 끝까지 건너서 게임을 성공하면 true로 변경.
        this.theNumOfTrials = 1;
    }

    public void addCrossingResult(int selectedSpaceIdx, int currBridgeOrder, String movingResult) {
        if (currBridgeOrder != FIRST_BRIDGE) {
            addDelimiter(currentBridge.get(selectedSpaceIdx).size());
        } // 현재 이동하고 있는 다리가 첫 번째 다리가 아니라면 앞에 구분자 "|"를 추가해서 이전의 이동 결과와 구분함.
        List<String> toBeAddedInSelectedSpace = getCharsNeededToAdd(true, movingResult);
        List<String> toBeAddedInOtherSpace = getCharsNeededToAdd(false, null);

        updateCurrentBridge(selectedSpaceIdx, toBeAddedInSelectedSpace, toBeAddedInOtherSpace);
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

    private void addDelimiter(int currentSize) {
        currentBridge.get(UP.getIndex()).add(currentSize - 1, DELIMITER);
        currentBridge.get(DOWN.getIndex()).add(currentSize - 1, DELIMITER);
    }

    private void updateCurrentBridge(int selectedIdx, List<String> forSelected, List<String> forNotSelected) {
        int addPoint = getAddPoint(selectedIdx); // 라운드별 이동 결과를 추가할 위치(인덱스 값) 반환.

        currentBridge.get(selectedIdx).addAll(addPoint, forSelected);
        currentBridge.get(getOtherSpaceIndex(selectedIdx)).addAll(addPoint, forNotSelected);
    }

    private int getAddPoint(int selectedIdx) {
        int currentSize = currentBridge.get(selectedIdx).size();

        if (currentSize == INITIAL_BRIDGE_SIZE) {
            return 1;
        }
        return currentSize - 1;
    }

    // 게임을 재시도하기 전 currentBridge를 비움.
    public void resetCurrentBridge() {
        this.currentBridge.clear();

        // 처음과 끝에 "["와 "]" 추가.
        currentBridge = UserMaker.makeUsersCurrentBridge();
    }

    // 실패 후 재시도할 때마다 시도 횟수 증가
    public void increaseTrialCount() {
        this.theNumOfTrials++;
    }

    public List<List<String>> getCurrentBridge() {
        return currentBridge;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
    public int getTheNumOfTrials() {
        return theNumOfTrials;
    }

    public boolean getSucceeded() {
        return isSucceeded;
    }

    public void setSucceeded() {
        this.isSucceeded = true;
    }
}
