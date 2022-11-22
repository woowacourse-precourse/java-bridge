package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static int position;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String uporDown) {
        boolean gameResult = false;
        if (uporDown.equals("U")) {
            gameResult = upBridgeMove();
            return gameResult;
        }
        gameResult = downBridgeMove();
        return gameResult;
    }

    public boolean upBridgeMove(){
        if (upBridgeMoveCheck()) {
            GameControl.resultBridge.add("O_up");
            position++;
            return true;
        }
        GameControl.resultBridge.add("X_up");
        return false;
    }
    public boolean downBridgeMove(){
        if (downBridgeMoveCheck()) {
            GameControl.resultBridge.add("O_down");
            position++;
            return true;
        }
        GameControl.resultBridge.add("X_down");
        return false;
    }

    public boolean upBridgeMoveCheck(){
        if(matchMoveandAnswer(BridgeMaker.bridgeUp)){
            return true;
        }
        return false;
    }
    public boolean downBridgeMoveCheck(){
        if(matchMoveandAnswer(BridgeMaker.bridgeDown)) {
            return true;
        }
        return false;
    }

    public boolean matchMoveandAnswer(List<Integer> bridge){
        if(bridge.get(position) == 0){
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }


}
