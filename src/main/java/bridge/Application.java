package bridge;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.HashMap;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGameSplit bridgeGameSplit = new BridgeGameSplit();

        List<String> bridge = bridgeGameSplit.bridgeStart();
        System.out.println(bridge);
        bridgeGameSplit.gameMain(bridge);
    }
}
