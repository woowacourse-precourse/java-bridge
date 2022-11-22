package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private final List<String> bridge;
    private ArrayList<String> playerMove;
    private int tryCount =0;
    private ArrayList<String> oriPlayerMove;
    private int moveCount =0;
    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public ArrayList<String> getOriPlayerMove() {
        return oriPlayerMove;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public ArrayList<String> getPlayerMove() {
        return playerMove;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public List<String> move(String input) {
        oriPlayerMove.add(input);
        if(input.equals(bridge.get(moveCount))){
            playerMove.add("O");
            moveCount++;
            return playerMove;
        }
        playerMove.add("X");
        return playerMove;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        playerMove.clear();
        tryCount++;
        oriPlayerMove.clear();
        moveCount = 0;
    }
}
