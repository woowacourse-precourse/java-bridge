package bridge.domain;

import static bridge.constant.BridgeConstant.FAIL;
import static bridge.constant.BridgeConstant.PASS;

import bridge.type.MovingType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeMovingResult {

    private final List<List<String>> playingMap;
    private final List<String> bridgeInfo;

    public BridgeMovingResult(List<String> bridgeInfo) {
        this.bridgeInfo = bridgeInfo;
        playingMap = new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>()));
    }

    public void updatePlayingMap(List<String> movingRecord, int index) {
        updateSidePlayingMap(movingRecord, index);
        updateOtherSidePlayingMap(movingRecord, index);
    }

    public List<List<String>> getPlayingMap() {
        return playingMap;
    }

    public void initialize() {
        playingMap.get(0).clear();
        playingMap.get(1).clear();
    }

    private void updateSidePlayingMap(List<String> movingRecord, int index) {
        playingMap.get(checkUpAndDown(movingRecord.get(index)).getValue())
                .add(checkPassOrFail(index, movingRecord.get(index)));
    }

    private void updateOtherSidePlayingMap(List<String> movingRecord, int index) {
        playingMap.get(1 - checkUpAndDown(movingRecord.get(index)).getValue())
                .add(" ");
    }

    private String checkPassOrFail(int index, String moving) {
        if (bridgeInfo.get(index).equals(moving)) {
            return PASS;
        }
        return FAIL;
    }

    private MovingType checkUpAndDown(String moving) {
        return MovingType.createMoving(moving);
    }
}
