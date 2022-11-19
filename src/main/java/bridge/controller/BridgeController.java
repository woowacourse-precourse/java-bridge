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
            boolean isUserAnswerCorrect = bridge.isCorrectMoveDirection(moveDirection);
            outputView.printMap(bridge.getNowIndex(), moveDirection, isUserAnswerCorrect);
            processGame(bridge, user, isUserAnswerCorrect);
            continue;
        }
        outputView.printResult(user);
    }

    public void processGame(Bridge bridge, User user, boolean isUserAnswerCorrect) {
        if (!isUserAnswerCorrect) {
            String gameStatus = inputService.requestStatusOfGame();
            bridgeGame.doFailCase(bridge, user, gameStatus);
            return;
        }
        bridgeGame.move(bridge, user);
    }
}
