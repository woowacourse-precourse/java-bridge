package bridge;

import bridge.ui.OutputView;

public class Game {
    private BridgeGame bridgeGame;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void Play() {
        try {
            GameStart();
            MakeBridge();
            Moving();
            End();
        } catch (IllegalArgumentException err) {
            System.out.println(err.getMessage());
        }
    }

    private void GameStart() {
        outputView.printStart();
    }

    private void MakeBridge() {
        outputView.printInsertBridgeSize();
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
        outputView.printBridgeSize(bridgeGame.getBridgeSize());
    }

    private void Moving() {
        while(!bridgeGame.getEnd()) {
            outputView.printInsertMove();
            bridgeGame.move(outputView.printMove(inputView.readMoving()));
            outputView.printMap(bridgeGame.getMap());
            if(!bridgeGame.getSuccess()) {
                outputView.printInsertRestart();
                bridgeGame.retry(outputView.printRestart(inputView.readGameCommand()));
            }
        }
    }

    private void End() {
        outputView.printResult(bridgeGame.getMap(), bridgeGame.getSuccess(), bridgeGame.getTryNumber());
    }
}
