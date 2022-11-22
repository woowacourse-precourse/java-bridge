package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private List<String> Bridge = new ArrayList<>();
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> changeNumberToString(int size) {
        for (int i = 0; i < size; i++) {
            int mainBlock = bridgeNumberGenerator.generate();
            int secondBlock = changeOX(mainBlock);
            Bridge.add(String.valueOf(mainBlock));
            Bridge.add(String.valueOf(secondBlock));
        }
        return Bridge;
    }
    public List<String> makeBridge(int size){
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            if (number == 1) {
                bridge.add("U");
            }
            if (number == 0) {
                bridge.add("D");
            }
        }
        return bridge;
    }

    public int changeOX(int number){
        if (number == 1) return 0;
        return 1;
    }

    public List<String> getBridge() {
        return Bridge;
    }
}
