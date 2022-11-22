package bridge.controller;

import bridge.Lang;
import bridge.util.Console;

public class RetryController extends Controller {
    public RetryController() {
        super();
    }

    public boolean askGameRetryAndQuit() {
        return this.inputView.readGameCommand();
    }

    public void printGameMapAndStatus(boolean isPass) {
        Console.printLine(Lang.get(Lang.GAME_RESULT));

        int step = this.getLastTreadStep();
        this.outputView.printMap(this.getSlapMaps(step));
        Console.printLine("");

        Console.printLine(Lang.format(Lang.IS_GAME_PASS, this.getGameStatusText(isPass)));
        Console.printLine(Lang.format(Lang.TOTAL_ATTEMPT, this.getRetries()));
    }

    private String getGameStatusText(boolean isPass) {
        if (isPass) {
            return Lang.get(Lang.GAME_IS_PASS);
        }

        return Lang.get(Lang.GAME_IS_FAIL);
    }

}
