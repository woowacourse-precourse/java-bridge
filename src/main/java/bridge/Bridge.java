package bridge;

import java.util.List;

public class Bridge {
    private List<String> bridge;
    private Player player;
    private BridgeMaker bridgeMaker;
    private static final String EMPTY_CELL = "   ";
    private static final String CORRECT_CELL = " O ";
    private static final String INCORRECT_CELL = " X ";
    private static final String SEPARATOR = "|";

    public Bridge(int size, Player player) {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(size);
        this.player = player;
    }

    /**
     * 플레이어와 브릿지 게임의 맵을 비교하여 결과를 스트링으로 반환하는 메서드
     * @return String으로 표현된 맵 (플레이어 상태에 따른)
     */
    @Override
    public String toString() {
        StringBuilder top = new StringBuilder("[");
        StringBuilder bottom = new StringBuilder("[");

        for (int i = 0; i < player.getPosition(); ++i) {
            top.append(getTopCell(i));
            bottom.append(getBottomCell(i));
            if (i != player.getIndex()) {
                top.append(SEPARATOR);
                bottom.append(SEPARATOR);
            }
        }
        top.append("]\n");
        bottom.append("]\n");
        return top.toString() + bottom.toString();
    }

    private String getTopCell(int index) {
        if (index < player.getIndex()) {
            if (bridge.get(index).equals(BridgeGame.CMD_UP)) {
                return CORRECT_CELL;
            }
        }
        if (index == player.getIndex()) {
            if (bridge.get(index).equals(BridgeGame.CMD_UP) && bridge.get(index).equals(player.getCommand())) {
                return CORRECT_CELL;
            }
            if (player.getCommand().equals(BridgeGame.CMD_UP)) {
                return INCORRECT_CELL;
            }
        }
        return EMPTY_CELL;
    }

    private String getBottomCell(int index) {
        if (index < player.getIndex()) {
            if (bridge.get(index).equals(BridgeGame.CMD_DOWN)) {
                return CORRECT_CELL;
            }
        }
        if (index == player.getIndex()) {
            if (bridge.get(index).equals(BridgeGame.CMD_DOWN) && bridge.get(index).equals(player.getCommand())) {
                return CORRECT_CELL;
            }
            if (player.getCommand().equals(BridgeGame.CMD_DOWN)) {
                return INCORRECT_CELL;
            }
        }
        return EMPTY_CELL;
    }

    public String get(int index) {
        return bridge.get(index);
    }

    public int size() {
        return bridge.size();
    }
}
