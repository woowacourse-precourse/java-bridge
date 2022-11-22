package bridge.controller;

import bridge.model.OutputMessage;
import bridge.model.UserKeySet;
import bridge.service.BridgeGame;
import bridge.BridgeMaker;
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
            boolean keepPlay = play(game);
            if(!keepPlay) {
                break;
            }
        }
        end(game);
    }

    public BridgeGame initGame() {
        outputView.printSimpleMsg(OutputMessage.GAME_START_MSG);

        outputView.printSimpleMsg(OutputMessage.INPUT_BRIDGE_SIZE_MSG);
        int bridgeSize = inputView.readBridgeSize(BridgeMaker.BRIDGE_MIN_SIZE, BridgeMaker.BRIDGE_MAX_SIZE);

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return new BridgeGame(bridge);
    }

    private boolean play(BridgeGame game) {
        boolean success = move(game);

        if(success) {
            return true;
        }

        return retry(game);
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

    public boolean retry(BridgeGame game) {
        outputView.printInputCommandMsg();
        String command = inputView.readGameCommand();

        boolean isRetry = command.equals(UserKeySet.RETRY.toString());
        if(isRetry) {
            game.retry();
        }

        return isRetry;
    }

    public void end(BridgeGame game) {
        outputView.printSimpleMsg(OutputMessage.GAME_RESULT_MSG);
        List<String> bridge = game.getBridge();
        List<String> movements = game.getMovements();
        outputView.printMap(bridge, movements);

        boolean success = game.isComplete();
        int trialCount = game.getTrialCount();
        outputView.printResult(success, trialCount);
    }
}
