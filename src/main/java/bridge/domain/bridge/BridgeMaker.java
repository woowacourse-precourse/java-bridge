package bridge.domain.bridge;

import bridge.domain.game.MovingType;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> lst = new ArrayList<>();
        for (int lstIdx = 0; lstIdx < size; lstIdx++) {
            String stepType =
                    getEngNotationByRandomNumber(bridgeNumberGenerator.generate());
            lst.add(stepType);
        }
        return lst;
    }

    private String getEngNotationByRandomNumber(int randomNumber) {
        MovingType bridgeType = MovingType.getMovingTypeByNumNotation(randomNumber);
        return bridgeType.getEngNotation();
    }

}
