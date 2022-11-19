package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.BridgeUnit;
import bridge.domain.Command;
import bridge.domain.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.domain.Command.RETRY;
import static bridge.domain.GameStatus.FAILED;
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
            do {
                while (PLAYING.equals(status)) {
                    String moving = inputView.readMoving();
                    BridgeUnit nextUnit = BridgeUnit.from(moving);

                    status = bridgeGame.move(nextUnit);
                    outputView.printMap(bridgeGame);
                }
                if (FAILED.equals(status)) {
                    String code = inputView.readGameCommand();
                    Command command = Command.from(code);
                    if (RETRY.equals(command)) {
                        status = bridgeGame.retry();
                    }
                }
            } while (PLAYING.equals(status));
        } catch (IllegalArgumentException e) {

        }
    }
}
