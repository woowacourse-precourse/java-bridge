package bridge.view;

import bridge.domain.GameRound;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_COMMAND_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    private static final String OPEN_PARENTHESIS = "[ ";
    private static final String CLOSE_PARENTHESIS = " ]";
    private static final String MIDDLE_PARENTHESIS = " | ";

    public void printInputBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
    }

    public void printMoveCommand() {
        System.out.println(MOVE_COMMAND_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameRound gameRound) {
        List<List<String>> playedBridge = gameRound.getPlayedBridge();
        for (int i = 0; i < playedBridge.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            List<String> bridge = playedBridge.get(i);

            stringBuilder.append(OPEN_PARENTHESIS);
            makeBridgeResult(bridge, stringBuilder);
            stringBuilder.append(CLOSE_PARENTHESIS);

            System.out.println(stringBuilder);
        }
    }

    private void makeBridgeResult(List<String> bridge, StringBuilder stringBuilder) {
        for (int i = 0; i < bridge.size(); i++) {
            stringBuilder.append(bridge.get(i)).append(MIDDLE_PARENTHESIS);
        }
        stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length()+1);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
