package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.input.InputView;
import bridge.output.OutputView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeGameMachine {

    public void run() {
        InputView inputView = new InputView();
        int bridgeLength = inputView.readBridgeSize();

        BridgeRandomNumberGenerator randomGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomGenerator);
        List<String> designBridge = bridgeMaker.makeBridge(bridgeLength);
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();

        List<String> uPrintBridge = new ArrayList<String>();
        List<String> dPrintBridge = new ArrayList<String>();


        for (String playerLocation : designBridge) {
            String moveLocation = inputView.readMoving();

            if (moveLocation.equals("U")) {
                List<String> discriminant = bridgeGame.move(playerLocation, uPrintBridge);
            }

            if (moveLocation.equals("D")) {
                List<String> discriminant = bridgeGame.move(playerLocation, uPrintBridge);
            }



            //printBridge.add(printBridge);

        }

    }
}












