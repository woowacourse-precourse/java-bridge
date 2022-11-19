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

    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";

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
        String upBridge = toPrintFormat(bridgeGame, BridgeUnit.UP);
        String downBridge = toPrintFormat(bridgeGame, BridgeUnit.DOWN);
        return String.format("[%s]\n[%s]", upBridge, downBridge);
    }

    private String toPrintFormat(BridgeGame bridgeGame, BridgeUnit bridgeUnit) {
        List<String> results = new ArrayList<>();
        bridgeGame.getGameMap().stream()
                .map(mapUnit -> getFormat(mapUnit, bridgeUnit))
                .forEach(results::add);
        return String.join("|", results);
    }

    private String getFormat(MapUnit unit, BridgeUnit bridgeUnit) {
        if (bridgeUnit.equals(unit.getBridgeUnit())) {
            return String.format(" %s ", getSign(unit.isSuccess()));
        }
        return "   ";
    }

    private String getSign(boolean success) {
        if (success) {
            return "O";
        }
        return "X";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, GameStatus status) {
        System.out.println("게임 최종 결과");
        printMap(bridgeGame);
        System.out.println(String.format("게임 성공 여부: %s", status.getStatus()));
        System.out.println(String.format("총 시도 횟수: %d", bridgeGame.getAttempt()));
    }
}
