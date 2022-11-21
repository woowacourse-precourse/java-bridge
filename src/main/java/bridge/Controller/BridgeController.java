package bridge.Controller;

import bridge.*;
import bridge.Domain.Bridge;
import bridge.Domain.UserBridges;
import bridge.Domain.Status;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class BridgeController {

    public void playBridgeGame() {

        // 게임 시작 문구 출력
        OutputView.printGameStart();

        Bridge bridge = makeBridge();

        UserBridges userBridges = new UserBridges();

        Status status = Status.PLAYING;
        int tries = 0;
        boolean success = false;
        while (status == Status.PLAYING) {      // 사용자가 Q를 입력하기 전까지 게임이 계속된다

            tries += 1;
            Status now = run(bridge, userBridges);

            if (now == Status.END_OF_BRIDGE) {
                success = true;
                break;
            }

            if (now == Status.WRONG_CHOICE)
                status = BridgeGame.retry(userBridges);
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

            String moveTo = InputView.readMoving();

            String space = bridge.getSpaceByLocation(location);
            Status now = BridgeGame.move(moveTo, space, userBridges);

            OutputView.printMap(userBridges);

            if(now == Status.WRONG_CHOICE)
                return now;
        }

        return Status.END_OF_BRIDGE;
    }
}
