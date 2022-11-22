package bridge.domain.bridgebuilder;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.oxbridgebuilder.OXBridge;
import bridge.domain.resources.Bridge;
import bridge.domain.resources.ReOrQuit;
import bridge.domain.resources.UpOrDown;
import java.util.List;

public class BridgeGame {

    public static List<String> buildAnswerBridge(int input) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(input);
    }

    public static void move(Bridge answerBridge, OXBridge oxBridge, UpOrDown upOrDown) {
        addUDToOXBridge(oxBridge, upOrDown,
            isEquals(upOrDown.getInputUD(), answerBridge.getBridge(), oxBridge.sizeOfOXBridge()));
    }

    public static boolean isEquals(String inputUD, List<String> bridgeUD, int oxBridgeSize) {
        return inputUD.equals(bridgeUD.get(oxBridgeSize));
    }

    public static void addUDToOXBridge(OXBridge oxBridge, UpOrDown upOrDown, boolean isInputCorrect) {
        oxBridge.addUD(upOrDown, isInputCorrect);
    }

    public static boolean retry(String inputRQ) {
        return inputRQ.equals(ReOrQuit.RE_GAME);
    }
}
