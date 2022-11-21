package bridge;

import java.util.List;


public class BridgeGame {
    private static List<String> bridge;
    BridgeGame(int bridgeSize){
        if(bridgeSize<3||bridgeSize>20)
            OutputView.errorHandling("3~20 사이의 숫자를 입력해주세요.");
        BridgeNumberGenerator bridgeNumberGenerator = null;
        BridgeMaker bridgeMaker = new BridgeMaker (bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
