package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgemaker = new BridgeMaker(bridgeNumberGenerator);
    Bridge bridge;
    InputView input = new InputView();
    boolean state = true;

    public void run() {
        int lengthBridge = input.readBridgeSize();
        bridge = new Bridge(bridgemaker.makeBridge(lengthBridge));
        while (state) {
            state = move();
            if (!state) {
                state = retry();
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        String moveTo = input.readMoving();
        if (!bridge.applyMove(moveTo)) {
            retry();
        };
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        OutputView.messageRestart();
        boolean restart = input.readRestart();
        if (!restart) {
            // 최종 게임 결과
            OutputView.printResult();
            // 게임 성공 여부: 실패
            // 총 시도한 횟수: 1
        }
        return restart;
    }
}
