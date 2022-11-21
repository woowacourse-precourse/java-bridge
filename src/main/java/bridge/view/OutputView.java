package bridge.view;

import bridge.domain.BridgeState;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeState bridgeState) {
        String upBridge = bridgeState.upBridgeGenerate();
        String downBridge = bridgeState.downBridgeGenerate();

        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeState bridgeState, int count, boolean success) {
        String upBridge = bridgeState.upBridgeGenerate();
        String downBridge = bridgeState.downBridgeGenerate();

        printLastGameResult();

        System.out.println(upBridge);
        System.out.println(downBridge);

        gameSuccess(success);
        printAllTryCount(count);
    }

    private void gameSuccess(boolean success) {
        if (success) {
            printGameSuccess();
            return;
        }
        printGameFailure();
    }

    public void printNextLine() {
        System.out.println();
    }

    public void printGameStartMessage() {
        System.out.println(SystemMessage.BRIDGE_GAME_START);
        System.out.println();
    }

    public void printInputBridgeLength() {
        System.out.println(SystemMessage.BRIDGE_LENGTH_INPUT);
    }

    public void printMovementInput() {
        System.out.println(SystemMessage.MOVEMENT_INPUT);
    }

    public void printGameRestartEnd() {
        System.out.println(SystemMessage.GAME_RESTART_END);
    }

    public void printLastGameResult() {
        System.out.println(SystemMessage.LAST_GAME_RESULT);
    }

    public void printGameSuccess() {
        System.out.println();
        System.out.println(SystemMessage.GAME_SUCCESS);
    }

    public void printGameFailure() {
        System.out.println();
        System.out.println(SystemMessage.GAME_FAILURE);
    }

    public void printAllTryCount(int count) {
        System.out.println(SystemMessage.TOTAL_TRY_COUNT + count);
    }
}


