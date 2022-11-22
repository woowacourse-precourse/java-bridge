package bridge;

import bridge.Enum.PlayerInput;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            String upDown = convertToEnum(bridgeNumberGenerator.generate());
            bridge.add(upDown);
        }
        return bridge;
    }

    private String convertToEnum(int num){
        if(num == 0) return String.valueOf(PlayerInput.DOWN);
        return String.valueOf(PlayerInput.UP);
    }
}
