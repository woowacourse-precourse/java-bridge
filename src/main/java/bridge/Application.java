package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();
        BridgeGame newGame = app.settingGame();
        app.runningGame(newGame);
        app.closeingGame(newGame);
    }
}
    public void runningGame(BridgeGame game) {
        boolean playing = true;
        while (playing && game.moveResult.size() < game.bridge.size()) {
            playing = moving(game);
            output.printMap(game.bridge, game.moveResult);
            if (!playing) {
                playing = playAgain(game);
            }
        }
    }

    public void closingGame(BridgeGame game) {
        output.printResult(game);
    }


    private boolean moving(BridgeGame game) {
        output.printAskMovement();
        return game.move(input.readMoving());
    }

    private boolean playAgain(BridgeGame game) {
        output.printAskRetry();
        return game.retry(input.readGameCommand());
    }
}
