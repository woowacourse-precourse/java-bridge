package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int bridgeSize = inputView.readBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> userMoveHistory = new ArrayList<String>();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        for (int i = 0; i < bridgeSize; i++) {
            String userMove = inputView.readMoving();
            userMoveHistory.add(userMove);
            outputView.printMap(userMoveHistory, bridge, bridgeSize);
        }
    }
}
