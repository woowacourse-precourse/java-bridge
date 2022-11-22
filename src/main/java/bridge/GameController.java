package bridge;

import java.util.List;

public class GameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeMaker bridgeMaker= new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;
    private List<String> bridge;
    private int count = 1;

    public void run() {
        startGame();
    }

    private void startGame() {
        try {
            outputView.printStartMessage();
            bridge = bridgeMaker.makeBridge(getLegLengthByUserInput());
            do {
                bridgeGame = new BridgeGame();
                bridgeGame(bridge, bridgeGame);
            } while (!isEnd());
            outputView.printResult(count, bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isEnd() {
        if (bridgeGame.survivalStatus== checkTheEnd.FAILED) {
            return false;
        }
        return true;
    }

    private int getLegLengthByUserInput() throws IllegalArgumentException {
        outputView.printBridgeSizeRequest();
        return inputView.readBridgeSize(inputView.readUserInput());
    }

    private void bridgeGame(List<String> bridge, BridgeGame bridgeGame) throws IllegalArgumentException {
        int index = 0;
        do {
            movingByUserInput(bridgeGame, bridge.get(index++));
            bridgeGame.checkTheEndByBrideSize(bridge.size());
            outputView.printMap(bridgeGame.log);
        } while (bridgeGame.survivalStatus.equals(checkTheEnd.RUNNING));
        if (!isEnd()) {
            count++;
            retryByUserInput(bridgeGame);
        }
    }

    private void movingByUserInput(BridgeGame bridgeGame, String answer) throws IllegalArgumentException {
        outputView.printMovingRequest();
        String userInput = inputView.readMoving(inputView.readUserInput());
        bridgeGame.move(userInput, answer);
    }

    private void retryByUserInput(BridgeGame bridgeGame) {
        outputView.printGameStatusRequest();
        String userInput = inputView.readGameCommand(inputView.readUserInput());
        if (bridgeGame.retry(userInput)) {
            bridgeGame.survivalStatus = checkTheEnd.FAILED;
            return;
        }
        bridgeGame.survivalStatus=checkTheEnd.SUCCESS;
    }

}
