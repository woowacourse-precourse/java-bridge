package bridge.controller;

import bridge.ValidationException;
import bridge.model.Score;
import bridge.model.User;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameManager {

    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;

    public GameManager() {
        inputView = new InputView(new ValidationException());
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void initGameSetting() {
        int size = inputView.readBridgeSize();
        bridgeGame.makeBridge(size);
        System.out.println(bridgeGame.bridge.getBridge());
    }

    public void startGame() {
        int count = 0;

        do {
            count += 1;
            if (playGame()) {
                break;
            }
        } while (continueGame());

        outputView.printResult("", count);
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
        return false;
    }

    public boolean checkMove(User user, Score score) {
        String command = inputView.readMoving();
        user.addUserCommand(command);

        if (bridgeGame.move(user.getUserCommand())) {
            score.addGameResult("O");
            return true;
        }
        score.addGameResult("X");
        return false;
    }


    public String checkGameEnd(List<String> user) {

        if (bridgeGame.checkGameFinish(user)) {
            return "성공";
        }
        return "실패";
    }

    public boolean continueGame() {
        String command = inputView.readGameCommand();

        return bridgeGame.retry(command);
    }

}
