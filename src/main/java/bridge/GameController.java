package bridge;

public class GameController {
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;

    GameController() {
        inputView = new InputView();
        outputView = new OutputView();

    }

    private boolean simulate() {
        while (!bridgeGame.isOver()) {
            if (!bridgeGame.canMove(inputView.readMoving())) {
                outputView.printMap(bridgeGame.bridgeMap.getBridgeMap());
                return false;
            }
            outputView.printMap(bridgeGame.bridgeMap.getBridgeMap());
        }
        return true;
    }

    private void ending() {
        outputView.printResult(bridgeGame.bridgeMap.getBridgeMap(), bridgeGame.isOver(), bridgeGame.getTrial());
    }

    public void run() {
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
        outputView.openingMention();
        while (true) {
            if (simulate() || inputView.readGameCommand().equals("Q")) {
                break;
            }
            bridgeGame.retry();
        }
        ending();
    }
}
