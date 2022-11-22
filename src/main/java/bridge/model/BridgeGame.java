package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private List<String> upPresentBridge;
    private List<String> downPresentBridge;
    private List<String> userMoveList;
    private String gameSuccess;
    private int gameCount=1;

    public BridgeGame(List<String> bridge) {
        this.bridge=bridge;
        upPresentBridge=new ArrayList<>();
        downPresentBridge=new ArrayList<>();
        userMoveList=new ArrayList<>();
        gameSuccess="성공";
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void move(String userMove) {
        userMoveList.add(userMove);
        if(userMove.equals("U")) {
            if (bridge.get(userMoveList.size() - 1).equals(userMove)) {
                upPresentBridge.add("O");
                downPresentBridge.add("X");
                return;
            }
            upPresentBridge.add("X");
            downPresentBridge.add("O");
            gameSuccess="실패";
            return;
        }
        if (bridge.get(userMoveList.size() - 1).equals(userMove)) {
            upPresentBridge.add("X");
            downPresentBridge.add("O");
            return;
        }
        upPresentBridge.add("O");
        downPresentBridge.add("X");
        gameSuccess="실패";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        upPresentBridge.clear();
        downPresentBridge.clear();
        gameSuccess="성공";
        userMoveList.clear();
    }

    public List<String> getUpPresentBridge() {
        return upPresentBridge;
    }

    public List<String> getDownPresentBridge() {
        return downPresentBridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserMoveList() {
        return userMoveList;
    }

    public String getGameSuccess() {
        return gameSuccess;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void totalGamePlus(){
        gameCount++;
    }
}
