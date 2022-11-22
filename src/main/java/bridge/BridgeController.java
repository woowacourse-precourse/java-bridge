package bridge;

import java.util.List;

public class BridgeController {

    private BridgeMaker bridgeMaker;
    private InputView inputView;
    private BridgeGame bridgeGame;
    private OutputView outputView;
    private MovingMap movingMap;
    private int count = 0;
    private boolean isGameOver;

    public BridgeController(BridgeMaker bridgeMaker, InputView inputView, BridgeGame bridgeGame, OutputView outputView, MovingMap movingMap) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.bridgeGame = bridgeGame;
        this.outputView = outputView;
        this.movingMap = movingMap;
    }

    public void playGame(List<String> bridge) {
        do {
            bridgeGame.move(bridge, inputView.readMoving(), movingMap);
            outputView.printMap(movingMap.getMovingMap());
            isGameOver = bridgeGame.isGameOver(bridge.size(), movingMap);
            if (isGameOver) {
                break;
            }
        } while (bridgeGame.isCorrect());
    }
}
