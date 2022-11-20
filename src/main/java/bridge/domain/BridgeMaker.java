package bridge.domain;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    public static final String UP = "U";
    public static final String DOWN = "D";
    public static final int UP_NUMBER = 1;
    public static final int DOWN_NUMBER = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(convertNumberToDirection(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    public String convertNumberToDirection(int generatedNum) {
        if (generatedNum == DOWN_NUMBER) {
            return DOWN;
        }
        if (generatedNum == UP_NUMBER) {
            return UP;
        }
        throw new IllegalArgumentException("[ERROR] 랜덤으로 생성된 숫자에 오류가 있습니다.");
    }
}
