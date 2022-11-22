package bridge.controller;

import bridge.view.InputView;
import bridge.domain.Player;
import bridge.view.OutputView;

public class InputController {
    private static final String NEW_LINE = "\n";
    public static int checkSize(InputView inputView) {
        int size;
        try {
            size = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            OutputView.printGuide(e.getMessage() + NEW_LINE);
            return (checkSize(inputView));
        }
        return size;
    }

    public static void checkMove(Player player) {
        try {
            player.move();
        } catch (IllegalArgumentException e) {
            OutputView.printGuide(e.getMessage() + NEW_LINE);
            checkMove(player);
        }
    }

    public static String checkGameCommend(Player player) {
        String gameCommand;
        try {
            gameCommand = player.retry();
        } catch (IllegalArgumentException e) {
            OutputView.printGuide(e.getMessage() + NEW_LINE);
            return checkGameCommend(player);
        }
        return gameCommand;
    }
}
