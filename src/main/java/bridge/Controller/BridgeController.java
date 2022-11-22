package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;

public class BridgeController {
    static int count_try;
    static int result_print;
    static String continue_game = "Start";
    private static final String Retry = "Retry";
    private static final String Quit = "Quit";
    private static final String FailuresQuit = "F_Quit";

    public BridgeController() {
        OutputView.printStart();
        count_try = 1;
        result_print = 1;
    }

    public void run() {
        BridgeGame game = new_BridgeGame();
        while (!continue_game.contains(Quit)) {
            if (result_print == 0) break;
            String moving = MovingCheck(InputView.readMoving());
            if (result_print == 0) break;
            continue_game = OutputView.printMap(game.move(moving), moving);
            if (result_print == 0) break;
            Gaming(game);
        }
        if (result_print == 1)
            OutputView.printCount(continue_game, count_try);
    }

    private BridgeGame new_BridgeGame() {
        return new BridgeGame(OutputView.BridgeLengthCheck(InputView.readBridgeSize()));
    }

    public static void validate() {
        result_print = 0;
        //continue_game = Quit;
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