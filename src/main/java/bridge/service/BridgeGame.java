package bridge.service;

import static bridge.view.InputView.readMoving;

import bridge.type.MovingType;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BridgeGame {
    private final List<String> movingRecord;
    private final List<String> bridgeInfo;
    private int stageCount;

    public BridgeGame(List<String> bridgeInfo) {
        this.movingRecord = new ArrayList<>();
        this.bridgeInfo=  bridgeInfo;
        this.stageCount = 0;
    }

    public void move() {
        String moving = readMoving();
        movingRecord.add(moving);
        OutputView.printMap(printPlayingMap());
        stageCount++;
    }

    private List<List<String>> printPlayingMap() {
       List<String> upBridge = new ArrayList<>();
       List<String> downBridge = new ArrayList<>();
       List<List<String>> playingMap = new ArrayList<>(Arrays.asList(downBridge, upBridge));

       for(int index=0; index<movingRecord.size(); index++) {
           playingMap.get(checkUpAndDown(movingRecord.get(index)).getValue())
                   .add(checkYesOrNo(index, movingRecord.get(index)));
           playingMap.get(1-checkUpAndDown(movingRecord.get(index)).getValue())
                   .add(" ");
       }
       return playingMap;
    }
    private String checkYesOrNo(int index, String moving) {
        if(bridgeInfo.get(index).equals(moving)) {
            return "O";
        }
        return "X";
    }

    private MovingType checkUpAndDown(String moving) {
        return MovingType.createMoving(moving);
    }

    public int getStageCount() {
        return stageCount;
    }
    public void retry() {
        // TODO: 재시작 출력
    }

    public void exit() {
        // TODO: 게임 결과 출력
    }
}
