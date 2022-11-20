package bridge.Controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.Bridge;
import bridge.Domain.History;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class BridgeController {
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public void playBridgeGame() {

        // 게임 시작 문구 출력
        System.out.println("다리 건너기 게임을 시작합니다.");

        // 다리의 길이를 입력받는다
        int bridgeSize = InputView.readBridgeSize();
        System.out.println(bridgeSize);

        // 다리를 생성한다
        List<String> completeBridge = bridgeMaker.makeBridge(bridgeSize);
        Bridge bridge = new Bridge(completeBridge);
        System.out.println(bridge);

        History gameHistory = new History();
        int location = 0;
        boolean quitGame = false;
        while (!quitGame) {      // 사용자가 Q를 입력하기 전까지 게임이 계속된다
            boolean playGame = true;
            gameHistory.gameTry();
            while(playGame) {
                // 이동할 칸을 입력받는다
                String moveTo = InputView.readMoving();

                // 다리를 건넌다
                String space = bridge.getSpaceByLocation(location);
                playGame = BridgeGame.move(moveTo, space, gameHistory);

                OutputView.printMap(gameHistory, location+1);

                if(!playGame)
                    break;
                location++;
                if (location == bridgeSize) {
                    gameHistory.gameSuccess();
                    playGame = false;
                    quitGame = true;
                }
            }
            if (quitGame) break;
            // 이동할 수 없는 경우 재시작 여부를 입력받는다
            String retry = InputView.readGameCommand();
            if (retry.equals("Q")) {
                quitGame = true;
            }
            if (retry.equals("R")) {
                gameHistory.reset();
                location = 0;
            }
        }

        // 최종 결과를 출력한다
        OutputView.printResult(gameHistory, bridgeSize);
    }
}
