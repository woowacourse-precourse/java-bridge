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
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }

    private void initBridgeGameRandomly() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeMap = bridgeMaker.makeBridge(bridgeSize);
        game = new BridgeGame(bridgeMap);
    }

    private void playGame() {
        while (true) {
            game.move(readMoving());
            if (game.getGameResult() == GameResult.NOTHING_HAPPENED) {
                outputView.printMap(game);
                continue;
            }
            if (playAgain()) {
                continue;
            }
            break;
        }
    }

    private boolean playAgain() {
        if (game.getGameResult() == GameResult.USER_WIN) {
            return false;
        }
        if (readGameCommand().equals("R")) {
            game.retry();
            return true;
        }
        return false;
    }

    private Direction readMoving() {
        Direction direction;
        while (true) {
            try {
                direction = Direction.getInstance(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return direction;
        }
    }

    private String readGameCommand() {
        String gameCommand;
        while (true) {
            try {
                gameCommand = inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return gameCommand;
        }
    }

    private void printGameResult() {
        System.out.println("최종 게임 결과");
        outputView.printMap(game);
        outputView.printResult(game);
    }
}
