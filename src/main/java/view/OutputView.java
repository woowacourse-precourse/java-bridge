package view;

import model.bridge.PositionType;
import model.game.ResultType;

import java.util.List;
import java.util.Map;

import static model.bridge.PositionType.D;
import static model.bridge.PositionType.U;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다." + NEW_LINE;
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_CONNECT = " | ";
    private static final String BRIDGE_END = " ]";
    private static final String RESULT_MESSAGE = NEW_LINE + "최종 게임 결과";
    private static final String GAME_STATUS_MESSAGE = NEW_LINE + "게임 성공 여부: ";
    private static final String TOTAL_COUNT_MESSAGE = "총 시도한 횟수: ";
    private static final String ERROR = "[ERROR] ";

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Map<PositionType, List<String>> maps) {
        System.out.println(getPrintMap(maps.get(U)));
        System.out.println(getPrintMap(maps.get(D)));
    }

    private String getPrintMap(List<String> map) {
        StringBuilder builder = new StringBuilder();
        builder.append(BRIDGE_START);
        builder.append(String.join(BRIDGE_CONNECT, map));
        builder.append(BRIDGE_END);
        return builder.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Map<PositionType, List<String>> maps, ResultType result, int count) {
        System.out.println(RESULT_MESSAGE);
        printMap(maps);
        System.out.println(GAME_STATUS_MESSAGE + result.getMessage());
        System.out.println(TOTAL_COUNT_MESSAGE + count);
    }

    public void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(ERROR + exception.getMessage());
    }
}
