package bridge.domain;

import bridge.constant.BridgeDirection;
import bridge.constant.CrossingState;
import bridge.constant.GameRecord;

import java.util.List;

public class GameRecordGenerator {

    public List<String> generate(boolean crossedBridgeState, BridgeDirection currentDirection){
        String result = CrossingState.transform(crossedBridgeState);
        GameRecord gameRecord = GameRecord.findLocation(currentDirection);
        return gameRecord.generate(result);
    }

}
