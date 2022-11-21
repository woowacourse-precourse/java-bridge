package bridge.view;

import dto.Result;

import static bridge.constant.BridgeOutput.*;
import static bridge.constant.GameResult.FAILURE;
import static bridge.constant.GameResult.SUCCESS;
import static bridge.constant.Movement.DOWN;
import static bridge.constant.Movement.UP;
import static bridge.constant.OutputSentence.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static String upBridge = INITIAL_SETTING;
    private static String downBridge = INITIAL_SETTING;

    public void setUpBridge() {
        upBridge = INITIAL_SETTING;
    }

    public void setDownBridge() {
        downBridge = INITIAL_SETTING;
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
            upBridge = upBridge.replace(END_POINT, EMPTY);
            downBridge = downBridge.replace(END_POINT, SUCCESS.getNowCondition());
            printUpAndDownBridge();
        }
    }

    private void succeedUpMovement(String movement) {
        if (isU(movement)) {
            upBridge = upBridge.replace(END_POINT, SUCCESS.getNowCondition());
            downBridge = downBridge.replace(END_POINT, EMPTY);
            printUpAndDownBridge();
        }
    }

    private void isFailure(String movement) {
        failUpMovement(movement);
        failDownMovement(movement);
    }

    private void failDownMovement(String movement) {
        if (isD(movement)) {
            upBridge = upBridge.replace(END_POINT, EMPTY);
            downBridge = downBridge.replace(END_POINT, SUCCESS.getNowCondition());
            printUpAndDownBridge();
        }
    }

    private void failUpMovement(String movement) {
        if (isU(movement)) {
            upBridge = upBridge.replace(END_POINT, FAILURE.getNowCondition());
            downBridge = downBridge.replace(END_POINT, EMPTY);
            printUpAndDownBridge();
        }
    }

    private void printUpAndDownBridge() {
        upBridge = upBridge.replace(CHANGE_POINT, FIRST_POINT);
        downBridge = downBridge.replace(CHANGE_POINT, FIRST_POINT);
        System.out.println(upBridge);
        System.out.println(downBridge + "\n");
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
    public void printResult(Result result) {
        System.out.println(GAME_RESULT);
        System.out.println(upBridge);
        System.out.println(downBridge);
        System.out.println(SUCCESS_OR_FAILURE + result.getGameResult());
        System.out.println(TOTAL_ATTEMPTS + result.getAttempt());
    }
}
