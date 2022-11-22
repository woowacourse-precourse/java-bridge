package bridge;

import java.util.List;

public class MainGame {
    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private int countGame;
    private boolean restart;

    public MainGame() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        outputView = new OutputView();
        inputView = new InputView();
        countGame = 1;
        restart = true;
    }

    public void startRound() {
        outputView.printStart();
        outputView.printLengthInput();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridge);
    }

    public void playRound() {
        while (restart) {
            outputView.printMovementInput();
            restart = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getUserBridge(), restart);
            checkAnswer();
        }
    }

    public void checkAnswer() {
        if (restart && bridgeGame.compareBridgeLength()) {
            EndGame();
            restart = false;
            return;
        }
        if (!restart) {
            outputView.printRetry();
            wrongAnswerPlayAgain();
        }
    }

    public void wrongAnswerPlayAgain() {
        String playAgain;

        playAgain = inputView.readGameCommand();
        if (playAgain.equals("R")) {
            bridgeGame.retry();
            countGame += 1;
            restart = true;
            return;
        }
        EndGame();
    }

    public void EndGame() {
        outputView.printResult(bridgeGame.getUserBridge(), restart, countGame);
    }


}
