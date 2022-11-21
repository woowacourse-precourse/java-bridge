package bridge;

import java.util.List;
import java.util.ArrayList;

public class User {
    private List<String> userBridge;
    private int bridgeLength;
    private List<String> answer;

    public User(List<String> answer, int bridgeLength) {
        this.userBridge = new ArrayList<>(bridgeLength);
        this.bridgeLength = bridgeLength;
        this.answer = answer;
    }

    public void userMove() {
        String direction = new InputView().readMoving();
        this.userBridge.add(direction);
        new OutputView().printMap(answer,userBridge);
    }

    public boolean isSuccess(int tryCount) {
        if (userBridge.size() == bridgeLength) {
            new OutputView().printResult(answer, userBridge, tryCount);
            return true;
        }
        return false;
    }

    public boolean isFailure() {
        if (userBridge.size() > 0 && !answer.get(userBridge.size()-1).equals(userBridge.get(userBridge.size()-1)))
            return true;
        return false;
    }

    public boolean reTryGame() {
        String reGame = new InputView().readGameCommand();
        if (reGame.equals("R"))
            return true;
        return false;
    }
}