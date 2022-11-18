package bridge.view;

import bridge.BridgeGameResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_START = "[";
    private static final String BRIDGE_END = " ]";
    private static final String BRIDGE_DIVIDE = " |";
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(BridgeGameResult bridgeGameResult) {
        List<String> upStates = bridgeGameResult.getUpStates();
        List<String> downStates = bridgeGameResult.getDownStates();

        System.out.println(format(upStates));
        System.out.println(format(downStates));
    }

    private String format(List<String> states) {
        StringBuilder result = new StringBuilder();
        result.append(BRIDGE_START);

        for (int count = 0; count < states.size(); count++) {
            String state = " " + states.get(count);
            if (count != 0) {
                result.append(BRIDGE_DIVIDE);
            }
            result.append(state);
        }

        result.append(BRIDGE_END);
        return result.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printGameStartMsg() {
        System.out.println(GAME_START);
    }

    public void printBridgeSizeMsg() {
        System.out.println(separateLine() + BRIDGE_SIZE);
    }

    public void printMovingMsg() {
        System.out.println(separateLine() + MOVING);
    }

    public void printGameCommandMsg() {
        System.out.println(separateLine() + GAME_COMMAND);
    }

    private String separateLine() {
        return System.lineSeparator();
    }
}
