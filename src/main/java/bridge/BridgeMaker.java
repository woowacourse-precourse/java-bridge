package bridge;

import bridge.game.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        checkBridgeSize(size);

        List<String> bridge = fillBridge(size);

        return bridge;
    }

    /**
     * @param size 다리의 길이
     * @return 값을 채운 다리를 반환
     */
    private List<String> fillBridge(int size) {
        String[] state = {"D", "U"};
        List<String> bridge = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Integer randomNumber = bridgeNumberGenerator.generate();
            bridge.add(state[randomNumber]);
        }

        return bridge;
    }

    /**
     * @param size 다리의 길이
     * @return 다리의 길이가 범위를 벗어나면 예외를 발생한다.
     */
    private void checkBridgeSize(int size) {
        if (size > 20 || size < 3) {
            throw new IllegalArgumentException("다리의 길이는 3~20 이내여야 합니다.");
        }
    }
}
