package bridge.view;

import static bridge.domain.UpDownBridge.addCenterBar;
import static bridge.domain.UpDownBridge.getDownBridge;
import static bridge.domain.UpDownBridge.getUpBridge;
import static bridge.domain.UpDownBridge.makeUpDownBridge;
import static bridge.controller.BridgeGameController.getCount;
import static bridge.controller.BridgeGameController.getStatus;

import bridge.Message;

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

    public static void printProgress() {
        System.out.println(Message.LEFT_BAR.getMessage() + addCenterBar(getUpBridge()) + Message.RIGHT_BAR.getMessage());
        System.out.println(Message.LEFT_BAR.getMessage() + addCenterBar(getDownBridge()) + Message.RIGHT_BAR.getMessage());
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
        System.out.println(getSuccessOrFailure());
        printTotalCount(getCount());
    }

    private static String getSuccessOrFailure() {
        if (getStatus()) {
            return Message.GAME_SUCCESS.getMessage();
        }
        return Message.GAME_FAILURE.getMessage();
    }

    public static void printTotalCount(int count) {
        System.out.print(Message.TRY_ATTEMPTS.getMessage() + count);
    }
}
