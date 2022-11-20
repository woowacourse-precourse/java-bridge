package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * Controller라고 할 수 있다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        Model.bridge=makeBridge(Model.size); // 데이터베이스 역할을 하는 모델에 기록
    }
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
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
