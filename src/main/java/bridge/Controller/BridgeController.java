package bridge.Controller;

import bridge.Domain.BridgeGame;
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
            System.out.println(e.getMessage());
        }
    }

    private BridgeGame new_BridgeGame() {
        int num = OutputView.BridgeLengthCheck(InputView.readBridgeSize());
        if (num < 3 || num > 20) new_BridgeGame();
        return new BridgeGame(num);
    }

    private String MovingCheck(String moving) {
        String val = OutputView.MovingCheck(moving);
        if (!val.equals(moving))
            MovingCheck(InputView.readMoving());
        return moving;
    }

    private void Gaming(BridgeGame game) {
        GameSelectRetry(game);
        GameRetry();
        GameOverCheck(game);
    }

    private void GameSelectRetry(BridgeGame game) {
        if (continue_game.equals(Retry)) {
            String val = OutputView.RetryCheck(InputView.readGameCommand());
            if (val.isEmpty()) GameSelectRetry(game);
            continue_game = game.retry(val);
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