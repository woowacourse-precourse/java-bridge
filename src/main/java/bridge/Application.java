package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try{
            List<String> answerBridge = BridgeGameController.startSettingBridge();
            BridgeGameController bridgeGameController = new BridgeGameController(answerBridge);
            List<List<String>> result = bridgeGameController.start();
            bridgeGameController.end(result);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
