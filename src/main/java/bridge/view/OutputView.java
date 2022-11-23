package bridge.view;

import bridge.domain.Bridge;
import bridge.dto.Result;

import static bridge.constant.Movement.DOWN;
import static bridge.constant.Movement.UP;
import static bridge.constant.OutputSentence.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    Bridge bridge;

    public OutputView(Bridge bridge) {
        this.bridge = bridge;
    }

    public void printStart() {
        System.out.println(START_GAME);
    }

    public void printInputBridgeLength() {
        System.out.println(INPUT_BRIDGE_LENGTH);
    }

    public void printSelectMovement() {
        System.out.println(SELECT_MOVEMENT);
    }

    public void printRestartOrQuit() {
        System.out.println(INPUT_RESTART_OR_QUIT);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(boolean result, String movement) {
        if (result) {
            isSuccess(movement);
        }
        if (!result) {
            isFailure(movement);
        }
    }

    private void isSuccess(String movement) {
        succeedUpMovement(movement);
        succeedDownMovement(movement);
    }

    private void succeedDownMovement(String movement) {
        if (isD(movement)) {
            bridge.succeedDownMovement();
            printUpAndDownBridge();
        }
    }

    private void succeedUpMovement(String movement) {
        if (isU(movement)) {
            bridge.succeedUpMovement();
            printUpAndDownBridge();
        }
    }

    private void isFailure(String movement) {
        failUpMovement(movement);
        failDownMovement(movement);
    }

    private void failDownMovement(String movement) {
        if (isD(movement)) {
            bridge.failDownMovement();
            printUpAndDownBridge();
        }
    }

    private void failUpMovement(String movement) {
        if (isU(movement)) {
            bridge.failUpMovement();
            printUpAndDownBridge();
        }
    }

    private void printUpAndDownBridge() {
        bridge.replaceUnnecessaryBridge();
        System.out.println(bridge.getUpBridge());
        System.out.println(bridge.getDownBridge() + "\n");
    }

    private boolean isU(String movement) {
        return movement.equals(UP.getUpAndDownMovement());
    }

    private boolean isD(String movement) {
        return movement.equals(DOWN.getUpAndDownMovement());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result) {
        System.out.println(GAME_RESULT);
        System.out.println(bridge.getUpBridge());
        System.out.println(bridge.getDownBridge());
        System.out.println(SUCCESS_OR_FAILURE + result.getGameResult());
        System.out.println(TOTAL_ATTEMPTS + result.getAttempt());
    }
}
