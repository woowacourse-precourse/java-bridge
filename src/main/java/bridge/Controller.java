package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final UserMap userMap = new UserMap(); //TODO BridgeGame 의 멤버여야 하는가?

    public void play() {
        try {
            outputView.printStartGame();
            setUp(requestBridgeSize());
            retryProcess();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int requestBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestBridgeSize();
        }
    }

    private void setUp(int bridgeSize) throws IllegalArgumentException{
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.setBridge(bridge);
        userMap.buildUserMap(bridgeGame.getBridge());
    }

    private String requestMoving() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestMoving();
        }
    }

    private boolean singleRound() {
        boolean moveSuccess = bridgeGame.move(requestMoving());
        userMap.updateUserMap(bridgeGame.getCur(), moveSuccess);
        outputView.printMap(userMap.getUserMap(), bridgeGame.getCur());
        return moveSuccess;
    }

    private boolean requestRetryCommand() {
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestRetryCommand();
        }
    }

    private void retryProcess() {
        while (!bridgeGame.isEnd()) {
            if (singleRound()) {
                continue;
            }
            if (requestRetryCommand()) {
                bridgeGame.retry();
                userMap.buildUserMap(bridgeGame.getBridge());
            }
            break; //TODO isEnd()지만 실패인 경우 처리
        }
    }
}
