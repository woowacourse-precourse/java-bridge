package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        //0과 1을 각각 D, U로 바꿔 리스트에 저장하고 반환해주는 작업
        List<Integer> bridgeUsable = BridgeUsableList(size);
        List<String> bridge = new ArrayList<>();
        for (int usable: bridgeUsable) {
            if (usable==0) {
                bridge.add("D");
            }
            if (usable==1) {
                bridge.add("U");
            }
        }
        return bridge;
    }

    public List<Integer> BridgeUsableList(int size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        List<Integer> bridgeUsable = new ArrayList<>();
        for (int i=0; i<size; i++) {
            bridgeUsable.add(bridgeRandomNumberGenerator.generate());
        }
        return bridgeUsable;
    }
}
