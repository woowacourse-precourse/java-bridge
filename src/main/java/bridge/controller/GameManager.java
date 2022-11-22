package bridge.controller;

import bridge.ValidationException;
import bridge.model.movingOorX;
import bridge.model.Score;
import bridge.model.User;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameManager {

    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;

    String successOrFail;

    public GameManager() {
        inputView = new InputView(new ValidationException());
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void initGameSetting() {
        int size = inputView.readBridgeSize();
        bridgeGame.makeBridge(size);
    }

    public void startGame() {
        int count = 0;
        do {
            count += 1;
            if (playGame()) {
                successOrFail = movingOorX.can.getMovingMessage();
                break;
            }
            successOrFail = movingOorX.cant.getMovingMessage();
        } while (continueGame());
        outputView.printResult(successOrFail, count);
    }

    public boolean playGame() {
        User user = new User();
        Score score = new Score();
        while (checkMove(user, score)) {
            outputView.printMap(user.getUserCommand(),score.getScoreBoard());
            if (bridgeGame.checkGameFinish(user.getUserCommand())) {
                return true;
            }
        }
        outputView.printMap(user.getUserCommand(),score.getScoreBoard());
        return false;
    }

    public boolean checkMove(User user, Score score) {
        String command = inputView.readMoving();
        user.addUserCommand(command);

        if (bridgeGame.move(user.getUserCommand())) {
            score.addGameResult(movingOorX.can.getMovingResult());
            return true;
        }
        score.addGameResult(movingOorX.cant.getMovingResult());
        return false;
    }
    public boolean continueGame() {
        String command = inputView.readGameCommand();

        return bridgeGame.retry(command);
    }

}
