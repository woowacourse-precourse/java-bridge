package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.bridgeGame.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;
    String retry = "R";

    public void gameStart() {
        outputView.printStartMessage();
        makeBridge(inputView.readBridgeSize());
    }

    public void makeBridge(int size) {
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
        isSuccessGame();
    }

    public void isSuccessGame() {
        while(!bridgeGame.isSuccessGame() && !retry.equals("Q")){
            String moveDirection = inputView.readMoving();
            moveBridge(moveDirection);
        }

        if (bridgeGame.isSuccessGame()) {
            printGameMessage();
            printGameMap();
            printGameResult(true);
        }
    }

    public void moveBridge(String moveDirection) {
        boolean isSameDirection = bridgeGame.isSameDirection(moveDirection);

        if (isSameDirection) {
            bridgeGame.move(moveDirection);
            printGameMap();
        }
        if (!isSameDirection) {
            bridgeGame.notMove(moveDirection);
            printGameMap();
            
        }
    }


    public void printGameMessage() {
        outputView.printMapMessage();
    }


    public void printGameMap() {
        outputView.printMap(bridgeGame.renderBridgeMap().getResultUp());
        outputView.printMap(bridgeGame.renderBridgeMap().getResultDown());
    }

    public void printGameResult(boolean isSuccess) {
        outputView.printResult(isSuccess, bridgeGame.getReGameCount());
    }

}
