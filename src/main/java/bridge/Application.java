package bridge;

import bridge.Model.Bridge;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeMaker;
import bridge.UI.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        // 다리 길이 입력
        int size = inputView.readBridgeSize();
        List<String> madeBridge = bridgeMaker.makeBridge(size);
        List<List<String>> userBridge = new ArrayList<>();

        // 방향 입력
        while (bridgeGame.getCount() <= size) {
            String userDirection = inputView.readMoving();
            userBridge = bridgeGame.move(madeBridge, userDirection);
            // 다리 그리기
            outputView.printMap(userBridge);

            // 틀렸는지 체크
            if (!Bridge.getInstance.isRightAnswer()) {
                String cont = inputView.readGameCommand();
                if (!bridgeGame.retry(cont)) {
                    break;
                }
            }
        }

        // 최종 결과
        outputView.printResult(userBridge, bridgeGame.getGameResult(), bridgeGame.getTried());
    }
}
