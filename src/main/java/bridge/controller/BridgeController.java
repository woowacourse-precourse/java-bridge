package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.User;
import bridge.domain.BridgeGame;
import bridge.service.ViewService;
import java.util.List;

public class BridgeController {
    private static final String RESTART_GAME = "R";
    private static final String QUIT_GAME = "Q";
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final ViewService viewService = new ViewService();

    public void start() {
        gameStartMessage();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker());
        User user = new User();
        playGame(user, bridgeGame);
    }

    public List<String> bridgeMaker() {
        int bridgeSize = viewService.requestBridgeSize();
        List<String> bridgeGame = bridgeMaker.makeBridge(bridgeSize);
        return bridgeGame;
    }

    public void gameStartMessage() {
        viewService.printGameStart();
    }

    public void playGame(User user, BridgeGame bridgeGame) {
        while (!user.isGameDoneStatus()) {
            String moveDirection = viewService.requestMove();
            boolean isUserAnswerCorrect = bridgeGame.isCorrectMoveDirection(moveDirection);
            viewService.printMap(bridgeGame.getNowIndex(), moveDirection, isUserAnswerCorrect);
            processGame(bridgeGame, user, isUserAnswerCorrect);
        }
        viewService.printResult(user);
    }

    public void processGame(BridgeGame bridgeGame, User user, boolean isUserAnswerCorrect) {
        if (!isUserAnswerCorrect) {
            String gameStatus = viewService.requestStatusOfGame();
            doFailCase(bridgeGame, user, gameStatus);
            return;
        }
        doSuccessCase(bridgeGame, user);
    }

    public void doFailCase(BridgeGame bridgeGame, User user, String gameStatus) {
        if (gameStatus.equals(RESTART_GAME)) {
            viewService.initMapView();
            user.gameRetry();
            bridgeGame.retry();
        }
        if (gameStatus.equals(QUIT_GAME)) {
            user.gameDoneWithLose();
        }
    }

    public void doSuccessCase(BridgeGame bridgeGame, User user) {
        if (bridgeGame.isEndOfIndex()) {
            user.gameDoneWithWin();
            return;
        }
        bridgeGame.move();
    }
}
