package view;

import bridge.BridgeState;
import constants.Message;

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
        System.out.println(bridgeState);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printBridgeSizeInputMessage() {
        System.out.println(Message.GAME_START_MESSAGE);
        System.out.println(Message.BRIDGE_SIZE_INPUT_MESSAGE);
    }

    public void printMovingInputMessage() {
        System.out.println(Message.BRIDGE_MOVING_INPUT_MESSAGE);
    }

    public void printAskToRestart() {
        System.out.println(Message.ASK_TO_RESTART_MESSAGE);
    }

    public static void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
