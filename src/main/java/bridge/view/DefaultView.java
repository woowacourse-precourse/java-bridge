package bridge.view;

import bridge.controller.BridgeGameController;
import bridge.controller.dto.GameResult;
import bridge.controller.dto.MoveResult;

public class DefaultView implements View {

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeGameController controller;

    public DefaultView(
            OutputView outputView,
            InputView inputView,
            BridgeGameController controller) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.controller = controller;
    }

    public void render() {
        outputWelcome();
        inputBridgeSize();
        playGame();
        outputResult();
    }

    private void outputWelcome() {
        outputView.printWelcome();
        System.out.println();
    }

    private void inputBridgeSize() {
        outputView.printReadBridgeSize();
        try {
            int bridgeSize = inputView.readBridgeSize();
            controller.createBridge(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBridgeSize();
        }
    }

    private void playGame() {
        boolean isMove, isEnd;
        do {
            MoveResult result = inputMove();
            isMove = result.isMove();
            isEnd = result.isEnd();
            outputBridgeMap(result.getMap());
        } while (isMove && !isEnd);
        if (!isMove) {
            inputGameCommand();
        }
    }

    private MoveResult inputMove() {
        outputView.printReadMove();
        String move;
        try {
             move = inputView.readMove();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMove();
        }
        return controller.moveBridge(move);
    }

    private void outputBridgeMap(String map) {
        outputView.printMap(map);
        System.out.println();
    }

    private void inputGameCommand() {
        outputView.printRetry();
        try {
            String command = inputView.readGameCommand();
            doBehaviorByCommand(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputGameCommand();
        }
    }

    private void doBehaviorByCommand(String command) {
        if (controller.runCommand(command)) {
            playGame();
        }
    }

    private void outputResult() {
        GameResult gameResult = controller.createResult();
        outputView.printResult(gameResult.getMap(), gameResult.getResult());
    }
}
