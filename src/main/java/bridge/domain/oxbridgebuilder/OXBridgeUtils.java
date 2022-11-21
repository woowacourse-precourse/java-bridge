package bridge.domain.oxbridgebuilder;

import java.util.List;
import java.util.stream.Collectors;

public class OXBridgeUtils {

    private static final String CORRECT = "O";
    private static final String WRONG = "X";
    public static final String SPACE = " ";

    public static String makeOX(boolean correctOrWrong) {
        if (correctOrWrong) {
            return CORRECT;
        }
        return WRONG;
    }

    public static String makingResult(List<String> upBridge, List<String> downBridge) {
        return makeResult(upBridge) + makeResult(downBridge);
    }

    public static String makeResult(List<String> bridge) {
        return bridge.stream()
                .collect(Collectors.joining(BridgeDesign.BRIDGE_BLOCK.getDesign()
                        , BridgeDesign.BRIDGE_START.getDesign()
                        , BridgeDesign.BRIDGE_END.getDesign()));
    }
}
