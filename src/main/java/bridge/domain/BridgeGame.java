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
        movingRecord = new ArrayList<>();
        this.bridgeInfo = bridgeInfo;
        stageCount = 0;
        gameStatus = GameStatusType.PLAYING;
    }

    public void move(String moving) {
        movingRecord.add(moving);
        if (!isPassed(stageCount, moving)) {
            fail();
        }
    }

    public void retry() {
        movingRecord.clear();
        stageCount = 0;
        gameStatus = GameStatusType.PLAYING;
    }

    public void quit() {
        gameStatus = GameStatusType.FAIL;
    }

    public void end() {
        gameStatus = GameStatusType.END;
    }

    public boolean isPlaying() {
        return gameStatus == GameStatusType.PLAYING;
    }
    public boolean isEnd() {
        return stageCount == bridgeInfo.size() && gameStatus != GameStatusType.FAIL;
    }

    public boolean isFailed() {
        return gameStatus == GameStatusType.FAIL;
    }

    public boolean isPassed(int index, String moving) {
        return bridgeInfo.get(index).equals(moving);
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

    private void fail() {
        gameStatus = GameStatusType.FAIL;
    }
}
