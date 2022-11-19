package bridge.domain;

import bridge.ui.Constant;
import bridge.ui.InputView;
import bridge.ui.OutputView;

public class Referee {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void start() {
        BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeSize());
        int flag = runningGame(bridgeGame);
        while (flag == Constant.GAME_RESTART) {
            bridgeGame.retry();
            flag = runningGame(bridgeGame);
        }
        // TODO: 최종 결과 출력
        outputView.printResult(flag, bridgeGame);
    }

    private int runningGame(BridgeGame bridgeGame) {
        do {
            String inputGoingBlock = inputView.readMoving();
            if (!bridgeGame.move(inputGoingBlock)){
                return inputView.readGameCommand();
            }
            // TODO: 현재 다리의 상태를 출력해야함.
            outputView.printMap(bridgeGame);
        } while (!bridgeGame.isClear());
        return Constant.GAME_CLEAR;
    }
}
