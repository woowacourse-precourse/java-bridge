package bridge;

import java.util.List;

public class BridgeGameApplication {

    InputView inputView;
    OutputView outputView;
    int bridgeSize;

    BridgeGame game;

    public BridgeGameApplication() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeSize = 0;
    }

    public void run() {
        printGameStartLine();
        readBridgeSize();
        initBridgeGameRandomly();
        playGame();
        printGameResult();
    }

    private void printGameStartLine() {
        outputView.printGameStartLine();
    }

    private void readBridgeSize() {
        while (true) {
            try {
                bridgeSize = inputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void initBridgeGameRandomly() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeMap = bridgeMaker.makeBridge(bridgeSize);
        game = new BridgeGame(bridgeMap);
    }

    private void playGame() {
        while (true) {
            if (!playTurn()) {
                break;
            }
        }
    }

    private boolean playTurn() {
        game.move(readMoving());
        if (game.getGameResult() == GameResult.NOTHING_HAPPENED) {
            outputView.printMap(game);
            return true;
        }
        return playAgain();
    }

    private boolean playAgain() {
        if (game.getGameResult() == GameResult.USER_WIN) {
            return false;
        }
        if (readGameCommand().equals("R")) {
            outputView.printMap(game);
            game.retry();
            return true;
        }
        return false;
    }

    private Direction readMoving() {
        while (true) {
            try {
                return Direction.getInstance(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String readGameCommand() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printGameResult() {
        System.out.println("최종 게임 결과");
        outputView.printMap(game);
        outputView.printResult(game);
    }
}
