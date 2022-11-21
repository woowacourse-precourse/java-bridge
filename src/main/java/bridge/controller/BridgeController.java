package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.service.BridgeGame;
import bridge.service.BridgeService;
import bridge.service.InputService;
import bridge.view.OutputView;

public class BridgeController {
    private final BridgeService bridgeService = new BridgeService();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();
    private final InputService inputService = new InputService();

    public void start() {
        gameStartMessage();
        Bridge bridge = bridgeService.bridgeMaker();
        User user = new User();
        playGame(user, bridge);
    }

    public void gameStartMessage() {
        outputView.printGameStart();
    }

    public void playGame(User user, Bridge bridge) {
        while (!user.isGameDoneStatus()) {
            String moveDirection = inputService.requestMove();
            outputView.printMap(bridge.getNowIndex(), moveDirection, isUserAnswerCorrect(moveDirection, bridge));
            processGame(bridge, user, isUserAnswerCorrect(moveDirection, bridge));
        }
        outputView.printResult(user);
    }

    public boolean isUserAnswerCorrect(String moveDirection, Bridge bridge) {
        return bridgeGame.isUserAnswerCorrect(moveDirection, bridge);
    }

    public void processGame(Bridge bridge, User user, boolean isUserAnswerCorrect) {
        if (!isUserAnswerCorrect) {
            String gameStatus = inputService.requestStatusOfGame();
            doFailCase(bridge, user, gameStatus);
            return;
        }
        doSuccessCase(bridge, user);
    }

    public void doFailCase(Bridge bridge, User user, String gameStatus) {
        bridgeGame.handleFailCaseCommand(bridge, user, gameStatus);
        if (bridgeGame.isResetCase(gameStatus)) {
            outputView.initMapView();
        }
    }

    public void doSuccessCase(Bridge bridge, User user) {
        bridgeGame.move(bridge, user);
    }
}
