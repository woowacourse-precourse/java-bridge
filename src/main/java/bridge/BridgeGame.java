package bridge;

import static bridge.command.MoveCommand.DOWN;
import static bridge.command.MoveCommand.UP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private List<String> current;
    private int attempt;

    public BridgeGame(List<String> bridge) {
        this.current = new ArrayList<>();
        this.bridge = bridge;
        this.attempt = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        current.add(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        current = new ArrayList<>();
        attempt += 1;
    }

    public boolean isEnd() {
        return bridge.size() == current.size();
    }

    public boolean isStepSuccess() {
        int index = current.size() - 1;
        return current.get(index).equals(bridge.get(index));
    }


    public List<List<String>> getGameResult() {
        List<List<String>> result = new ArrayList<>();
        List<String> upLine = new ArrayList<>();
        List<String> downLine = new ArrayList<>();

        for (int i = 0; i < current.size(); i++) {
            String symbol = setSymbol(i);
            upLine.add(setUpItem(i, symbol));
            downLine.add(setDownItem(i, symbol));
        }
        result.add(upLine);
        result.add(downLine);
        return result;
    }

    private String setUpItem(int index, String symbol) {
        if (current.get(index).equals(UP.ofHotKey())) {
            return symbol;
        }
        return " ";
    }

    private String setDownItem(int index, String symbol) {
        if (current.get(index).equals(DOWN.ofHotKey())) {
            return symbol;
        }
        return " ";
    }

    private String setSymbol(int index) {
        String symbol = "X";
        if (current.get(index).equals(bridge.get(index))) {//symbol결정
            symbol = "O";
        }
        return symbol;
    }

    public int getAttempt() {
        return attempt;
    }

    public boolean isSuccess() {
        return compareCurrentWithBridge();
    }

    private boolean compareCurrentWithBridge() {
        return bridge.size() == current.size() && Arrays.equals(bridge.toArray(), current.toArray());
    }
}
