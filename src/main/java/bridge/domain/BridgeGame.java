package bridge.domain;

import bridge.type.GameStatusType;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private final List<String> movingRecord;
    private final List<String> bridgeInfo;
    private int stageCount;
    private GameStatusType gameStatus;

    public BridgeGame(List<String> bridgeInfo) {
        this.movingRecord = new ArrayList<>();
        this.bridgeInfo = bridgeInfo;
        this.stageCount = 0;
        this.gameStatus = GameStatusType.PLAYING;
    }

    public void move(String moving) {
        movingRecord.add(moving);
        checkFail(stageCount, moving);
    }

    public void retry() {
        movingRecord.clear();
        stageCount = 0;
        this.gameStatus = GameStatusType.PLAYING;
    }

    public void end() {
        this.gameStatus = GameStatusType.END;
    }

    public void quit() {
        this.gameStatus = GameStatusType.FAIL;
    }

    public void increaseStageCount() {
        stageCount++;
    }

    public List<String> getMovingRecord() {
        return movingRecord;
    }

    public int getStageCount() {
        return stageCount;
    }

    public GameStatusType getGameStatus() {
        return gameStatus;
    }

    public void checkClear() {
        if (stageCount == bridgeInfo.size() && gameStatus != GameStatusType.FAIL) {
            end();
        }
    }

    private void checkFail(int index, String moving) {
        if (!bridgeInfo.get(index).equals(moving)) {
            gameStatus = GameStatusType.FAIL;
        }
    }
}
