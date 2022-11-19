package bridge.view;

import bridge.domain.CompareBridge;
import bridge.domain.Player;
import bridge.domain.enums.BridgePanel;
import bridge.view.enums.MapType;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder up;
    private StringBuilder down;

    public OutputView() {
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Player player, List<String> bridge, CompareBridge compareBridge) {
        up = new StringBuilder(MapType.START.getType());
        down = new StringBuilder(MapType.START.getType());
        for (int index = 0; index <= player.informMovingIndex(); index++) {
            makeUpMap(player, bridge, compareBridge);
            makeDownMap(player, bridge, compareBridge);
        }
        System.out.println(up);
        System.out.println(down);
    }

    public void makeUpMap(Player player, List<String> bridge, CompareBridge compareBridge) {
        if (bridge.get(player.informMovingIndex()).equals(BridgePanel.UP_PANEL.getPosition())) {
            up.append(compareBridge.stepping(player, bridge)).append(MapType.END.getType());
            down.append(MapType.EMPTY).append(MapType.END.getType());
        }
        insertDivision(up);
        insertDivision(down);
    }

    public void makeDownMap(Player player, List<String> bridge, CompareBridge compareBridge) {
        if (bridge.get(player.informMovingIndex()).equals(BridgePanel.DOWN_PANEL.getPosition())) {
            down.append(compareBridge.stepping(player, bridge)).append(MapType.END.getType());
            up.append(MapType.EMPTY).append(MapType.END.getType());
        }
        insertDivision(up);
        insertDivision(down);
    }

    public void insertDivision(StringBuilder builder) {
        for (int index = 0; index < builder.length() - 1; index++) {
            if (String.valueOf(builder.charAt(index)).equals(MapType.END.getType())) {
                builder.replace(index, index + 1, MapType.DIVISION.getType());
            }
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
