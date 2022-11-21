package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    public static boolean success;

    public static int BridgeSize() {
        InputView inputView = new InputView();
        String BridgeSize = inputView.readBridgeSize();
        return Integer.parseInt(BridgeSize);
    }

    @Deprecated
    public static List<String> userBridge(List<String> bridge) {
        InputView inputView = new InputView();
        List<String> userBridge = new ArrayList<>();
        for (int i = 0; i < bridge.size(); i++) {
            String MovingSquare = inputView.readMoving();
            userBridge.add(MovingSquare);
            success = userSuccess(userBridge.get(i), bridge.get(i));
            //Result = OutputView.print(bridge, userBridge);
            //OutputView.printGame(Result);
        }
        return userBridge;
    }

    public static boolean userSuccess(String userBridgeWord, String bridgeWord) {
        if (!Objects.equals(userBridgeWord, bridgeWord)) {
            return false;
        }
        return true;
    }
}
