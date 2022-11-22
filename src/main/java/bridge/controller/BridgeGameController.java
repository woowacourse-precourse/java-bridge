package bridge.controller;

import bridge.BridgeMaker;
import bridge.config.BaseGameActivity;
import bridge.config.ErrorMessageConstant;
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

public class BridgeGameController extends BaseGameActivity {

    private final BridgePrinter bridgePrinter = new BridgeConsolePrinter();
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;


    public BridgeGameController(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
        validationConstructorParams();
    }


    @Override
    protected final void onStart() {
        int bridgeSize = readBridgeSize();
        createBridgeGame(bridgeSize);
    }

    @Override
    protected final void onLoop() {
        while (bridgeGame.getStatus() == GameStatus.RUNNING) {
            proceedTurn();
        }
        if (bridgeGame.getStatus() == GameStatus.LOSE && enterRetry()) {
            bridgeGame.retry();
            return;
        }
        super.stop();
    }

    @Override
    protected final void onStop() {
        outputView.printResult(bridgeGame, bridgePrinter);
    }

    private void validationConstructorParams() throws IllegalArgumentException {
        if (this.bridgeMaker == null || inputView == null || outputView == null) {
            throw new IllegalArgumentException(ErrorMessageConstant.PARAMS_HAVE_NULL_VALUE);
        }
    }

    private int readBridgeSize() {
        outputView.printGameStart();
        outputView.printEnterBridgeLength();
        return inputView.readBridgeSize();
    }

    private void createBridgeGame(int bridgeSize) {
        List<String> bridgeInfo = bridgeMaker.makeBridge(bridgeSize);
        Bridge bridge = new Bridge(bridgeInfo);
        bridgeGame = new BridgeGame(bridge);
    }
    
    private boolean enterRetry() {
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
