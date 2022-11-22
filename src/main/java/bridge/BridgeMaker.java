package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.BridgeGame.LOWER_SELECT;
import static bridge.BridgeGame.UPPER_SELECT;
import static bridge.BridgeRandomNumberGenerator.RANDOM_LOWER_INCLUSIVE;
import static bridge.BridgeRandomNumberGenerator.RANDOM_UPPER_INCLUSIVE;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    public static final int REPEAT_INITIAL_VALUE = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridgeRoad = new ArrayList<>();
        for (int i = REPEAT_INITIAL_VALUE; i < size; i++) {
            int road = bridgeNumberGenerator.generate();
            if (road == RANDOM_UPPER_INCLUSIVE)
                bridgeRoad.add(UPPER_SELECT);
            if (road == RANDOM_LOWER_INCLUSIVE)
                bridgeRoad.add(LOWER_SELECT);
        }
        return bridgeRoad;
    }

}
