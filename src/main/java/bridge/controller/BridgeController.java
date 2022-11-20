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
    private final static String RESET = "R";

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

    public void processGame(Bridge bridge, User user, boolean isUserAnswerCorrect) {
        if (!isUserAnswerCorrect) {
            String gameStatus = inputService.requestStatusOfGame();
            bridgeGame.doFailCase(bridge, user, gameStatus);
            if (isResetCase(gameStatus)) {
                outputView.initMapView();
            }
            return;
        }
        bridgeGame.move(bridge, user);
    }

    public boolean isResetCase(String gameStatus) {
        if (gameStatus.equals(RESET)) {
            return true;
        }
        return false;
    }

    public boolean isUserAnswerCorrect(String moveDirection, Bridge bridge) {
        return bridge.isCorrectMoveDirection(moveDirection);
    }
}
