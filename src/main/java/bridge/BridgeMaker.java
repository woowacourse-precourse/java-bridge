package bridge;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    static final int UP_NUMBER = 1;
    static final int DOWN_NUMBER = 0;
    static final String UP = "U";
    static final String DOWN = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        sizeValidation(size);
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int generateRandomBridge = bridgeNumberGenerator.generate();
            if (generateRandomBridge == UP_NUMBER) {
                bridge.add(UP);
            }
            if (generateRandomBridge == DOWN_NUMBER) {
                bridge.add(DOWN);
            }
        }
        return bridge;
    }

    /**
     * 입력받은 다리 길이가 문제의 조건에 유효한지 검사
     *
     * @param size 다리의 크기를 의미하는 size는 반드시 3이상 20 이하의 숫자로 이루어져 있어야한다.
     */
    private void sizeValidation(int size) {
        if (size < 3 || 20 < size) {
            throw new IllegalArgumentException("다리의 크기는 3이상, 20 이하의 숫자만를 입력할 수 있습니다.");
        }
    }
}
