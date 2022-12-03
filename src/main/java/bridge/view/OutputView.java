package bridge.view;

import bridge.domain.UserPath;
import bridge.enums.OutputMessage;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 게임 시작 메시지를 출력한다.
     */
    public void printStart() {
        System.out.println(OutputMessage.GAME_START_MESSAGE.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upperCell, List<String> lowerCell) {
        System.out.println("[ " + String.join(" | ", upperCell) + " ]");
        System.out.println("[ " + String.join(" | ", lowerCell) + " ]");
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(UserPath userPath, Integer retryCnt, String gameResultMessage) {
        System.out.println(OutputMessage.FINAL_GAME_RESULT_MESSAGE.getMessage());
        printMap(userPath.getUpperPath(), userPath.getLowerPath());
        System.out.println(OutputMessage.GAME_STATUS_MESSAGE.getMessage() + gameResultMessage);
        System.out.println(OutputMessage.TOTAL_ATTEMPTS_MESSAGE.getMessage() + retryCnt);
    }
}
