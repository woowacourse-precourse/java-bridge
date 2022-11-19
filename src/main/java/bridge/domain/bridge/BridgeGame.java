package bridge.domain.bridge;

import bridge.domain.Correct;
import bridge.domain.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<List<String>> bridgeMap;
    private int turn;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.turn = 0;
        bridgeMap = new ArrayList<>() {
            {
                add(new ArrayList<>());
                add(new ArrayList<>());
            }
        };
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        boolean isCorrect = checkValue(direction);
        addMap(direction, isCorrect);
        if (isTurnOutOfRange() || !isCorrect) {
            return false;
        }
        this.turn ++;
        return true;
    }

    public List<List<String>> getBridgeMap() {
        return this.bridgeMap;
    }

    private boolean isTurnOutOfRange() {
        return this.turn == this.bridge.size();
    }

    private boolean checkValue(String direction) {
        String answer = this.bridge.get(this.turn);
        return direction.equals(answer);
    }

    private void addMap(String direction, boolean isCorrect) {
        int index = Direction.getBySymbol(direction).getKey();
        int otherIndex = getOtherIndex(index);
        String symbol = Correct.getByCorrect(isCorrect).getSymbol();

        bridgeMap.get(index).add(symbol);
        bridgeMap.get(otherIndex).add(" ");
    }

    private int getOtherIndex(int index) {
        List<Integer> indexes = new ArrayList<>(List.of(0, 1));
        indexes.remove(index);
        return indexes.get(0);
    }

    public boolean checkWin() {
        return this.turn == (this.bridge.size() - 1);
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
