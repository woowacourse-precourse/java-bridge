package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);

        String move;
        boolean canMove;
        do {
            move = inputView.readMoving();
            canMove = bridgeGame.canMove(move);
            outputView.printMap(bridgeGame.getMove(), canMove);
        } while (canMove && !bridgeGame.success());



    }
}

