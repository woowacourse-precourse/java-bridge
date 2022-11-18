package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.model.Direction;
import bridge.model.ErrorMessage;
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
        return null;
    }

    public int getSizeInteger(String size){
        try{
            return Integer.parseInt(size);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_VALUE.getOutput());
        }

    }

    private void isValidRange(int size){
        if(size < 3 || size > 20){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_VALUE.getOutput());
        }
    }


}
