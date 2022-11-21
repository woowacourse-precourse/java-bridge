package bridge.domain.bridgebuilder;

import bridge.domain.resources.ReOrQuit;
import java.util.List;

public class BridgeGameUtils {

    public static boolean isEquals(String inputUD, List<String> bridgeUD, int oxBridgeSize) {
        return inputUD.equals(bridgeUD.get(oxBridgeSize));
    }

    public static boolean retry(String inputRQ) {
        return inputRQ.equals(ReOrQuit.RE_GAME);
    }
}
