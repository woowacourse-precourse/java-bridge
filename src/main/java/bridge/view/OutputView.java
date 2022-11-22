package bridge.view;

import bridge.enums.Answer;
import bridge.enums.OutputMessage;

import java.util.List;

public class OutputView {

    public void outputGameStart() {
        System.out.println(OutputMessage.OUTPUT_START_BRIDGE_GAME.getMessage());
    }

    public static void outputEnterBridgeSize() {
        System.out.println(OutputMessage.OUTPUT_ENTER_BRIDGE_SIZE.getMessage());
    }

    public static void outputChooseMovePosition() {
        System.out.println(OutputMessage.askMovePosition());
    }

    public static void outputChooseRestartOrQuit() {
        System.out.println(OutputMessage.chooseRestartOrQuit());
    }

    public void outputException(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printMap(List<String> Bridge, List<Boolean> userMove) {
        System.out.println(OutputMessage.bridgeResultTable(Bridge, userMove, Answer.Up.getAnswer()));
        System.out.println(OutputMessage.bridgeResultTable(Bridge, userMove, Answer.Down.getAnswer()));
        System.out.println();
    }

    public void printResultMap(List<String> Bridge, List<Boolean> UserMove) {
        System.out.println(OutputMessage.OUTPUT_FINAL_BRIDGE_GAME_RESULT.getMessage());
        printMap(Bridge, UserMove);
    }

    public void printResult(boolean gameResult, int tryTimes) {
        System.out.println(OutputMessage.gameResult(gameResult));
        System.out.println(OutputMessage.totalTryTimes(tryTimes));
    }

}
