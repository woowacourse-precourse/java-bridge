package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker();

    boolean gameSet = false;
    int count = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public List<String> start(){
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);
        return bridgeList;
    }

    public void move(String result) {
        String input = inputView.readMoving();
        outputView.makeResult(result,input,count,gameSet);
        outputView.printMap();
    }



    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
