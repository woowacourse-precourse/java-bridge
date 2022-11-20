package bridge.view;

import bridge.domain.Direction;
import bridge.exception.ErrorMessage;
import bridge.game.GameStatus;

public class View {

    private View() {
    }

    public static void startGame() {
        OutputView.startGame();
    }

    public static int getBridgeLength() {
        OutputView.getBridgeLength();
        while (true) {
            try {
                return InputView.readBridgeSize();
            } catch (NumberFormatException e) {
                printErrorMessage(ErrorMessage.BRIDGE_LENGTH_IS_BETWEEN_3_AND_20);
            }
        }
    }

    public static Direction readMoving() {
        OutputView.selectRoom();
        return InputView.readMoving();
    }

    public static void printMap(String map) {
        OutputView.printMap(map);
    }

    public static void printResult(GameStatus gameStatus, Direction direction) {
        OutputView.printResult(gameStatus, direction);
    }

    public static String checkRestart() {
        OutputView.checkRestart();
        return InputView.readGameCommand();
    }

    public static void printErrorMessage(String message) {
        OutputView.printErrorMessage(message);
    }

}
