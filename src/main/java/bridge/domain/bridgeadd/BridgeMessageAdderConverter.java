package bridge.domain.bridgeadd;

import static bridge.Constants.DOWN_BRIDGE;
import static bridge.Constants.FAIL_MESSAGE;
import static bridge.Constants.PASS_MESSAGE;
import static bridge.Constants.UP_BRIDGE;

import java.util.HashMap;
import java.util.Map;

public class BridgeMessageAdderConverter {
    static protected Map<String, BridgeMessageAddStrategy> bridgeAddStrategyConverter;
    static protected Map<Boolean, String> saveMessageConverter;

    static protected void setConverter() {
        setSaveMessageConverter();
        setListAdderConverter();
    }

    static protected void setListAdderConverter() {
        bridgeAddStrategyConverter = new HashMap<>();
        bridgeAddStrategyConverter.put(UP_BRIDGE, new UpBridgeMessageAddStrategy());
        bridgeAddStrategyConverter.put(DOWN_BRIDGE, new DownBridgeMessageAddStrategy());
    }

    static protected void setSaveMessageConverter() {
        saveMessageConverter = new HashMap<>();
        saveMessageConverter.put(true, PASS_MESSAGE);
        saveMessageConverter.put(false, FAIL_MESSAGE);
    }

}
