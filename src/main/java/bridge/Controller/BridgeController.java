package bridge.Controller;

import bridge.*;
import bridge.Domain.Bridge;
import bridge.Domain.UserBridge;
import bridge.Domain.UserBridges;
import bridge.Domain.Status;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class BridgeController {

    public void playBridgeGame() {

        OutputView.printGameStart();

        Bridge bridge = makeBridge();
        UserBridges userBridges = new UserBridges();

        gameStart(bridge, userBridges);
    }

    public Bridge makeBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        int bridgeSize = InputView.readBridgeSize();
        List<String> spaces = bridgeMaker.makeBridge(bridgeSize);

        return new Bridge(spaces, bridgeSize);
    }

    public void gameStart(Bridge bridge, UserBridges userBridges) {
        Status currentState;
        int tries;

        for (tries = 1; ; tries++) {
            currentState = run(bridge, userBridges);

            if (currentState == Status.END_OF_BRIDGE) break;
            if (retryOrNot(userBridges) == Status.QUIT) break;
        }
        OutputView.printResult(userBridges, currentState, tries);
    }

    public Status run(Bridge bridge, UserBridges userBridges) {
        for (int location = 0; location < bridge.getSize(); location++) {

            Status result = moveMap(bridge, userBridges, location);
            OutputView.printMap(userBridges);

            if (result == Status.WRONG_CHOICE)
                return result;
        }
        return Status.END_OF_BRIDGE;
    }

    public Status moveMap(Bridge bridge, UserBridges userBridges, int location) {
        String moving = InputView.readMoving();
        String space = bridge.getSpaceByLocation(location);
        return BridgeGame.move(moving, space, userBridges);
    }

    public Status retryOrNot(UserBridges userBridges) {
        String retry = InputView.readGameCommand();

        if (retry.equals("Q"))
            return Status.QUIT;

        BridgeGame.retry(userBridges);
        return Status.RETRY;
    }
}
