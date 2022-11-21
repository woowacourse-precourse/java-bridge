package bridge.controller;

import bridge.BridgeSizeGenerator;
import bridge.controller.util.AppCofig;
import bridge.service.BridgeGame;
import bridge.BridgeMaker;
import bridge.MovementCommandGenerator;
import bridge.MovementStatusForm;
import bridge.controller.util.MessageConverter;
import bridge.service.GameChecker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.Deque;
import java.util.List;

public class BridgeGameController {

    BridgeGame bridgeGame;
    GameChecker gameChecker;
    Deque<MovementStatusForm> movementStatus;

    public BridgeGameController(BridgeGame bridgeGame, GameChecker gameChecker) {
        this.bridgeGame = bridgeGame;
        this.gameChecker = gameChecker;
    }

    public void run() {
        OutputView.printIntro();
        BridgeMaker bridgeMaker = AppCofig.createBridgeMaker();
        Integer bridgeSize = inputBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        OutputView.printNewLine();
        start(bridgeSize, bridge);
    }

    private Integer inputBridgeSize() {
        try {
            BridgeSizeGenerator bridgeSizeGenerator = AppCofig.createBridgeSizeGenerator();
            return bridgeSizeGenerator.generate(
                    MessageConverter.convertStringTOInteger(InputView.readBridgeSize())
            );
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputBridgeSize();
        }
    }

    private void start(Integer bridgeSize, List<String> bridge) {
        int play_count = 0;
        boolean isPlayerWin = false;
        do {
            play_count++;
            bridgeGame = AppCofig.createBridgeGame();
            while (continueGame(bridgeSize, bridge)) ;
            if (isPlayerWin = gameChecker.isWin(movementStatus, bridgeSize)) break;
        } while (inputRetry());
        OutputView.printResult(play_count, isPlayerWin, movementStatus);
    }

    private boolean inputRetry() {
        try {
            return bridgeGame.retry(InputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputRetry();
        }
    }

    private boolean continueGame(Integer bridgeSize, List<String> bridge) {
        String movement_command = inputMovementCommand();
        movementStatus = bridgeGame.move(movement_command, bridge);
        OutputView.printMap(movementStatus);
        if (gameChecker.isGameOver(movementStatus, bridgeSize)) {
            return false;
        }
        return true;
    }

    private String inputMovementCommand() {
        try {
            return MovementCommandGenerator.generate(InputView.readMoving());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputMovementCommand();
        }
    }


}
