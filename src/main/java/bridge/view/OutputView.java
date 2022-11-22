package bridge.view;

import static bridge.Moving.DOWN;
import static bridge.Moving.UP;
import static bridge.constant.BridgeSymbol.BRIDGE_DELIMITER;
import static bridge.constant.BridgeSymbol.BRIDGE_END;
import static bridge.constant.BridgeSymbol.BRIDGE_START;
import static bridge.constant.Message.GAME_START;
import static bridge.constant.Message.INPUT_BRIDGE_SIZE;
import static bridge.constant.Message.INPUT_GAME_COMMAND;
import static bridge.constant.Message.INPUT_MOVING;

import bridge.Moving;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Map<Moving, List<String>> map) {
        printRow(map.get(UP));
        printRow(map.get(DOWN));
    }

    private void printRow(List<String> row) {
        System.out.println(BRIDGE_START + String.join(BRIDGE_DELIMITER, row) + BRIDGE_END);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printGameStartMessage() {
        System.out.println(GAME_START);
    }

    public void printBridgeSizeInputMessage() {
        System.out.println(INPUT_BRIDGE_SIZE);
    }

    public void printMovingInputMessage() {
        System.out.println(INPUT_MOVING);
    }

    public void printGameCommandInputMessage() {
        System.out.println(INPUT_GAME_COMMAND);
    }
}
