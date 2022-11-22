package bridge;

import bridge.domain.BridgeMaker;
import bridge.domain.bridgenumber.BridgeRandomNumberGenerator;
import bridge.service.BridgeGameService;
import bridge.view.InputView;

import java.util.List;

public class Application {
    static InputView input = new InputView();
    static int bridgeSize;
    static BridgeMaker bridgeMaker;
    static List<String> crossByBridge;

    public static void main(String[] args) {
        BridgeGameService bridgeGameService = new BridgeGameService();
        bridgeGameService.startBridgeGame();
        try {
            bridgeSize = Integer.parseInt(input.readBridgeSize()); // 다리의 길이 입력
            bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            crossByBridge = bridgeMaker.makeBridge(bridgeSize); // 다리 만들기
            bridgeGameService = new BridgeGameService(crossByBridge);
            bridgeGameService.playBridgeGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
