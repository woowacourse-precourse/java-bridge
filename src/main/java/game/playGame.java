package game;

import bridge.bridgeDomain.operator.BridgeException;
import bridge.BridgeMaker;
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
    boolean gameContinue = true;
    boolean gameCheck = true;
    boolean playGame=true;

    BridgeGameResult bridgeGameResult;

    public void setPlayGame() {
        output.printStart();
        output.printInputBridgeSize();
        while (bridgeGame.setBridgeSize(input.inputBridgeSize())) {
        }
        bridge.setBridge(bridgeMaker.makeBridge(bridgeGame.getBridgeSize()));
    }
    public void play() {
        setPlayGame();
        while (playGame) {
            bridgeGame.initializeUserMove();
            gameContinue=true;
            gameCheck=true;
            playGame=gamePlay();
        }
    }
    boolean keepGamePlay() {
        bridgeGameResult = new BridgeGameResult(bridge.getBridge(), bridgeGame.getMoveList());
        output.printMap(bridgeGameResult.getList());
        return checkResult();
    }
    boolean checkResult() {
        if (bridgeException.checkFail(bridgeGameResult.getList()) == true) {
            return false;
        }
        if (bridgeException.checkSuccess(bridgeGameResult.getList()) == bridgeGame.getBridgeSize()) {
            gameContinue = false;
            return false;
        }
        return true;
    }
    boolean gamePlay() {
        while (gameCheck) {
            output.printSelectMove();
            while (bridgeGame.move(input.inputUserMoving())) {
            }
            gameCheck = keepGamePlay();
        }
        return endGame();
    }
    boolean endGame() {
        if (gameContinue == true) {
            output.printReStart();
            while (bridgeGame.retry(input.inputReGame())) {
            }
            return endGameCheck();
        }
        output.printResult(bridgeGameResult.getList(), bridge.getTryNumber(), gameContinue);
        return false;
    }

    boolean endGameCheck() {
        System.out.println(bridgeGame.getRetry());
        if (bridgeGame.getRetry().equals("R")) {
            bridge.checkTryNumber();
            return true;
        }
        output.printResult(bridgeGameResult.getList(), bridge.getTryNumber(), gameContinue);
        return false;
    }


}