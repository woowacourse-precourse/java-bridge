package bridge;

import java.util.List;
import java.util.Objects;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        outputView.gameStart();

        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);

        List<String> moveDecision;
        int numberOfTrying;
        do {
            String direction = inputView.readMoving();
            numberOfTrying = BridgeGame.gameCount(direction);
            BridgeGame bridgeGame = new BridgeGame();
            moveDecision = bridgeGame.move(direction, bridge, numberOfTrying);
            System.out.println(moveDecision);
        }
        while (!Objects.equals(moveDecision.get(numberOfTrying), "X"));
    }
}
