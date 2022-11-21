package bridge;

import bridge.Model.BridgeGame;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        BridgeGame.bridge = makeBridge(BridgeGame.size); // 데이터베이스 역할을 하는 모델에 기록
    }

    public List<String> makeBridge(int size) {
        List<String> trueBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            trueBridge.add(addTile());
        }
        return trueBridge;
    }

    public String addTile() {
        if (bridgeNumberGenerator.generate() == 0) {
            return "D";
        }
        return "U";
    }
}
