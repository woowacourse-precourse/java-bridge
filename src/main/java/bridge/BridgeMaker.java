package bridge;

import bridge.domain.game.BridgeGame;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int UP_DIRECTION_NUM = 1;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> result = new ArrayList<>();
        for (int i=0; i<size; i++) {
            result.add(getDirection());
        }
        return result;
    }

    private String getDirection() {
        if (UP_DIRECTION_NUM == bridgeNumberGenerator.generate())
            return BridgeGame.UP_DIRECTION;
        return BridgeGame.DOWN_DIRECTION;
    }
}
