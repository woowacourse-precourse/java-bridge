package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static bridge.Constants.*;

public class Application {
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();

    public static void main(String[] args) {
        outputView.printInit();
        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        for(int size = 0; size < bridgeSize; size++) {
            outputView.printSelect();
            String moving = inputView.readMoving();
            String result = bridgeGame.move(moving, size);
            outputView.printMap(bridgeGame.getMoveResults(), size, bridgeGame.getUserMove());
            if(result.equals(CANNOT_CROSS)){
                outputView.printRetry();
                String command = inputView.readGameCommand();
                size = bridgeGame.retry(command, bridgeSize);
            }
        }
        outputView.printResult(bridgeGame.getMoveResults(), bridgeGame.getUserMove(), bridgeGame.getTryCount());
    }


}
