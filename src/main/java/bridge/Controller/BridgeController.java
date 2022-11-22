package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeNumberGenerator;
import bridge.Domain.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

public class BridgeController {
    static int count_try;
    static String continue_game = "Start";
    private static final String Retry = "Retry";
    private static final String Quit = "Quit";
    private static final String FailuresQuit = "F_Quit";

    public BridgeController() {
        OutputView.printStart();
        count_try = 1;
    }

    public void run() {
        try {
            BridgeGame game = new_BridgeGame();

            while (!continue_game.contains(Quit)) {
                String moving = MovingCheck(InputView.readMoving());
                continue_game = OutputView.printMap(game.move(moving), moving);
                Gaming(game);
            }
            OutputView.printCount(continue_game, count_try);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private BridgeGame new_BridgeGame() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeGame(bridgeNumberGenerator, OutputView.BridgeLengthCheck(InputView.readBridgeSize()));
    }

    private String MovingCheck(String moving) {
        return OutputView.MovingCheck(moving);
    }

    private void Gaming(BridgeGame game) {
        GameSelectRetry(game);
        GameRetry();
        GameOverCheck(game);
    }

    private void GameSelectRetry(BridgeGame game) {
        if (continue_game.equals(Retry)) {
            continue_game = game.retry(OutputView.RetryCheck(InputView.readGameCommand()));
        }
    }

    private void GameRetry() {
        if (continue_game.equals(Retry)) {
            count_try++;
            OutputView.MapReset();
        }
    }

    private void GameOverCheck(BridgeGame game) {
        if (!continue_game.equals(FailuresQuit))
            continue_game = game.check_over();
    }
}