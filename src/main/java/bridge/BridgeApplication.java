package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.BridgeUnit;
import bridge.domain.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.domain.GameStatus.PLAYING;

public class BridgeApplication {

    private final OutputView outputView;
    private final InputView inputView;

    public BridgeApplication() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        try {
            outputView.printStartMessage();
            int bridgeSize = inputView.readBridgeSize();

            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridgeRaw = bridgeMaker.makeBridge(bridgeSize);
            Bridge bridge = new Bridge(bridgeRaw);

            BridgeGame bridgeGame = new BridgeGame(bridge);

            GameStatus status = PLAYING;
            while (PLAYING.equals(status)) {
                String moving = inputView.readMoving();
                BridgeUnit nextUnit = BridgeUnit.from(moving);

                status = bridgeGame.move(nextUnit);
            }
        } catch (IllegalArgumentException e) {

        }
    }
}
