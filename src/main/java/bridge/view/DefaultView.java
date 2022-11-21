package bridge.view;

import bridge.controller.BridgeGameController;

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
    }

    private void outputWelcome() {
        outputView.printWelcome();
        System.out.println();
    }

    private void inputBridgeSize() {
        outputView.printReadBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        controller.createBridge(bridgeSize);
    }

    private void playGame() {
        boolean isMove, isEnd;
        do {
            isMove = inputMove();
            isEnd = controller.checkGameProgress();
            outputBridgeMap();
        } while (isMove && !isEnd);
        if (isEnd) {
            outputResult();
            return;
        }
        inputGameCommand();
    }

    private boolean inputMove() {
        outputView.printReadMove();
        String move = inputView.readMove();
        return controller.moveBridge(move);
    }

    private void outputBridgeMap() {
        String map = controller.createMap();
        outputView.printMap(map);
        System.out.println();
    }

    private void inputGameCommand() {
        outputView.printRetry();
        String input = inputView.readGameCommand();
        boolean isRetry = controller.runCommand(input);
        if (isRetry) {
            playGame();
        }
    }

    private void outputResult() {
        String map = controller.createMap();
        outputView.printResult(map);
    }
}
