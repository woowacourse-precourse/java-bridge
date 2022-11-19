package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> currentGameBridge;
    private int currentGameIndex;
    private List<String> currentGameResults;
    private boolean gamePassFlag;
    private int gameTryCount;

    public BridgeGame(List<String> currentGameBridge) {
        this.currentGameBridge = currentGameBridge;
        this.currentGameResults = new ArrayList<>();
        this.currentGameIndex = 0;
        this.gamePassFlag = false;
        this.gameTryCount = 1;
    }

    public int getGameTryCount() {
        return gameTryCount;
    }

    public void plusGameTryCount() {
        this.gameTryCount++;
    }

    public List<String> getCurrentGameResults() {
        return currentGameResults;
    }

    public String printGamePassStateByKorean() {
        if (isGamePassFlag()) {
            return "성공";
        }
        return "실패";
    }

    public void clearGameResults() {
        this.currentGameResults = new ArrayList<>();
        currentGameIndex = 0;
    }

    public boolean isSuccessGame() {
        return currentGameIndex >= currentGameBridge.size();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String userMoving) {
        currentGameResults.add(userMoving);
        String curBridgeField = currentGameBridge.get(currentGameIndex);

        if (userMoving.equals(curBridgeField)) {
            currentGameIndex++;
            return "O";
        }

        currentGameResults.set(currentGameIndex, "X");
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        clearGameResults();
        plusGameTryCount();
    }

    public boolean isGamePassFlag() {
        return gamePassFlag;
    }

    public void setGamePassFlag(boolean gamePassFlag) {
        this.gamePassFlag = gamePassFlag;
    }
}
