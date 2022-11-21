package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();

        int size =inputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeMaker maker = new BridgeMaker(bridgeRandomNumberGenerator);

        maker.makeBridge(size); // 다리 생성

        

    }
}
