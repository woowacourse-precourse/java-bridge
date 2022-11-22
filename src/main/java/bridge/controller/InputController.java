package bridge.controller;

import bridge.view.InputView;
import bridge.domain.Player;

public class InputController {
    public static int checkSize(InputView inputView) {
        int size;
        try {
            size = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return (checkSize(inputView));
        }
        return size;
    }

    public static void checkMove(Player player) {
        try {
            player.move();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            checkMove(player);
        }
    }

    public static String checkGameCommend(Player player) {
        String gameCommand;
        try {
            gameCommand = player.retry();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkGameCommend(player);
        }
        return gameCommand;
    }
}
