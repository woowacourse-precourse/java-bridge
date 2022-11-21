package bridge.Domain;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public int gameTryCount = 1;
    public boolean gameSuccess = false;
    List<String> mySelectBridge = new ArrayList<>();

    List<String> bridge;
    int bridgeLen;

    public BridgeGame(List<String> bridge, int bridgeLen){
        this.bridgeLen = bridgeLen;
        this.bridge = bridge;
    }

    public boolean gamePlayOnce(String position){
        int len = mySelectBridge.size();
        mySelectBridge.add(position);
        if(mySelectBridge.get(len).equals(bridge.get(len))) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        int len = mySelectBridge.size();
        if(len == bridgeLen)
            return false;
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if(gameCommand.equals("R")){
            gameTryCount += 1;
            mySelectBridge = new ArrayList<>();
            return true;
        }
        return false;
    }
}
