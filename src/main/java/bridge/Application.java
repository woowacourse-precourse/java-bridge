package bridge;

import bridge.Model.Bridge;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeMaker;
import bridge.Model.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static BridgeGame bridgeGame = new BridgeGame();
    private static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        // 다리 길이 입력
        int size = InputView.getInstance.readBridgeSize();
        List<String> madeBridge = bridgeMaker.makeBridge(size);
        List<List<String>> userBridge = new ArrayList<>();

        // 방향 입력
        while (bridgeGame.getCount() <= size) {
            String userDirection = InputView.getInstance.readMoving();
            userBridge = bridgeGame.move(madeBridge, userDirection);
            // 다리 그리기
            OutputView.getInstance.printMap(userBridge);

            // 틀렸는지 체크
            if (!Bridge.bridge.isRightAnswer()) {
                String cont = InputView.getInstance.readGameCommand();
                if (!bridgeGame.retry(cont)) {
                    break;
                }
            }
        }

        // 최종 결과
        OutputView.getInstance.printResult(userBridge, bridgeGame.getGameResult(), bridgeGame.getTried());
    }
}
