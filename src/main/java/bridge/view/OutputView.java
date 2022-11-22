package bridge.view;

import bridge.enums.Answer;
import bridge.enums.OutputMessage;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void outputGameStart() {
        System.out.println(OutputMessage.OUTPUT_START_BRIDGE_GAME.getMessage());
    }

    public void outputEnterBridgeSize() {
        System.out.println(OutputMessage.OUTPUT_ENTER_BRIDGE_SIZE.getMessage());
    }

    public void outputChooseMovePosition() {
        System.out.println(OutputMessage.askMovePosition());
    }

    public void outputChooseRestartOrQuit() {
        System.out.println(OutputMessage.chooseRestartOrQuit());
    }

    public void outputException(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> Bridge, List<Boolean> userMove) {
        System.out.println(OutputMessage.bridgeResultTable(Bridge, userMove, Answer.Up.getAnswer()));
        System.out.println(OutputMessage.bridgeResultTable(Bridge, userMove, Answer.Down.getAnswer()));
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> Bridge, List<Boolean> UserMove, boolean gameResult, int tryTimes) {
        System.out.println(OutputMessage.OUTPUT_FINAL_BRIDGE_GAME_RESULT.getMessage());
        printMap(Bridge, UserMove);
        System.out.println(OutputMessage.gameResult(gameResult));
        System.out.println(OutputMessage.totalTryTimes(tryTimes));
    }
}
