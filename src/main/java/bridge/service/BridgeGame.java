package bridge.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int trialCount;
    private final List<String> bridge;
    private final List<String> movements;

    public int getTrialCount() {
        return trialCount;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getMovements() {
        return movements;
    }

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.trialCount = 1;
        this.movements = new ArrayList<>();
    }

    public boolean isComplete() {
        for(int i = 0 ; i < movements.size(); i++) {
            if(!bridge.get(i).equals(movements.get(i))) {
                return false;
            }
        }

        return bridge.size() <= movements.size();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public boolean move(String movement) {
       movements.add(movement);

       int currentBridgeIdx = movements.size() - 1;
        String answer = bridge.get(currentBridgeIdx);

        return answer.equals(movement);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        movements.clear();
        trialCount++;
    }
}
