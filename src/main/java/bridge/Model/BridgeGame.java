package bridge.Model;

import bridge.Constant.BridgeResult;

import java.util.ArrayList;
import java.util.List;

import static bridge.Constant.Constant.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> upBridge;
    private List<String> downBridge;
    private int playCount;


    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.upBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
        this.playCount = 1;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUp() {
        return upBridge;
    }

    public List<String> getDown() {
        return downBridge;
    }

    public int getTotalCnt() {
        return playCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String movingSquare, int index) {
        if (bridge.get(index).equals(movingSquare)) {
            moveCorrect(movingSquare);
            return true;
        }
        moveWrong(movingSquare);
        return false;
    }

    private void moveWrong(String movingSquare) {
        if (movingSquare.equals("U")) {
            upBridge.add(BridgeResult.FAIL.getStructure());
            downBridge.add(BridgeResult.NONE.getStructure());
        }
        if (movingSquare.equals("D")) {
            upBridge.add(BridgeResult.NONE.getStructure());
            downBridge.add(BridgeResult.FAIL.getStructure());
        }
    }

    private void moveCorrect(String movingSquare) {
        if (movingSquare.equals("U")) {
            upBridge.add(BridgeResult.SUCCESS.getStructure());
            downBridge.add(BridgeResult.NONE.getStructure());
        }
        if (movingSquare.equals("D")) {
            upBridge.add(BridgeResult.NONE.getStructure());
            downBridge.add(BridgeResult.SUCCESS.getStructure());
        }
    }

    /**
     * @@ -19,5 +82,19 @@ public void move() {
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        upBridge.clear();
        downBridge.clear();
        playCount++;
    }

    public String whenSuccess() {
        int upCount = 0;
        int downCount = 0;
        upCount = CountPlus(upCount, upBridge);
        downCount = CountPlus(downCount, downBridge);
        if (compareCount(upCount, downCount)) {
            return SUCCESS;
        }
        return FAIL;
    }

    public int CountPlus(int count, List<String> countBridge) {
        for (String Piece : countBridge) {
            if (Piece.equals(BridgeResult.SUCCESS.getStructure())) {
                count++;
            }
        }
        return count;
    }

    public boolean compareCount(int upCount, int downCount) {
        return upCount + downCount == bridge.size();
    }
}
