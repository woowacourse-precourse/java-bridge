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
        printMoveProgress();
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(Message.GAME_RESULT.getMessage());
        printMoveProgress();
        System.out.println();
        printSuccessOrFailure();
        printTotalCount(getCount());
    }

    /**
     * 게임 시작 후 출력할 메시지를 가지는 메서드들
     */
    public void printStartGame() {
        System.out.println(Message.START_GAME.getMessage());
    }

    public void printInputSize() {
        System.out.println(Message.INPUT_SIZE.getMessage());
    }

    public void printInputDirection() {
        System.out.println(Message.SELECT_DIRECTION.getMessage());
    }

    public void printInputRestart() {
        System.out.println(Message.ASK_RESTART.getMessage());
    }

    private static void printMoveProgress() {
        printUpBridge(joinCenterBar(getUpBridge()));
        printDownBridge(joinCenterBar(getDownBridge()));
    }

    private static void printUpBridge(String upBridge) {
        System.out.println(Message.LEFT_BAR.getMessage() + upBridge + Message.RIGHT_BAR.getMessage());
    }

    private static void printDownBridge(String downBridge) {
        System.out.println(Message.LEFT_BAR.getMessage() + downBridge + Message.RIGHT_BAR.getMessage());
    }

    private static String joinCenterBar(List<String> bridge) {
        return String.join(Message.CENTER_BAR.getMessage(), bridge);
    }

    private static void printSuccessOrFailure() {
        if (getStatus()) {
            System.out.println(Message.GAME_SUCCESS.getMessage());
        }
        if (!getStatus()) {
            System.out.println(Message.GAME_FAILURE.getMessage());
        }
    }

    private static void printTotalCount(int count) {
        System.out.print(Message.TRY_ATTEMPTS.getMessage() + count);
    }
}
