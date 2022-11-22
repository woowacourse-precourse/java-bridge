package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    public enum judgeBridge {
        UP("U", 0),
        DOWN("D", 1);
        private final String name;
        private final int value;
        judgeBridge(String name, int value) {
            this.name = name;
            this.value = value;
        }
        public String getName() {
            return name;
        }
    }


    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> makeBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int move = bridgeNumberGenerator.generate();
            if (move == 1) {
                makeBridge.add(judgeBridge.UP.getName());
            }
            if (move == 0) {
                makeBridge.add(judgeBridge.DOWN.getName());
            }
        }
        return makeBridge;
    }
}
