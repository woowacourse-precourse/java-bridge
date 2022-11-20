package bridge;

import java.util.List;
public class Application {
    public static void main(String[] args) {
        TotalResult result = BridgeGameController.start();
        BridgeGameController.printResult(result);
    }
}
