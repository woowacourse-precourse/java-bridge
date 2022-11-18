package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int gameCnt = 1;
    private boolean gameSuccess = true;

    public List<String> getBridgeRoad() {
        return bridgeRoad;
    }

    private final List<String> bridgeRoad;
    private final List<String> upMove = new ArrayList<>();
    private final List<String> downMove = new ArrayList<>();

    public List<String> getUpMove() {
        return upMove;
    }

    public List<String> getDownMove() {
        return downMove;
    }

    public BridgeGame(List<String> bridgeRoad) {
        this.bridgeRoad = bridgeRoad;
    }

    public boolean move(String move) {
        boolean chk = true;

        if (move.equals("U"))
            chk = confirmUpMove();

        if (move.equals("D"))
            chk = confirmDownMove();

        return chk;
    }

    public boolean confirmUpMove() {
        int size = upMove.size();
        downMove.add("   ");

        if (bridgeRoad.get(size).equals("U")) {
            upMove.add(" O ");
            return true;
        }
        upMove.add(" X ");
        return false;
    }

    public boolean confirmDownMove() {
        int size = downMove.size();
        upMove.add("   ");

        if (bridgeRoad.get(size).equals("D")) {
            downMove.add(" O ");
            return true;
        }
        downMove.add(" X ");
        return false;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
