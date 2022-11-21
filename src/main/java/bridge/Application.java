package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);

        String move = "";
        do {
            move = inputView.readMoving();
            outputView.printMap(outputView.makeMove(bridgeGame.getMove(), bridgeGame.canMove(move)));
        } while (bridgeGame.canMove(move) && !bridgeGame.success());



    }
}
