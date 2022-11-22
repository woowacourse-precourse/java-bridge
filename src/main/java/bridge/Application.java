package bridge;

import java.util.List;
import static bridge.BridgeGameController.outputView;

public class Application {

    public static void main(String[] args) {
        outputView.printStart();
        List<String> answerBridge = BridgeGameController.startSettingBridge();
        BridgeGameController bridgeGameController = new BridgeGameController(answerBridge);
        List<List<String>> result = bridgeGameController.start();
        bridgeGameController.end(result);
    }
}
