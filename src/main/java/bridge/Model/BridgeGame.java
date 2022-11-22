package bridge.Model;

import java.util.LinkedList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeResult bridgeResult;
    private int currentLocation = 0;
    private int tries = 1;

    public BridgeGame(){
        bridgeResult = new BridgeResult();
    }

    public BridgeGame(LinkedList<String> upperBridgeState, LinkedList<String> lowerBridgeState){
        bridgeResult = new BridgeResult(upperBridgeState, lowerBridgeState);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param command 사용자가 입력한 명령
     * @param result 사용자가 이동하려는 칸이 건널 수 있는 칸이라면 "O", 아니라면 "X"
     */
    public void move(String command, String result) {
        if (command.equals("U")){
            bridgeResult.selectUpperBridge(result);
        }
        if (command.equals("D")){
            bridgeResult.selectLowerBridge(result);
        }
        currentLocation++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeResult.clear();
        currentLocation = 0;
        tries++;
    }

    public int getCurrentLocation(){
        return currentLocation;
    }

    public int getTries(){
        return tries;
    }

    public String getBridgeResult(){
        return bridgeResult.toString();
    }
}
