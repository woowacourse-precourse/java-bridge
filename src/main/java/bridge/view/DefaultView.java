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
        String move;
        try {
             move = inputView.readMove();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMove();
        }
        return controller.moveBridge(move);
    }

    private void outputBridgeMap() {
        String map = controller.createMap();
        outputView.printMap(map);
        System.out.println();
    }

    private void inputGameCommand() {
        outputView.printRetry();
        String input;
        try {
            input = inputView.readGameCommand();
            boolean isRetry = controller.runCommand(input);
            if (isRetry) {
                playGame();
                return;
            }
            outputResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputGameCommand();
        }
    }

    private void outputResult() {
        String map = controller.createMap();
        String result = controller.createResult();
        outputView.printResult(map, result);
    }
}
