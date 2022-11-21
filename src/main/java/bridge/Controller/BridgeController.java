package bridge.Controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.Bridge;
import bridge.Domain.Result;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class BridgeController {
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public void playBridgeGame() {

        // 게임 시작 문구 출력
        OutputView.printGameStart();

        Bridge bridge = makeBridge();

        Result result = new Result();

        boolean trying = true;
        while (trying) {      // 사용자가 Q를 입력하기 전까지 게임이 계속된다
            int location = 0;
            boolean playGame = true;
            result.tryOneMore();
            while(playGame) {
                // 이동할 칸을 입력받는다
                String moveTo = InputView.readMoving();

                // 다리를 건넌다
                String space = bridge.getSpaceByLocation(location);
                playGame = BridgeGame.move(moveTo, space, result);

                OutputView.printMap(result);

                if(!playGame)
                    break;
                location++;
                if (location == bridge.getSize()) {
                    result.gameSucceed();
                    playGame = false;
                    trying = false;
                }
            }
            if (!trying) break;

            // 이동할 수 없는 경우 재시작 여부를 입력받는다
            trying = BridgeGame.retry(result);
        }

        // 최종 결과를 출력한다
        OutputView.printResult(result, bridge.getSize());
    }

    public Bridge makeBridge() {

        int bridgeSize = InputView.readBridgeSize();
        List<String> spaces = bridgeMaker.makeBridge(bridgeSize);

        return new Bridge(spaces, bridgeSize);
    }
}
