package bridge.view.output;

import bridge.domain.BridgeState;
import bridge.domain.Constants;

import static bridge.domain.Constants.CLOSE_SQUARE_BRACKETS;
import static bridge.domain.Constants.OPEN_SQUARE_BRACKETS;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String NOTIFY_GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String NOTIFY_INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String NOTIFY_INPUT_ARROW = "이동할 칸을 선택해주세요.";
    private static final String NOTIFY_INPUT_RETRY_OR_NOT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public void printGameStartNotification() {
        System.out.println(NOTIFY_GAME_START);
    }

    public void printInputBridgeLengthNotification() {
        System.out.println(NOTIFY_INPUT_BRIDGE_LENGTH);
    }

    public void printInputArrow() {
        System.out.println(NOTIFY_INPUT_ARROW);
    }

    public void printInputRetryOrNot() {
        System.out.println(NOTIFY_INPUT_RETRY_OR_NOT);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeState bridgeState) {
        System.out.println(OPEN_SQUARE_BRACKETS + bridgeState.getUpBridgeState() + CLOSE_SQUARE_BRACKETS);
        System.out.println(OPEN_SQUARE_BRACKETS + bridgeState.getDownBridgeState() + CLOSE_SQUARE_BRACKETS);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
