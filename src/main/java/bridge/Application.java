package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeSize());

        playingGame(bridgeGame, inputView, outputView);

        outputView.printResult(bridgeGame.getMove(), bridgeGame.success(), bridgeGame.getTryNum());
    }

    public static void moveAndPrintingMap(BridgeGame bridgeGame, InputView inputView, OutputView outputView){
        String move;
        boolean canMove;
        do {
            move = inputView.readMoving();
            canMove = bridgeGame.canMove(move);
            outputView.printMap(bridgeGame.getMove(), canMove);
        } while (canMove && !bridgeGame.success());
    }

    public static void playingGame(BridgeGame bridgeGame, InputView inputView, OutputView outputView){
        do {
            moveAndPrintingMap(bridgeGame, inputView, outputView);
            if(bridgeGame.success()){
                break;
            }
        } while (bridgeGame.retry(inputView.readGameCommand()));
    }
}

