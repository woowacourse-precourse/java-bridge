package bridge.exception;

import bridge.domain.model.Bridge;
import java.util.List;

public class BridgeExceptionHandler {

    public static void handleNotOnlyUOrDException(List<String> bridge) {
        final String U_AND_D = "UD";
        if (!bridge.stream().allMatch(U_AND_D::contains)) {
            throw new IllegalStateException("[ERROR] 다리에 U, D 외 다른 문자가 포함되어 있습니다.");
        }
    }

    public static void handleBridgeNotCreatedException(boolean isCreated) {
        if (!isCreated) {
            throw new IllegalStateException("[ERROR] 아직 다리가 생성되지 않았습니다.");
        }
    }

    public static void handleCheckSpaceOutOfRangeException(int space) {
        if (!(-1 < space && space < Bridge.getBridgeSize())) {
            throw new IllegalStateException(
                    "[ERROR] 다리를 벗어난 공간에 대해 건너기 가능 여부를 확인하고 있습니다.");
        }
    }
}
