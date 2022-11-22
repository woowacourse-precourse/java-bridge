package bridge.domain.bridgemessageadd;

import static bridge.Constants.DOWN_BRIDGE;
import static bridge.Constants.UP_BRIDGE;

import java.util.HashMap;
import java.util.Map;

public class BridgeMessageAdderConverter {
    static protected Map<String, BridgeMessageAddStrategy> bridgeAddStrategyConverter;

    static protected void setConverter() {
        bridgeAddStrategyConverter = new HashMap<>();
        bridgeAddStrategyConverter.put(UP_BRIDGE, new UpBridgeMessageAddStrategy());
        bridgeAddStrategyConverter.put(DOWN_BRIDGE, new DownBridgeMessageAddStrategy());
    }

}
