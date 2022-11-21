package bridge;

import bridge.Controller.BridgeGame;
import bridge.Model.Bridge;
import bridge.Model.BridgeMaker;
import bridge.Model.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        System.out.println("다리 건너기 게임을 시작합니다.\n");
        // 다리 길이 입력
        int size = InputView.getInstance.readBridgeSize();
        List<String> madeBridge = bridgeMaker.makeBridge(size);
        List<List<String>> userBridge = new ArrayList<>();

        // 방향 입력
        while(bridgeGame.getCount() <= size) {
            String userDirection = InputView.getInstance.readMoving();
            userBridge = bridgeGame.move(madeBridge, userDirection);
            OutputView.getInstance.printMap(userBridge);

            if(!Bridge.bridge.isRightAnswer()) {
                String cont = InputView.getInstance.readGameCommand();
                if(bridgeGame.retry(cont)) {
                    continue;
                }
                break;
            }
        }

        // 최종 결과
        OutputView.getInstance.printResult(userBridge, bridgeGame.getGameResult(), bridgeGame.getTried());
    }
}
