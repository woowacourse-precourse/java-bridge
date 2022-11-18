package bridge;

import static bridge.UpDownBridge.downBridge;
import static bridge.UpDownBridge.makeUpDownBridge;
import static bridge.UpDownBridge.upBridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String inputDirection, String moveResult) {
        makeUpDownBridge(inputDirection, moveResult);
        printProgress();
    }

    public static void printProgress() {
        System.out.println(Message.LEFT_BAR.getMessage() + upBridge + Message.RIGHT_BAR.getMessage());
        System.out.println(Message.LEFT_BAR.getMessage() + downBridge + Message.RIGHT_BAR.getMessage());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(boolean keepGoing) {
        System.out.println(Message.GAME_RESULT.getMessage());
    }

    public static void printTotalCount(int count) {
    }
}
