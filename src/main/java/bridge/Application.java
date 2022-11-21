package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static bridge.Constants.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame();

        outputView.printInit();
        int bridgeSize = inputView.readBridgeSize();

        // TODO: 사이즈만큼 다리 생성
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);
    }


}
