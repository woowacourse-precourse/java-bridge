package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeUnit;
import bridge.domain.MapUnit;

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
    }

    private String getMap(BridgeGame bridgeGame) {
        String upBridge = toPrintFormat(bridgeGame, BridgeUnit.UP);
        String downBridge = toPrintFormat(bridgeGame, BridgeUnit.DOWN);
        return String.format("%s\n%s", upBridge, downBridge);
    }

    private String toPrintFormat(BridgeGame bridgeGame, BridgeUnit bridgeUnit) {
        StringBuilder sb = new StringBuilder();
        bridgeGame.getGameMap().stream()
                .map(mapUnit -> getFormat(mapUnit, bridgeUnit))
                .forEach(sb::append);
        return sb.toString();
    }

    private String getFormat(MapUnit unit, BridgeUnit bridgeUnit) {
        if (bridgeUnit.equals(unit.getBridgeUnit())) {
            return String.format("[%s]", getSign(unit.isSuccess()));
        }
        return "[ ]";
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
    public void printResult() {
    }
}
