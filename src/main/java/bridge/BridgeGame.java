package bridge;

import bridge.domain.BridgeShape;
import bridge.domain.MyBridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int tryCnt = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(MyBridge myBridge) {
        tryCnt++;
        while (myBridge.matchBlocks() && !myBridge.matchLength()) {
            myBridge.inputAlphabet();
            BridgeShape.makeLines(myBridge);
        }
        exit(myBridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(MyBridge myBridge) {
        boolean check = myBridge.reGame();
        if (check) {
            myBridge.initializeInputList();
            move(myBridge);
        }
        if (!check) {
            myBridge.exitGame(false, tryCnt);
        }
    }

    private boolean checkClear(MyBridge myBridge) {
        if (myBridge.matchLength()){
            return true;
        }
        return false;
    }

    public void exit(MyBridge myBridge) {
        if (checkClear(myBridge)) {
            myBridge.exitGame(true, tryCnt);
        }
        if (!checkClear(myBridge)) {
            retry(myBridge);
        }
    }

}
