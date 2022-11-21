package bridge.view;

import bridge.domain.bridge.CrossStatus;
import bridge.domain.map.BridgeMap;
import bridge.domain.map.MapSymbol;
import bridge.domain.trycount.TryCount;

import java.util.List;

import static bridge.domain.bridge.CrossStatus.SUCCESS;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String NEW_LINT = "\n";
    private static final String SEPARATOR_REGEX = "\\|";
    private static final String EMPTY_STRING = "";

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.\n";
    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String GAME_STATUS_FORMAT = "게임 성공 여부: %s\n";
    private static final String GAME_SUCCESS = "성공";
    private static final String GAME_FAIL = "실패";
    private static final String GAME_TRY_COUNT_FORMAT = "총 시도한 횟수: %d";
    private static final String EMPTY = "";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final BridgeMap map) {

        System.out.println(mapToString(map));
        System.out.println(EMPTY);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(final TryCount tryCount,
                            final CrossStatus status,
                            final BridgeMap map) {

        System.out.println(FINAL_GAME_RESULT);

        System.out.println(mapToString(map));

        System.out.printf(GAME_STATUS_FORMAT, judgeResult(status));

        System.out.printf(GAME_TRY_COUNT_FORMAT, tryCount.count());
    }

    private String mapToString(BridgeMap map) {
        List<MapSymbol> topLine = map.getTopLine();
        List<MapSymbol> bottomLine = map.getBottomLine();
        return mapLineToString(topLine) + NEW_LINT + mapLineToString(bottomLine);
    }

    private String mapLineToString(List<MapSymbol> line) {
        StringBuilder sb = new StringBuilder();
        for (MapSymbol mapSymbol : line) {
            sb.append(mapSymbol.symbol());
        }
        return sb.toString().replaceFirst(SEPARATOR_REGEX, EMPTY_STRING);
    }

    private String judgeResult(final CrossStatus status) {
        if (status == SUCCESS) {
            return GAME_SUCCESS;
        }
        return GAME_FAIL;
    }

    public void printStartMessage() {
        System.out.println(GAME_START);
    }
}
