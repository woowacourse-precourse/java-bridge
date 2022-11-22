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
        BridgeGame game = new_BridgeGame();

        while (!continue_game.contains(Quit)) {
            String moving = MovingCheck();
            continue_game = OutputView.printMap(game.move(moving), moving);
            Gaming(game);
        }
        OutputView.printCount(continue_game, count_try);
    }

    private BridgeGame new_BridgeGame() {
        while (true) {
            try {
                return new BridgeGame(OutputView.BridgeLengthCheck(InputView.readBridgeSize()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String MovingCheck() {
        while (true) {
            try {
                return OutputView.MovingCheck(InputView.readMoving());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void Gaming(BridgeGame game) {
        if (continue_game.equals(Retry)) GameSelectRetry(game);
        if(!GameRetry()) return;
        GameOverCheck(game);
    }

    private void GameSelectRetry(BridgeGame game) {
        while (true) {
            try {
                continue_game = game.retry(OutputView.RetryCheck(InputView.readGameCommand()));
                return;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private Boolean GameRetry() {
        if (continue_game.equals(Retry)) {
            count_try++;
            OutputView.MapReset();
            return true;
        }
        if (continue_game.equals(Quit))
            return false;
        return true;
    }

    private void GameOverCheck(BridgeGame game) {
        if (!continue_game.equals(FailuresQuit))
            continue_game = game.check_over();
    }
}