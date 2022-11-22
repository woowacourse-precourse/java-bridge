package bridge.domain.model;

import bridge.domain.constant.BridgeDirection;
import bridge.domain.constant.CrossingState;
import bridge.domain.constant.GameRecord;

import java.util.List;

public class GameRecordGenerator {

    public List<String> generate(boolean crossedBridgeState, BridgeDirection currentDirection) {
        String result = CrossingState.transform(crossedBridgeState);
        GameRecord gameRecord = GameRecord.findLocation(currentDirection);
        return gameRecord.generate(result);
    }

}
