package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgePrinter;
import bridge.domain.model.Direction;
import bridge.domain.model.GameStatus;
import bridge.view.BridgeConsolePrinter;
import bridge.view.CommandType;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final BridgePrinter bridgePrinter = new BridgeConsolePrinter();
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;


    public BridgeGameController(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGameStart();
        initBridge();
        loopGame();
    }

    private void initBridge() {
        outputView.printEnterBridgeLength();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeInfo = bridgeMaker.makeBridge(bridgeSize);
        Bridge bridge = new Bridge(bridgeInfo);
        bridgeGame = new BridgeGame(bridge);
    }

    private void loopGame() {
        while (bridgeGame.getStatus() != GameStatus.WIN) {
            loopTurn();
            determineRetry();

        }
        outputView.printResult(bridgeGame, bridgePrinter);
    }

    private void loopTurn() {
        while (bridgeGame.getStatus() == GameStatus.RUNNING) {
            proceedTurn();
        }
    }

    private boolean determineRetry() {
        outputView.printEnterGameRetry();
        CommandType command = inputView.readGameCommand();
        if (command == CommandType.GAME_QUIT) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }

    private void proceedTurn() {
        outputView.printEnterMoveDirection();
        Direction moving = mapToDirection(inputView.readMoving());
        bridgeGame.move(moving);
        outputView.printMap(bridgeGame, bridgePrinter);
    }

    private static Direction mapToDirection(CommandType commandType) {
        return Direction.of(commandType.getCommand());
    }

}
