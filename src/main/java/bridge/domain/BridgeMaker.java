package bridge.domain;

import bridge.utils.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final String UP_BRIDGE = "U";
    private static final int BI_UP_BRIDGE = 1;
    private static final String DOWN_BRIDGE = "D";
    private static final int BI_DOWN_BRIDGE = 0;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for (int i=0; i<size; i++){
            int upDown = bridgeNumberGenerator.generate();
            bridge.add(isUpOrDown(upDown));
        }

        return bridge;
    }

    private String isUpOrDown(int upDown){
        String result = "";

        if (upDown == BI_UP_BRIDGE){
            result = UP_BRIDGE;
        }
        else if(upDown == BI_DOWN_BRIDGE){
            result = DOWN_BRIDGE;
        }

        return result;
    }
}
