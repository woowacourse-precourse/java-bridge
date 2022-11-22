package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    private BridgeController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        System.out.println("다시 건너기 게임을 시작합니다.");
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public static BridgeController start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);
        return new BridgeController(inputView, outputView, bridgeGame);
    }

    public boolean play() {
        boolean alive;
        do {
            String move = inputView.readMoving();
            alive = bridgeGame.move(move);
            outputView.printMap(bridgeGame);
        } while (alive && bridgeGame.ongoing());
        return alive;
    }

    public boolean restart(boolean isStopped) {
        if (isStopped) return false;
        boolean restart = inputView.readGameCommand();
        if (restart) {
            bridgeGame.retry();
        }
        return restart;
    }

    public void finish(boolean alive) {
        outputView.printResult(bridgeGame, alive);
    }
}
