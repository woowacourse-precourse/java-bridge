package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printGameStartMessage();
        outputView.printBridgeLengthInputMessage();
        int bridgeSize = inputView.readBridgeSize();
        System.out.println();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
        boolean movingSuccess = false;
        boolean allPass = false;
        do {
            outputView.printMoveInputMessage();
            String moving = inputView.readMoving();
            movingSuccess = bridgeGame.move(moving);
            outputView.printMap(bridgeGame.getMovingMap());
            allPass = bridgeGame.allPass();
        } while (movingSuccess && !allPass);
    }
}
