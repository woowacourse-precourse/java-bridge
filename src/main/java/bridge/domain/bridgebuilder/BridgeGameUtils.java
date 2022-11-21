package bridge.domain.bridgebuilder;

import bridge.domain.oxbridgebuilder.OXBridge;
import bridge.domain.resources.UpOrDown;
import java.util.List;

public class BridgeGameUtils {

    public static boolean isEquals(String inputUD, List<String> bridgeUD, int oxBridgeSize) {
        return inputUD.equals(bridgeUD.get(oxBridgeSize));
    }

    public static void addUDToUserBridge(OXBridge oxBridge, UpOrDown upOrDown, boolean isInputCorrect) {
        oxBridge.addUD(upOrDown, isInputCorrect);
    }
}
