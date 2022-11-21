package bridge;

import java.sql.SQLOutput;
import java.util.List;

public class BridgeGameSystem {
    private static final InputView inputView = new InputView();

    public void startBridgeGame(){
        startGame();
        int bridgeSize = BridgeGame.getBridgeSize();
        List<String> bridge = BridgeGame.getBridge(bridgeSize);
        System.out.println(bridge);
//        String move = getMoveDirect();
    }

    public static void startGame(){
        inputView.printStartMessage();
    }


}
