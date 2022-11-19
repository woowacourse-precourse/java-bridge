package bridge;

import bridge.constant.BridgeConstant;

import java.util.LinkedList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridgeInformation = new LinkedList<>();
        for(int i=0; i<size; i++){
            if(bridgeNumberGenerator.generate() == BridgeConstant.CAN_GO_UP.getInt()){
                bridgeInformation.add(BridgeConstant.CAN_GO_UP.getString());
            }
            if(bridgeNumberGenerator.generate() == BridgeConstant.CANT_GO_UP.getInt()){
                bridgeInformation.add(BridgeConstant.CANT_GO_UP.getString());
            }
        }
        return bridgeInformation;
    }
}
