package bridge.Model;

import bridge.Util.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final String UPPER_CASE = "U";
    private static final String LOWER_CASE = "D";

    List<String> bridgeShape = new ArrayList<>();


    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        for(int i = 0; i < size; i++){
            bridgeShape.add(addShape());
        }
        return bridgeShape;
    }

    private String addShape() {
        if(bridgeNumberGenerator.generate() == 1)
            return UPPER_CASE;
        return LOWER_CASE;
    }

    public void resetBridge(){
        bridgeShape.clear();
    }
}
