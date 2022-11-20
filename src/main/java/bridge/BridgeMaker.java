package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {


    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        for (int i = 0; i < size; i++) {
            int a = bridgeRandomNumberGenerator.generate();
            if (a == 0)
                BridgeGame.bridge_answer.add("U");
            if (a == 1)
                BridgeGame.bridge_answer.add("D");
        }
        return null;
    }







}
