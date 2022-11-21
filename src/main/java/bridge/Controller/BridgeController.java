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
        while (status == Status.PLAYING) {      // 사용자가 Q를 입력하기 전까지 게임이 계속된다

            int location = 0;

            userBridges.tryOneMore();
            Status now;
            while(true) {
                // 이동할 칸을 입력받는다
                String moveTo = InputView.readMoving();

                // 다리를 건넌다
                String space = bridge.getSpaceByLocation(location);
                now = BridgeGame.move(moveTo, space, userBridges);

                OutputView.printMap(userBridges);

                if(now == Status.WRONG_CHOICE)
                    break;

                location++;
                if (location == bridge.getSize()) {
                    userBridges.gameSucceed();
                    now = Status.END_OF_BRIDGE;
                    break;
                }
            }
            if (now.equals(Status.END_OF_BRIDGE)) break;

            // 이동할 수 없는 경우 재시작 여부를 입력받는다
            status = BridgeGame.retry(userBridges);
        }

        // 최종 결과를 출력한다
        OutputView.printResult(userBridges, bridge.getSize());
    }

    public Bridge makeBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        int bridgeSize = InputView.readBridgeSize();
        List<String> spaces = bridgeMaker.makeBridge(bridgeSize);

        return new Bridge(spaces, bridgeSize);
    }
}
