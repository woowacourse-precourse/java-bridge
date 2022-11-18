package bridge;

import bridge.standard.GameForm;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator numberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.numberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int generatedSize = 0; generatedSize < size; generatedSize++) {
            bridge.add(setPosition(numberGenerator.generate()));
        }
        return bridge;
    }

    private String setPosition(int random) {
        if (random == GameForm.UP_LAYER) {
            return GameForm.UP_CODE;
        }
        if (random == GameForm.DOWN_LAYER) {
            return GameForm.DOWN_CODE;
        }
        throw new IllegalArgumentException(); //무슨 예외인지 확인
    }
}
