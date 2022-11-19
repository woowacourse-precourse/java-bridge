package bridge;

import bridge.standard.GameForm;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator numberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.numberGenerator = bridgeNumberGenerator;
    }

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
