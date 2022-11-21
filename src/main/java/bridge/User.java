package bridge;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static int BridgeSize(){
        InputView inputView = new InputView();
        String BridgeSize = inputView.readBridgeSize();
        return Integer.parseInt(BridgeSize);
    }

    public static List<String> userBridge(List<String> bridge){
        InputView inputView = new InputView();
        List<String> userBridge = new ArrayList<>();
        for(int i=0;i<bridge.size();i++){
            String MovingSquare = inputView.readMoving();
            userBridge.add(MovingSquare);
        }
        return userBridge;
    }
}
