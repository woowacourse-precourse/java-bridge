package bridge.controller;

import bridge.Bridge;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker  = new BridgeMaker(bridgeRandomNumberGenerator);
    private BridgeGame bridgeGame = new BridgeGame();

    private OutputView outputView = new OutputView();
    private Bridge bridge;

    public void game() throws IllegalArgumentException{
        int size = InputView.readBridgeSize();

        List<String> bridgeRoads = bridgeMaker.makeBridge(size);
        bridge = new Bridge(bridgeRoads);
        String retryChoice = null;
        int tryNumbers = 1;
        boolean pass = false;

        do {
            for (int i = 0 ; i< size; i++) {
                String choice = InputView.readMoving();
                boolean move = bridgeGame.move(bridge, choice, i);
                /* 출력 */
                outputView.printMap(bridge, i);

                if (!move) {
                    tryNumbers++;
                    retryChoice = InputView.readGameCommand();
                    break;
                }

                if (i == size-1) {
                    pass = true;
                }
            }
        } while (retryChoice == "R" || !pass);

        /* 결과 출력 OutputView#printResult() */
        System.out.println("");
        outputView.printResultMap(bridge, size);
        outputView.printWinorLose(pass);
        outputView.printTryNumbers(tryNumbers);
    }
}
