package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Constant.*;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final List<String> bridgeShape = new ArrayList<>();

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param  size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        for(int i = 0; i < size; i++){
            bridgeShape.add(getRandomShape());
        }
        return bridgeShape;
    }

    private String getRandomShape() {
        if(bridgeNumberGenerator.generate() == 1)
            return MOVE_TO_UPPER;
        return MOVE_TO_LOWER;
    }

    public void clearBridge(){
        bridgeShape.clear();
    }
}
