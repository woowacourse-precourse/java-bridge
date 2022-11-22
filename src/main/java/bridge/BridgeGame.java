package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<BridgeResult> topResult;
    private List<BridgeResult> bottomResult;
    private int totalPlayCnt;


    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.topResult = new ArrayList<>();
        this.bottomResult = new ArrayList<>();
        this.totalPlayCnt = 1;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<BridgeResult> getTopResult() {
        return topResult;
    }

    public List<BridgeResult> getBottomResult() {
        return bottomResult;
    }

    public int getTotalPlayCnt() {
        return totalPlayCnt;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String selectCell, int numberOfHits) {
        if(checkCell(selectCell, numberOfHits)){
            success(selectCell);
            return true;
        }
        fail(selectCell);
        return false;
    }

    private boolean checkCell(String selectCell, int numberOfHits) {
        return bridge.get(numberOfHits).equals(selectCell);
    }

    private void fail(String selectCell) {
        if(selectCell.equals("U")){
            topResult.add(BridgeResult.FAIL);
            bottomResult.add(BridgeResult.NONE);
        }
        if(selectCell.equals("D")){
            topResult.add(BridgeResult.NONE);
            bottomResult.add(BridgeResult.FAIL);
        }
    }

    private void success(String selectCell) {
        if(selectCell.equals("U")){
            topResult.add(BridgeResult.SUCCESS);
            bottomResult.add(BridgeResult.NONE);
        }
        if(selectCell.equals("D")){
            topResult.add(BridgeResult.NONE);
            bottomResult.add(BridgeResult.SUCCESS);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        topResult.clear();
        bottomResult.clear();
        totalPlayCnt++;
    }

    public GameResult successOrFailure() {
        int topBridgeCnt = (int) topResult.stream()
                .filter(v -> v.equals(BridgeResult.SUCCESS)).count();
        int bottomBridgeCnt = (int) bottomResult.stream()
                .filter(v -> v.equals(BridgeResult.SUCCESS)).count();
        if(topBridgeCnt + bottomBridgeCnt == bridge.size()){
            return GameResult.SUCCESS;
        }
        return GameResult.FAIL;
    }
}
