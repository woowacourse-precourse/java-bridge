package bridge.view;

import static bridge.domain.UpDownBridge.getDownBridge;
import static bridge.domain.UpDownBridge.getUpBridge;
import static bridge.domain.UpDownBridge.makeUpDownBridge;
import static bridge.controller.BridgeGameController.getCount;
import static bridge.controller.BridgeGameController.getStatus;

import bridge.messages.Message;

import java.util.List;

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
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(Message.GAME_RESULT.getMessage());
        printProgress();
        System.out.println();
        printSuccessOrFailure();
        printTotalCount(getCount());
    }

    private static void printProgress() {
        System.out.println(Message.LEFT_BAR.getMessage() + printCenterBar(getUpBridge()) + Message.RIGHT_BAR.getMessage());
        System.out.println(Message.LEFT_BAR.getMessage() + printCenterBar(getDownBridge()) + Message.RIGHT_BAR.getMessage());
    }

    private static String printCenterBar(List<String> toAddBridge) {
        return String.join(Message.CENTER_BAR.getMessage(), toAddBridge);
    }

    private static void printSuccessOrFailure() {
        if (getStatus()) {
            System.out.println(Message.GAME_SUCCESS.getMessage());
        } else if (!getStatus()) {
            System.out.println(Message.GAME_FAILURE.getMessage());
        }
    }

    private static void printTotalCount(int count) {
        System.out.print(Message.TRY_ATTEMPTS.getMessage() + count);
    }
}
