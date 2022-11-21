package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker() {
        this.bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> newBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            isUp(newBridge, randomNumber);
            isDown(newBridge, randomNumber);
        }
        return newBridge;
    }

    private void isUp(List<String> newBridge, int randomNumber){
        if (randomNumber == 1) {
            newBridge.add("U");
        }
    }

    private void isDown(List<String> newBridge, int randomNumber){
        if (randomNumber == 0) {
            newBridge.add("D");
        }
    }
}
