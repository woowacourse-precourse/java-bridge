package bridge.domain;

import bridge.constant.GameStatus;

import java.util.List;

import static bridge.constant.GameStatus.*;

public class BridgeCalculator {
    private List<String> bridge;
    private int location;

    public BridgeCalculator(List<String> bridge){
        this.bridge = bridge;
        this.location = 0;
    }

    public GameStatus go(String moving){
        boolean isCorrectMoving = this.bridge.get(this.location).equals(moving);
        if(!isCorrectMoving){
            return FAIL;
        }
        this.location += 1;
        if(this.bridge.size() == location){
            return END;
        }
        return ON_WAY;
    }
}
