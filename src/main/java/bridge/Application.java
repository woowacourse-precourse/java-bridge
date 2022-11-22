package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.Bridge;
import bridge.domain.Attempt;
import bridge.service.BridgeGame;
import bridge.view.InputView;

import java.util.List;

import static bridge.enums.InputMessage.RETRY_MESSAGE;
import static bridge.enums.InputMessage.START_MESSAGE;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printStartMessage();
        Bridge bridge = new Bridge(createBridge());
        BridgeGameController controller = createGameController(bridge);
        controller.execute();
        printRetryMessage(controller.getAttemptCount());
    }


    static BridgeGameController createGameController(final Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        Attempt attempt = new Attempt();
        return new BridgeGameController(bridgeGame, attempt);
    }

    static List<String> createBridge() {
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker maker = new BridgeMaker(generator);
        InputView inputView = new InputView();
        return maker.makeBridge(inputView.readBridgeSize());
    }

    static void printRetryMessage(int count) {
        System.out.println(RETRY_MESSAGE.getMessage() + count);
    }

    static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }
}
