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

    public static boolean move(Bridge answerBridge, OXBridge oxBridge, UpOrDown upOrDown) {
        boolean isInputCorrect = BridgeGameUtils.isEquals(
            upOrDown.getInputUD(), answerBridge.getBridge(), oxBridge.sizeOfOXBridge());
        BridgeGameUtils.addUDToUserBridge(oxBridge, upOrDown, isInputCorrect);
        return isInputCorrect;
    }

    public static boolean retry(String inputRQ) {
        return inputRQ.equals(ReOrQuit.RE_GAME);
    }
}
