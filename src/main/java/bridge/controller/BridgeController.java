package bridge.controller;

import bridge.model.UserKeySet;
import bridge.service.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        try {
            playGame();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void playGame() {
        BridgeGame game = initGame();

        while (!game.isComplete()) {
            boolean moveSuccess = move(game);

            if (moveSuccess) {
                continue;
            }

            boolean isRetry = retry();

            if(!isRetry) {
                break;
            }

            game.retry();
        }
        end(game);
    }

    public BridgeGame initGame() {
        outputView.printGameStartMsg();

        outputView.printInputBridgeSizeMsg();
        int bridgeSize = inputView.readBridgeSize(BridgeMaker.BRIDGE_MIN_SIZE, BridgeMaker.BRIDGE_MAX_SIZE);

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return new BridgeGame(bridge);
    }

    public boolean move(BridgeGame game) {
        outputView.printInputMoveCellMsg();
        String movement = inputView.readMoving();

        boolean success = game.move(movement);

        List<String> bridge = game.getBridge();
        List<String> movements = game.getMovements();
        outputView.printMap(bridge, movements);

        return success;
    }

    public boolean retry() {
        outputView.printRestartMsg();
        String command = inputView.readGameCommand();

        return command.equals(UserKeySet.RETRY.toString());
    }

    public void end(BridgeGame game) {
        outputView.printGameResultMsg();
        List<String> bridge = game.getBridge();
        List<String> movements = game.getMovements();
        outputView.printMap(bridge, movements);

        boolean success = game.isComplete();
        int trialCount = game.getTrialCount();
        outputView.printResult(success, trialCount);
    }
}
