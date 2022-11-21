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

        boolean isMove;
        do {
            isMove = inputMove();
            outputBridgeMap();
        } while (isMove);
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
}
