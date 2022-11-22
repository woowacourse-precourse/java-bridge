package bridge.view;

import bridge.model.GameStatus;
import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String FORMAT_MAP_START = "[ ";
    private static final String FORMAT_MAP_DIVISION = " | ";
    private static final String FORMAT_MAP_END = " ]";
    private static final String MESSAGE_START = "다리 건너기 게임을 시작합니다.\n";
    private static final String MESSAGE_RESULT = "\n최종 게임 결과";
    private static final String MESSAGE_SUCCESS = "\n게임 성공 여부: %s\n";
    private static final String MESSAGE_COUNT = "총 시도한 횟수: %d\n";

    public void printStartMessage() {
        System.out.println(MESSAGE_START);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> gameMap) {
        for (List<String> gameBridge : gameMap) {
            String playerMovingMap = toBridgeFormat(gameBridge);
            System.out.println(playerMovingMap);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> gameMap, GameStatus status, int gameCount) {
        System.out.println(MESSAGE_RESULT);
        for (List<String> gameBridge : gameMap) {
            System.out.println(toBridgeFormat(gameBridge));
        }
        System.out.printf(MESSAGE_SUCCESS, status.getDetail());
        System.out.printf(MESSAGE_COUNT, gameCount);
    }

    private String toBridgeFormat(List<String> bridge) {
        StringJoiner stringJoiner = new StringJoiner(FORMAT_MAP_DIVISION, FORMAT_MAP_START, FORMAT_MAP_END);
        for (String step : bridge) {
            stringJoiner.add(step);
        }
        return stringJoiner.toString();
    }
}
