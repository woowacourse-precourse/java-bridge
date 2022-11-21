package Controller;

import view.InputView;
import view.OutputView;
import bridge.*;

public class playGame {
    InputView input = new InputView();
    OutputView output = new OutputView();
    BridgeRandomNumberGenerator BridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(BridgeNumberGenerator);
    BridgeGame bridge = new BridgeGame();

    void play() {
        output.printStart();
        output.printInputBridgeSize();
        bridge.bridgeSize(input.inputBridgeSize());
        bridge.bridge(bridgeMaker.makeBridge(bridge.getConvertBridgeSize()));

        while (true) {
            bridge.initializeUserMove();
            if (gamePlay() == false) {
                break;
            }
        }
    }

    boolean gamePlay() {

        boolean gameContinue = true;
        BridgeGameResult bridgeGameResult;

        while (true) {
            output.printSelectMove();
            bridge.move(input.inputUserMoving());

            bridgeGameResult = new BridgeGameResult(bridge.getBridge(), bridge.getMoveList());
            output.printMap(bridgeGameResult.getList());
            if (bridge.checkFail(bridgeGameResult.getList()) == true) {
                break;
            }
            if (bridge.checkSuccess(bridgeGameResult.getList())==bridge.getConvertBridgeSize()) {
                gameContinue = false;
                break;
            }

        }

        if (gameContinue == true) {
            output.printReStart();
            bridge.retry(input.inputReGame());
            if (bridge.getRetry().equals("R")) {
                bridge.checkTryNumber();
                return true;
            }
            if(bridge.getRetry().equals("Q")){
                output.printResult(bridgeGameResult.getList(), bridge.getTryNumber(), gameContinue);
            }
        }

        output.printResult(bridgeGameResult.getList(), bridge.getTryNumber(), gameContinue);

        return false;
    }

}
