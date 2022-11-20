package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeSize;
import bridge.domain.bridge.Square;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeResult;
import bridge.domain.game.Command;
import bridge.domain.game.SquareResult;
import bridge.domain.move.MoveResult;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final BridgeGame bridgeGame;

    private BridgeResult bridgeResult = new BridgeResult();

    private BridgeSize bridgeSize;

    public BridgeGameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        Bridge bridge = init();
        playGame(bridge);
        printTotalResult();
    }

    private Bridge init() {
        outputView.printInit();
        bridgeSize = new BridgeSize(inputView.readBridgeSize());
        return createBridge(bridgeSize.get());
    }

    private Bridge createBridge(int size) {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> tempBridge = bridgeMaker.makeBridge(size);
        return Bridge.valueOf(tempBridge);
    }


    private void playGame(Bridge bridge) {
        while (bridgeGame.isGameInProgress()) {
            SquareResult squareResult = moveAndGetResult(bridge);
            printUpToNowMoveResult(squareResult);
            ifSuccessMoveOrExit(squareResult);

            if (squareResult.isFail()) {
                retryOrExitGame();
            }
        }
    }

    private void ifSuccessMoveOrExit (SquareResult squareResult) {
        if (squareResult.isSuccess()) {
            bridgeGame.move(bridgeSize.get());
        }

        if (bridgeGame.isGameSuccess(bridgeSize.get())) {
            bridgeGame.exitGame();
        }
    }

    private SquareResult moveAndGetResult(Bridge bridge) {
        Square userMove = createUserMove();
        return findMoveAbility(bridge, userMove);
    }

    private Square createUserMove() {
        String move = inputView.readMoving();
        return Square.of(move);
    }

    private SquareResult findMoveAbility(Bridge bridge, Square userMove) {
        int position = bridgeGame.getPosition();
        boolean moveResult = bridge.canMoveForward(userMove, position);
        return new SquareResult(userMove, MoveResult.of(moveResult));
    }

    private void printUpToNowMoveResult(SquareResult result) {
        bridgeResult.updateResult(result);
        outputView.printMap(bridgeResult.toDto());
    }

    private void retryOrExitGame() {
        Command command = new Command(inputView.readGameCommand());
        isExitSetGameStatus(command);
        isRetryInitializeGame(command);
    }


    private void printTotalResult() {
        outputView.printResult(
                bridgeResult.toDto(),
                bridgeGame.getRetryCount());
    }

    private void isExitSetGameStatus(Command command) {
        if (command.isExitCommand()) {
            bridgeGame.exitGame();
        }
    }

    private void isRetryInitializeGame(Command command) {
        if (command.isRetryCommand()) {
            bridgeGame.retry();
            bridgeResult = new BridgeResult();
        }
    }
}
