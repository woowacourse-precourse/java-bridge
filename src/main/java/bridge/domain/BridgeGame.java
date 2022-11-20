package bridge.domain;

import static bridge.view.InputView.readMoving;

import bridge.type.GameStatusType;
import bridge.type.MovingType;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void move() {
        String moving = readMoving();
        movingRecord.add(moving);
        stageCount++;
        isEnd();
    }

    public void retry() {
        movingRecord.clear();
        stageCount = 0;
        this.gameStatus = GameStatusType.PLAYING;
    }

    public void isEnd() {
        if (stageCount == bridgeInfo.size()) {
            gameStatus = GameStatusType.END;
        }
    }

    public List<List<String>> printPlayingMap() {
        List<String> upBridge = new ArrayList<>();
        List<String> downBridge = new ArrayList<>();
        List<List<String>> playingMap = new ArrayList<>(Arrays.asList(downBridge, upBridge));

        for (int index = 0; index < movingRecord.size(); index++) {
            playingMap.get(checkUpAndDown(movingRecord.get(index)).getValue())
                    .add(checkYesOrNo(index, movingRecord.get(index)));
            playingMap.get(1 - checkUpAndDown(movingRecord.get(index)).getValue())
                    .add(" ");
        }
        return playingMap;
    }

    public GameStatusType getGameStatus() {
        return gameStatus;
    }

    private String checkYesOrNo(int index, String moving) {
        if (bridgeInfo.get(index).equals(moving)) {
            return "O";
        }
        gameStatus = GameStatusType.FAIL;
        return "X";
    }

    private MovingType checkUpAndDown(String moving) {
        return MovingType.createMoving(moving);
    }
}
