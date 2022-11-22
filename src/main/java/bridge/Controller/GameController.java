package bridge.Controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.Bridge;
import bridge.Model.BridgeGame;
import bridge.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    BridgeGame bridgeGame = new BridgeGame();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    int size;
    List<String> madeBridge;
    List<List<String>> userBridge = new ArrayList<>();


    public void start() {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        // 다리 길이 입력
        size = inputView.readBridgeSize();
        madeBridge = bridgeMaker.makeBridge(size);
    }

    public void progress() {
        // 방향 입력
        while (bridgeGame.getCount() <= size) {
            String userDirection = inputView.readMoving();
            userBridge = bridgeGame.move(madeBridge, userDirection);
            // 다리 그리기
            outputView.printMap(userBridge);

            if (!wrongCheck()) {
                return;
            }
        }
    }

    private boolean wrongCheck() {
        // 틀렸는지 체크
        if (!Bridge.getInstance.isRightAnswer()) {
            String cont = inputView.readGameCommand();
            return bridgeGame.retry(cont);
        }
        return true;
    }

    public void end() {
        // 최종 결과
        outputView.printResult(userBridge, bridgeGame.getGameResult(), bridgeGame.getTried());

    }
}
