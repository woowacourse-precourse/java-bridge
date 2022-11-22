package bridge;

import bridge.domain.Key;
import bridge.domain.Player;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String SUCCESS = " O ";
    private static final String FAIL = " X ";
    private static final String WHITESPACE = "   ";
    private static final String SEPARATOR = "|";

    private List<String> bridge;
    private Player player;

    public BridgeGame(List<String> bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String command) {
        return player.move(bridge, command);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player.retry();
    }

    public boolean isGameSuccess(){
        return bridge.size() == player.getPosition();
    }

    public int getTryCount(){
        return player.getTryCount();
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        String upPart = toStringEachPart(Key.UP);
        String downPart = toStringEachPart(Key.DOWN);

        ret.append(upPart);
        ret.append(downPart);

        return ret.toString();
    }


    private String toStringEachPart(Key key) {
        StringBuilder ret = new StringBuilder("[");

        ret.append(getSuccessOrWhitespace(key));
        if (!player.isLastCrossSuccess()) {
            ret.append(getFailOrWhitespace(key));
        }

        ret.append("]\n");
        return ret.toString();
    }

    private String getSuccessOrWhitespace(Key key) {
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < player.getPosition(); i++) {
            ret.append(compareBridgeIndexWithKey(i, key, SUCCESS));
            ret.append(getSeparator(i, player.getPosition() - 1));
        }

        return ret.toString();
    }

    private String compareBridgeIndexWithKey(int index, Key key, String expected) {
        if (bridge.get(index).equals(key.command())) {
            return expected;
        }
        return WHITESPACE;
    }

    private String getSeparator(int index, int expected){
        if (index != expected)
            return SEPARATOR;
        return "";
    }

    private String getFailOrWhitespace(Key key) {
        StringBuilder ret = new StringBuilder(getSeparator(player.getPosition(), 0));

        String addString = FAIL;
        if (bridge.get(player.getPosition()).equals(key.command())) {
            addString = WHITESPACE;
        }

        ret.append(addString);
        return ret.toString();
    }
}
