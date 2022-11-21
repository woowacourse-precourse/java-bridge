package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.BridgeStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    private GameController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public static GameController start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);
        return new GameController(inputView, outputView, bridgeGame);
    }

    public boolean play() {
        boolean alive;
        do {
            String move = inputView.readMoving();
            alive = bridgeGame.move(move);
            BridgeStatus currStatus = bridgeGame.getStatus();
            outputView.printMap(currStatus);
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
