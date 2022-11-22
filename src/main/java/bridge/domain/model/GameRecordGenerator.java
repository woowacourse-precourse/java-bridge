package bridge.domain.model;

import bridge.domain.constant.BridgeDirection;
import bridge.domain.constant.CrossedState;
import bridge.domain.constant.GameRecord;
import bridge.domain.constant.GameRecordFormat;

import java.util.List;
import java.util.ListIterator;

public class GameRecordGenerator {
    private final int FIRST_TRIAL = 1;
    private List<String> currentGameRecord;
    public void generate(boolean crossedBridgeState, BridgeDirection currentDirection) {
        String result = CrossedState.transform(crossedBridgeState);
        GameRecord gameRecord = GameRecord.findLocation(currentDirection);
        currentGameRecord = gameRecord.generate(result);
    }

    private boolean isFirstTrial(int trial) {
        return trial == FIRST_TRIAL;
    }

    private String makeFormat(boolean isFirst, String record) {
        GameRecordFormat gameRecordFormat = GameRecordFormat.findByTrial(isFirst);
        return gameRecordFormat.generate(record);
    }

    public void updateCurrentRecord(int trial) {
        boolean isFirst = isFirstTrial(trial);
        ListIterator<String> currentResult = currentGameRecord.listIterator();

        while (currentResult.hasNext()) {
            int currentIndex = currentResult.nextIndex();
            currentGameRecord.set(currentIndex, makeFormat(isFirst, currentResult.next()));
        }
    }

    public List<String> getCurrentGameRecord(){
        return currentGameRecord;
    }

}
