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
        }
    }

    // 사용자가 칸을 이동할 때 사용하는 메서드
    public boolean move() {
        String moveTo = input.readMoving();
        if (!bridge.applyMove(moveTo)) {
            return retry(moveTo);
        };
        if (bridge.checkFinish()) {
            OutputView.printResult(bridge, true, moveTo);
            return false;
        }
        return true;
    }

    //사용자가 게임을 다시 시도할 때 사용하는 메서드
    public boolean retry(String moveTo) {
        OutputView.messageRestart();
        boolean restart = input.readGameCommand();
        if (!restart) {
            OutputView.printResult(bridge, false, moveTo);
        }
        if (restart) {
            bridge.clearBridgeNow();
        }
        return restart;
    }
}
