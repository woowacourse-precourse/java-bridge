package bridge.controller;

import bridge.domain.User;
import bridge.service.BridgeGame;
import bridge.service.BridgeService;
import bridge.service.UserService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    public void run() {
        OutputView.printWelcomeGame();
        OutputView.printRunGame();
        String bridgeSize = InputView.readBridgeSize();

        List<String> bridge = BridgeService.generateBridge(bridgeSize);
        User user = UserService.generateUser();

        startGame(bridge, user);
        endGame(bridge, user);
    }

    public void startGame(List<String> bridge, User user) {
        UserService.initializeUser(user);
        controlMove(bridge, user);

        if (user.sameBridgeSize(bridge.size())) {
            return;
        }

        retry(bridge, user);
    }

    public void controlMove(List<String> bridge, User user) {
        while (user.lessThanBridgeSize(bridge.size())) {
            OutputView.printChooseOne();
            String position = InputView.readMoving();
            boolean isPermitted = BridgeGame.move(position, bridge, user);
            OutputView.printMap(user);

            if (!(isPermitted)) {
                return;
            }
        }
    }

    public void retry(List<String> bridge, User user) {
        OutputView.printRetry();
        String retryInput = InputView.readGameCommand();

        if (BridgeGame.retry(retryInput, user)) {
            startGame(bridge, user);
        }
    }

    public static void endGame(List<String> bridge, User user) {
        OutputView.printResult(user);
        if (user.sameBridgeSize(bridge.size())) {
            OutputView.printSuccess(user);
            return;
        }
        OutputView.printFail(user);
    }
}
