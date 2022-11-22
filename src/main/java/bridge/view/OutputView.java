package bridge.view;

import static bridge.constant.BridgeMessage.BRIDGE_GAME_FAIL_MESSAGE;
import static bridge.constant.BridgeMessage.BRIDGE_GAME_IS_COMPLETED_MESSAGE;
import static bridge.constant.BridgeMessage.BRIDGE_GAME_OVER_MESSAGE;
import static bridge.constant.BridgeMessage.BRIDGE_GAME_SUCCESS_MESSAGE;
import static bridge.constant.BridgeMessage.BRIDGE_GAME_TOTAL_COUNT_MESSAGE;
import static bridge.constant.BridgeMessage.GAME_START_MESSAGE;
import static bridge.constant.BridgeMessage.MOVE_BRIDGE_MESSAGE;
import static bridge.constant.BridgeMessage.RETRY_BRIDGE_GAME_MESSAGE;

import bridge.domain.Result;
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
    public void printMap(Result result) {
        System.out.println(result.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<Result> crossResults, boolean isCleared, int totalGameCount) {
        System.out.println(BRIDGE_GAME_OVER_MESSAGE);
        crossResults.forEach(System.out::println);
        if (isCleared) {
            System.out.println(BRIDGE_GAME_IS_COMPLETED_MESSAGE + BRIDGE_GAME_SUCCESS_MESSAGE);
            System.out.println(BRIDGE_GAME_TOTAL_COUNT_MESSAGE + totalGameCount);
            return;
        }
        System.out.println(BRIDGE_GAME_IS_COMPLETED_MESSAGE + BRIDGE_GAME_FAIL_MESSAGE);
        System.out.println(BRIDGE_GAME_TOTAL_COUNT_MESSAGE + totalGameCount);
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
