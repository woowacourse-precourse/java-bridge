package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임을 컨트롤하는 클래스
 */
public class Controller {
    InputView inputView = new InputView();
    Validation validation = new Validation();
    SystemMessage systemMessage = new SystemMessage();
    private List<String> bridge = new ArrayList<>();

    public void start() {
        int bridgeSize = 0;
        systemMessage.start();
        bridgeSize = getBridgeSize(bridgeSize);
        createBridge(bridgeSize);
    }

    private int getBridgeSize(int bridgeSize) {
        while (true) {
            try {
                bridgeSize = inputView.readBridgeSize();
                validation.validateBridgeSize(bridgeSize);
                break;
            } catch (IllegalArgumentException e) {
                systemMessage.error("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
        return bridgeSize;
    }

    private void createBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }
}