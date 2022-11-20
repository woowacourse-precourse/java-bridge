package bridge;

import bridge.BridgeGame.BridgeGame;
import bridge.BridgeMaker.BridgeMaker;
import bridge.BridgeMaker.NumberGenerator.BridgeRandomNumberGenerator;
import bridge.UI.Input.InputView;
import bridge.UI.Output.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();

        int location = 0;
        boolean retryFlag = false;

        while(location < bridgeGame.getBridgeSize()){
            if(!bridgeGame.move(location))
                retryFlag = bridgeGame.retry();

            if(retryFlag) {
                location = 0;
                bridgeGame.clear();
                retryFlag = false;
                continue;
            }

            location++;
        }

    }
}
