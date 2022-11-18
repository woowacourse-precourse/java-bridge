package bridge;

import java.util.List;

public class MainGame {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final List<String> bridge;
    private final BridgeGame bridgeGame;
    private int countGame = 1;
    private boolean restart;

    public MainGame() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        restart = true;
        outputView.printStart();
        outputView.printLengthInput();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridge);
        System.out.println(bridge); //test print
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
            restart = false;
            //정답
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
        lostGame();
    }

    public void lostGame() {
        outputView.printResult(bridgeGame.getUserBridge(), restart, countGame);
    }

}
