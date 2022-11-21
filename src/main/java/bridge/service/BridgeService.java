package bridge.service;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.vo.Command;

public class BridgeService {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame = new BridgeGame();


    public void startBridgeGame() {
        outputView.printStartMessage();
        outputView.printInputBridgeSizeMessage();

        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.setBridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void moveBridge() {
        System.out.println();
        outputView.printInputMoveBridgeMessage();
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getUser(), bridgeGame.getBridge());

        if (isRoundClear()) return;
        restartBridgeGame();
    }

    private boolean isRoundClear() {
        if (bridgeGame.roundClear()) {
            if (bridgeGame.gameClear()) {
                return true;
            }
            moveBridge();
            return true;
        }
        return false;
    }

    private void restartBridgeGame() {
        if (!bridgeGame.roundClear()) {
            outputView.printRestartGameMessage();
            String retryCommand = inputView.readGameCommand();
            if (retryCommand.equals(Command.RESTART)) {
                bridgeGame.retry();
                moveBridge();
            }
        }
    }

    public void endBridgeGame() {
        outputView.printFinalMessage();
        outputView.printResult(bridgeGame.getUser(), bridgeGame.getBridge());
        System.out.println();
        printSuccess();
        printGameCount();
    }

    public void printSuccess() {
        String result = "성공";
        if (!bridgeGame.roundClear() || !bridgeGame.gameClear()) {
            result = "실패";
        }
        System.out.println(outputView.printBridgeGameSuccess() + result);
    }

    public void printGameCount() {
        int count = bridgeGame.getUser().getCount();
        System.out.println(outputView.printTryBridgeGameCount() + count);
    }
}
