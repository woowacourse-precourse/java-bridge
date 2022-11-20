package controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        this.bridgeGame = bridgeGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        int bridgeLengthIndex = 0, gameAttempts = 1;
        String rOrQ = "";
        boolean success = true;
        while (bridgeLengthIndex < bridge.size()) {
            outputView.printMap(bridgeLengthIndex, inputView.readMoving(), bridge);
            bridgeLengthIndex += 1;
            if (outputView.upOutputBoard.contains("X") || outputView.downOutputBoard.contains("X"))
                rOrQ = inputView.readGameCommand();

            if (bridgeGame.quit(rOrQ)) {
                success = false;
                rOrQ = "";
                break;
            }

            if (bridgeGame.retry(rOrQ)) {
                gameAttempts += 1;
                bridgeLengthIndex = 0;
                outputView.upOutputBoard.clear();
                outputView.downOutputBoard.clear();
                rOrQ = "";
            }
        }
        if (success) outputView.printResult(true, gameAttempts);
        if (!success) outputView.printResult(false, gameAttempts);
    }
}
