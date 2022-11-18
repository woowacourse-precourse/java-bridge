package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.BridgeTile;
import bridge.domain.Player;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_START_SIGN = "[";
    private static final String BRIDGE_END_SIGN = "]\n";
    private static final String BRIDGE_DIVIDE_SIGN = "|";
    private static final String BRIDGE_TILE_FORMAT = " %s ";
    private static final String BRIDGE_SUCCESS_SIGN = "O";
    private static final String BRIDGE_FAIL_SIGN = "X";
    private static final String BRIDGE_EMPTY_SIGN = " ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge, Player player) {

        StringBuilder stringBuilder = new StringBuilder();

        for (BridgeTile tile : BridgeTile.values()) {
            stringBuilder.append(generateTileMap(player, bridge, tile));
        }

        System.out.println(stringBuilder.toString());
    }

    // todo: refactor -> bridge는 안받고 player와 승리여부로 출력하는 방법이 있을 것 같음...!!! isPassedPosition도 지울 수 있이면 지우는거로
    private String generateTileMap(Player player, Bridge bridge, BridgeTile tile) {
        StringBuilder bridgeMapBuilder = new StringBuilder();
        bridgeMapBuilder.append(BRIDGE_START_SIGN);

        int index = 0;
        while (!player.isPassedPosition(index)) {
            if (bridge.checkBridgeTileAt(index, tile)) {
                bridgeMapBuilder.append(String.format(BRIDGE_TILE_FORMAT, BRIDGE_SUCCESS_SIGN));
                bridgeMapBuilder.append(BRIDGE_DIVIDE_SIGN);
                index++;
                continue;
            }
            if (bridge.checkBridgeTileAt(index, player.getMovingLogOf(index))) {
                bridgeMapBuilder.append(String.format(BRIDGE_TILE_FORMAT, BRIDGE_EMPTY_SIGN));
                bridgeMapBuilder.append(BRIDGE_DIVIDE_SIGN);
                index++;
                continue;
            }
            bridgeMapBuilder.append(String.format(BRIDGE_TILE_FORMAT, BRIDGE_FAIL_SIGN));
            bridgeMapBuilder.append(BRIDGE_DIVIDE_SIGN);
            index++;
        }
        bridgeMapBuilder.deleteCharAt(bridgeMapBuilder.length()-1);
        bridgeMapBuilder.append(BRIDGE_END_SIGN);
        return bridgeMapBuilder.toString();
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
