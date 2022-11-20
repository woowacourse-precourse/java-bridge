package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeUnit;
import bridge.domain.GameStatus;
import bridge.domain.MapUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String MAP_UNIT = "[%s]\n[%s]";
    private static final String BRIDGE_UNIT_DELIMITER = "|";
    private static final String SYMBOL = " %s ";
    private static final String BLANK = "   ";
    private static final String SUCCESS = "O";
    private static final String FAIL = "X";
    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String RESULT_WHETHER_SUCCESS = "게임 성공 여부: %s";
    private static final String TOTAL_ATTEMPT = "총 시도한 횟수: %d";
    private static final String ERROR_FORMAT = "[ERROR] %s";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        System.out.println(getMap(bridgeGame));
        System.out.println();
    }

    private String getMap(BridgeGame bridgeGame) {
        String upSide = toPrintFormat(bridgeGame, BridgeUnit.UP);
        String downSide = toPrintFormat(bridgeGame, BridgeUnit.DOWN);
        return String.format(MAP_UNIT, upSide, downSide);
    }

    private String toPrintFormat(BridgeGame bridgeGame, BridgeUnit bridgeUnit) {
        List<String> results = new ArrayList<>();
        bridgeGame.getGameProgress().stream()
                .map(mapUnit -> getFormat(mapUnit, bridgeUnit))
                .forEach(results::add);
        return String.join(BRIDGE_UNIT_DELIMITER, results);
    }

    private String getFormat(MapUnit unit, BridgeUnit bridgeUnit) {
        if (bridgeUnit.equals(unit.getBridgeUnit())) {
            return String.format(SYMBOL, getSymbol(unit.isSuccess()));
        }
        return BLANK;
    }

    private String getSymbol(boolean success) {
        if (success) {
            return SUCCESS;
        }
        return FAIL;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, GameStatus status) {
        System.out.println(GAME_RESULT);
        printMap(bridgeGame);
        System.out.println(String.format(RESULT_WHETHER_SUCCESS, status.getStatus()));
        System.out.println(String.format(TOTAL_ATTEMPT, bridgeGame.getAttempt()));
    }

    public void printError(String errorMessage) {
        System.out.println(String.format(ERROR_FORMAT, errorMessage));
    }
}
