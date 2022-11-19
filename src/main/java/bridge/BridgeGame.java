package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    List<String> visited = new ArrayList<>();
    BridgeMaker bridgeMaker;
    Bridge bridge;

    public void init(){
        int bridgeLen = inputView.readBridgeSize();
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeLen);
        bridge = new Bridge(answerBridge);
    }
    /**
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        String direction = inputView.readMoving();
        boolean isRightDirection = bridge.isRightDirection(visited.size(),direction);
        if(isRightDirection){
            outputView.printMap(visited,direction,"O");
            visited.add(direction);
            return true;
        }
        outputView.printMap(visited, direction, "X");
        return false;
    }

    public boolean isGameCompleted(){
        if(bridge.isCrossedBridge(visited)){
            return true;
        }
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
