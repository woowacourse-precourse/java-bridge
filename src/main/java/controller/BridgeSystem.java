package controller;

import model.BridgeMap;
import model.UserMap;
import view.InputView;
import view.OutputView;

import java.util.List;

public class BridgeSystem {

    private BridgeMap bridgeMap;
    private UserMap userMap;
    private InputView inputView;
    private OutputView outputView;
    private int countOfAttempt;
    private BridgeGame bridgeGame;

    public void runGame() {
        countOfAttempt = 0;
        inputView = new InputView();
        outputView = new OutputView();
        outputView.printRunGameText();
        bridgeMap = new BridgeMap(initializeBridge());

        int result = tryGamePlay();
        printGameResult(result);
    }

    public List<String> initializeBridge() {
        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> builtBridge = bridgeMaker.makeBridge(bridgeSize);

        return builtBridge;
    }


    public int tryGamePlay() {
        for (; ; ) {
            countOfAttempt++;
            userMap = new UserMap(bridgeMap.getBridgeSize());
            int result = playGame();

            if (result != 0) {
                return result;
            }
        }
    }

    public int playGame() {
        bridgeGame = new BridgeGame(bridgeMap, userMap);
        for (int loop = 0; loop < bridgeMap.getBridgeSize(); loop++) {
            boolean canMove = bridgeGame.move(inputView.readMoving());
            outputView.printMap(userMap.getMapOfMove(), bridgeGame.getCountOfMove());

            if (canMove) {
                return bridgeGame.retry(inputView.readGameCommand());
            }
        }
        return 1;
    }

    public void printGameResult(int result) {
        outputView.printResultText();
        outputView.printMap(userMap.getMapOfMove(), bridgeGame.getCountOfMove());
        outputView.printResult(result,countOfAttempt);
    }
}
