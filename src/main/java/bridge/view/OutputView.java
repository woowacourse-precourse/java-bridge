package bridge.view;

import static bridge.constant.Movement.DOWN;
import static bridge.constant.Movement.UP;
import static bridge.constant.Output.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static String upBridge = "[]";
    private static String downBridge = "[]";

    public void setUpBridge() {
        upBridge = "[]";
    }

    public void setDownBridge() {
        downBridge = "[]";
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
            upBridge = upBridge.replace("]", "|   ]");
            downBridge = downBridge.replace("]", "| O ]");
            printUpAndDownBridge();
        }
    }

    private void succeedUpMovement(String movement) {
        if (isU(movement)) {
            upBridge = upBridge.replace("]", "| O ]");
            downBridge = downBridge.replace("]", "|   ]");
            printUpAndDownBridge();
        }
    }

    private void isFailure(String movement) {
        failUpMovement(movement);
        failDownMovement(movement);
    }

    private void failDownMovement(String movement) {
        if (isD(movement)) {
            upBridge = upBridge.replace("]", "|   ]");
            downBridge = downBridge.replace("]", "| X ]");
            printUpAndDownBridge();
        }
    }

    private void failUpMovement(String movement) {
        if (isU(movement)) {
            upBridge = upBridge.replace("]", "| X ]");
            downBridge = downBridge.replace("]", "|   ]");
            printUpAndDownBridge();
        }
    }

    private void printUpAndDownBridge() {
        upBridge = upBridge.replace("[|", "[");
        downBridge = downBridge.replace("[|", "[");
        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    private boolean isU(String movement) {
        return movement.equals(UP.getUpAndDownSide());
    }

    private boolean isD(String movement) {
        return movement.equals(DOWN.getUpAndDownSide());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {

    }
}
