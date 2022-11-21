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

        Status status = Status.PLAYING;
        int tries = 0;
        boolean success = false;
        while (status == Status.PLAYING) {

            tries += 1;
            Status currentStatus = run(bridge, userBridges);

            if (currentStatus == Status.END_OF_BRIDGE) {
                success = true;
                break;
            }

            if (currentStatus == Status.WRONG_CHOICE) {
                String retry = InputView.readGameCommand();
                status = BridgeGame.retry(retry, userBridges);
            }
        }

        // 최종 결과를 출력한다
        OutputView.printResult(userBridges, success, tries);
    }

    public Bridge makeBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        int bridgeSize = InputView.readBridgeSize();
        List<String> spaces = bridgeMaker.makeBridge(bridgeSize);

        return new Bridge(spaces, bridgeSize);
    }

    public Status run(Bridge bridge, UserBridges userBridges) {
        for(int location=0; location< bridge.getSize(); location++) {

            Status result = moveMap(bridge, userBridges, location);
            OutputView.printMap(userBridges);

            if(result == Status.WRONG_CHOICE)
                return result;
        }
        return Status.END_OF_BRIDGE;
    }

    public Status moveMap(Bridge bridge, UserBridges userBridges, int location) {
        String moving = InputView.readMoving();
        String space = bridge.getSpaceByLocation(location);
        return BridgeGame.move(moving, space, userBridges);
    }
}
