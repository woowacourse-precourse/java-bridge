package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.Player;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final static String START_OF_BRIDGE = "[";
    private final static String END_OF_BRIDGE = "]";
    private final static String SEPARATOR_OF_BRIDGE = "|";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        Bridge bridge = bridgeGame.getBridge();
        Player player = bridgeGame.getPlayer();

        Bridge upBridge = bridge.getUpBridge();
        Bridge downBridge = bridge.getDownBridge();

        System.out.println(createBridgeString(upBridge, player));
        System.out.println(createBridgeString(downBridge, player));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private String createBridgeString(Bridge bridge, Player player) {
        StringBuilder bridgeStringBuilder = new StringBuilder();
        bridgeStringBuilder.append(START_OF_BRIDGE);
        for (int movedPosition = 0; movedPosition < player.getMovingPosition(); movedPosition++) {
            String mapShape = getBridgeBlock(bridge, player, movedPosition);
            bridgeStringBuilder.append(mapShape).append(SEPARATOR_OF_BRIDGE);
        }
        bridgeStringBuilder.deleteCharAt(bridgeStringBuilder.length() - 1);
        bridgeStringBuilder.append(END_OF_BRIDGE);
        return bridgeStringBuilder.toString();
    }

    private String getBridgeBlock(Bridge bridge, Player player, int position) {
        if (isBridge(bridge, position)) {
            String movingResult = player.getMovedResultByPosition(position);
            return String.format(" %s ", movingResult);
        }
        return "   ";
    }


    private boolean isBridge(Bridge bridge, int position) {
        String bridgeShape = bridge.getBridgeShapeByPosition(position);
        return !bridgeShape.equals(" ");
    }
}
