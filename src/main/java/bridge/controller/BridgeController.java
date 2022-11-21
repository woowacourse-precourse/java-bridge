package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.service.BridgeGame;
import bridge.service.BridgeService;
import bridge.service.ViewService;

public class BridgeController {
    private final BridgeService bridgeService = new BridgeService();
    private final ViewService viewService = new ViewService();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void start() {
        gameStartMessage();
        Bridge bridge = bridgeService.bridgeMaker();
        User user = new User();
        playGame(user, bridge);
    }

    public void gameStartMessage() {
        viewService.printGameStart();
    }

    public void playGame(User user, Bridge bridge) {
        while (!user.isGameDoneStatus()) {
            String moveDirection = viewService.requestMove();
            viewService.printMap(bridge.getNowIndex(), moveDirection, isUserAnswerCorrect(moveDirection, bridge));
            processGame(bridge, user, isUserAnswerCorrect(moveDirection, bridge));
        }
        viewService.printResult(user);
    }

    public boolean isUserAnswerCorrect(String moveDirection, Bridge bridge) {
        return bridgeGame.isUserAnswerCorrect(moveDirection, bridge);
    }

    public void processGame(Bridge bridge, User user, boolean isUserAnswerCorrect) {
        if (!isUserAnswerCorrect) {
            String gameStatus = viewService.requestStatusOfGame();
            doFailCase(bridge, user, gameStatus);
            return;
        }
        doSuccessCase(bridge, user);
    }

    public void doFailCase(Bridge bridge, User user, String gameStatus) {
        bridgeGame.handleFailCaseCommand(bridge, user, gameStatus);
        if (bridgeGame.isResetCase(gameStatus)) {
            viewService.initMapView();
        }
    }

    public void doSuccessCase(Bridge bridge, User user) {
        bridgeGame.move(bridge, user);
    }
}
