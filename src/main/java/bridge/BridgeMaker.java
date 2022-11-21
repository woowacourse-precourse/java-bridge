package bridge;

import bridge.domain.constants.Constant;

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
        validateSize(size);
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++){
            bridge.add(generateBlock());
        }
        return bridge;
    }

    private void validateSize(int size){
        if (size < Constant.MINIMUM_LENGTH_INCLUSIVE.getValue() || size > Constant.MAXIMUM_LENGTH_INCLUSIVE.getValue()) throw new IllegalArgumentException();
    }

    private String generateBlock(){
        if (bridgeNumberGenerator.generate() == 0) return "D";
        return "U";
    }

}
