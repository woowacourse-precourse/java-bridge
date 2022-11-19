package bridge.domain;

import bridge.ui.InputView;
import bridge.ui.OutputView;

public class Referee {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void start() {
        BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeSize());
        moving(bridgeGame);
    }

    private void moving(BridgeGame bridgeGame) {

        do {
            String inputGoingBlock = inputView.readMoving();
            Boolean isMoved = bridgeGame.move(inputGoingBlock);
            // TODO: 현재 다리의 상태를 출력해야함.
            outputView.printMap();

        } while (!bridgeGame.isEnd());

    }
}
