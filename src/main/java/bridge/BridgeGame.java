package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int tryNum;
    private List<String> move;
    final private List<String> bridge;

    public BridgeGame(int bridgeSize){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        move = new ArrayList<>();
        tryNum = 1;
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean canMove(String input) {
        move.add(input);
        if(!bridge.get(move.size() - 1).equals(input)) {
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        if(input.equals("Q")){
            return false;
        }
        tryNum++;
        move.clear();
        return true;
    }

    public List<String> getMove(){
        return move;
    }

    public boolean success(){
        if(move.size() != bridge.size()){
            return false;
        }
        if(!move.get(move.size()-1).equals(bridge.get(bridge.size()-1))){
            return false;
        }
        return true;
    }

    public List<String> getBridge(){
        return bridge;
    }

    public int getTryNum(){
        return tryNum;
    }
}
