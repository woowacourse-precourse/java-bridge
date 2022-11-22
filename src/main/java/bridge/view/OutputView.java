package bridge.view;

import static bridge.constant.BridgeMessage.GAME_START_MESSAGE;
import static bridge.constant.BridgeMessage.MOVE_BRIDGE_MESSAGE;
import static bridge.constant.BridgeMessage.RETRY_BRIDGE_GAME_MESSAGE;

import bridge.domain.Result;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result) {
        System.out.println(result.toString());
    }

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printMoveDirectionSelectMessage() {
        System.out.println(MOVE_BRIDGE_MESSAGE);
    }

    public void printRetryGameMessage() {
        System.out.println(RETRY_BRIDGE_GAME_MESSAGE);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
