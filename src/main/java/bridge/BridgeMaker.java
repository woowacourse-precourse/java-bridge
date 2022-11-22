package bridge;

import bridge.domain.constants.BlockSymbol;
import bridge.domain.constants.Constant;
import bridge.domain.constants.ErrorMessage;

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

    /**
     *
     * @param size 다리의 길이
     * @exception IllegalArgumentException 입력된 다리의 길이가 범위를 넘을 경우 예외 처리한다.
     */

    private void validateSize(int size){
        if (size < Constant.MINIMUM_LENGTH_INCLUSIVE.getValue() || size > Constant.MAXIMUM_LENGTH_INCLUSIVE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_OUT_OF_RANGE.getMessage());
        }
    }

    /**
     *
     * @return 숫자 생성기의 값이 0일 경우 "D", 그렇지 않을 경우 "U"를 반환한다.
     */
    private String generateBlock(){
        if (bridgeNumberGenerator.generate() == 0) return BlockSymbol.DOWN.getSymbol();
        return BlockSymbol.UP.getSymbol();
    }

}
