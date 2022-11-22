package bridge.controller;

import bridge.ValidationException;
import bridge.model.Score;
import bridge.model.User;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameManager2 {

    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;

    public GameManager2() {
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
            playGame();
        } while (continueGame());

        outputView.printResult("", count);
    }

    public boolean playGame() {
        User user = new User();
        Score score = new Score();
        System.out.println(bridgeGame.bridge.getBridge());
        boolean moveOX = true;
        while (moveOX) {
            moveOX = checkMove(user, score);
            outputView.printMap(user.getUserCommand(),score.getScoreBoard());
        }
        System.out.println(moveOX);
        return moveOX;
    }

    public boolean checkMove(User user, Score score) {
        boolean moveOX;
        String command = inputView.readMoving();
        user.addUserCommand(command);
        moveOX = bridgeGame.move(user.getUserCommand());
        if (moveOX) {
            score.addGameResult("O");
            return moveOX;
        }
        score.addGameResult("X");
        return moveOX;
    }

    public boolean continueGame() {
        String command = inputView.readGameCommand();

        return bridgeGame.retry(command);

    }

}
