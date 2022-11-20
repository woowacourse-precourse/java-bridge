package bridge;

import java.util.List;

public class Bridge {
    private enum Line {
        TOP, BOTTOM;
    }

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
     *
     * @return String으로 표현된 맵 (플레이어 상태에 따른)
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(buildBridgeLine(Line.TOP).append("\n"));
        builder.append(buildBridgeLine(Line.BOTTOM).append("\n"));

        return builder.toString();
    }

    private StringBuilder buildBridgeLine(Line flag) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < player.getPosition(); ++i) {
            builder.append(getCell(flag, i));
            if (i != player.getIndex()) {
                builder.append(SEPARATOR);
            }
        }
        appendBracketBothSide(builder);

        return builder;
    }

    private String getCell(Line flag, int index) {
        if (index < player.getIndex() && isSameLine(flag, bridge.get(index))) {
            return CORRECT_CELL;
        }
        if (index == player.getIndex() && isSameLine(flag, player.getCommand())) {
            if (player.getCommand().equals(bridge.get(index))) {
                return CORRECT_CELL;
            }
            return INCORRECT_CELL;
        }
        return EMPTY_CELL;
    }

    private boolean isSameLine(Line flag, String command) {
        if (flag == Line.TOP && command.equals(BridgeGame.CMD_UP)
                || flag == Line.BOTTOM && command.equals(BridgeGame.CMD_DOWN)) {
            return true;
        }
        return false;
    }

    private void appendBracketBothSide(StringBuilder builder) {
        builder.insert(0, "[");
        builder.append("]");
    }

    public String get(int index) {
        return bridge.get(index);
    }

    public int size() {
        return bridge.size();
    }
}
