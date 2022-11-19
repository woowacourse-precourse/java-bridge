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
    private static final String RESTART_GAME = "R";
    private static final String QUIT_GAME = "Q";

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
            boolean isSuccess = bridge.isCorrectMoveDirection(moveDirection);
            outputView.printMap(bridge.getNowIndex(), moveDirection, isSuccess);
            gameProcess(bridge, user, isSuccess);
            continue;
        }
        outputView.printResult(user);
    }

    public void gameProcess(Bridge bridge, User user, boolean isSuccess) {
        if (!isSuccess) {
            String command = inputService.requestStatusOfGame();
            failCase(bridge, user, command);
        }
        if (isSuccess) {
            bridgeGame.move(bridge, user);
        }
    }

    public void failCase(Bridge bridge, User user, String command) {
        if (command.equals(RESTART_GAME)) {
            retry(bridge, user);
        }
        if (command.equals(QUIT_GAME)) {
            user.gameDoneSuccess();
            user.gameFail();
        }
    }

    public void retry(Bridge bridge, User user) {
        outputView.initMapView();
        bridgeGame.retry(bridge, user);
    }
}
