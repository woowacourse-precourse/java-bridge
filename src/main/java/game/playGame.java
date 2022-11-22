package game;

import bridge.bridgeDomain.operator.BridgeException;
import bridge.bridgeDomain.operator.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.bridgeDomain.data.Bridge;
import bridge.bridgeDomain.operator.BridgeGameResult;
import userdomain.data.BridgeGame;
import userdomain.userinterface.InputView;
import userdomain.userinterface.OutputView;

public class playGame {
    InputView input = new InputView();
    OutputView output = new OutputView();
    BridgeRandomNumberGenerator BridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(BridgeNumberGenerator);
    Bridge bridge = new Bridge();
    BridgeGame bridgeGame = new BridgeGame();
    BridgeException bridgeException = new BridgeException();

    void play() {
        output.printStart();
        output.printInputBridgeSize();

        while(bridgeGame.setBridgeSize(input.inputBridgeSize())){
        }

        bridge.setBridge(bridgeMaker.makeBridge(bridgeGame.getBridgeSize()));
        while (true) {
            bridgeGame.initializeUserMove();
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

            while(bridgeGame.move(input.inputUserMoving())){
            }

            bridgeGameResult = new BridgeGameResult(bridge.getBridge(), bridgeGame.getMoveList());
            output.printMap(bridgeGameResult.getList());
            if (bridgeException.checkFail(bridgeGameResult.getList()) == true) {
                break;
            }
            if (bridgeException.checkSuccess(bridgeGameResult.getList()) == bridgeGame.getBridgeSize()) {
                gameContinue = false;
                break;
            }
        }

        if (gameContinue == true) {
            output.printReStart();
            while(bridgeGame.retry(input.inputReGame())){
            }
            if (bridgeGame.getRetry().equals("R")) {
                bridge.checkTryNumber();
                return true;
            }
            if (bridgeGame.getRetry().equals("Q")) {
                output.printResult(bridgeGameResult.getList(), bridge.getTryNumber(), gameContinue);
                return false;
            }
        }

        output.printResult(bridgeGameResult.getList(), bridge.getTryNumber(), gameContinue);

        return false;
    }

}
