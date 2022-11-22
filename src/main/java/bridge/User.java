package bridge;

import java.util.List;
import java.util.ArrayList;

public class User {
    private List<String> userBridge;
    private int bridgeLength;
    private List<String> answer;
    private int nowBridgeLength;

    public User(List<String> answer, int bridgeLength) {
        this.userBridge = new ArrayList<>(bridgeLength);
        this.bridgeLength = bridgeLength;
        this.answer = answer;
        this.nowBridgeLength = 0;
    }

    public void userStateUpdate() {
        String direction = new InputView().readMoving();
        userMove(direction);
        new OutputView().printMap(answer,userBridge);
    }

    public void userMove(String direction) {
        this.userBridge.add(direction);
        this.nowBridgeLength++;
    }

    public boolean isSuccess(int tryCount) {
        if (getUserSize() == bridgeLength) {
            new OutputView().printResult(answer, userBridge, tryCount);
            return true;
        }
        return false;
    }

    public boolean isFailure() {
        if (getUserSize() > 0 && !answer.get(getUserSize()-1).equals(userBridge.get(getUserSize()-1)))
            return true;
        return false;
    }

    public boolean reTryGame() {
        String reGame = new InputView().readGameCommand();
        if (reGame.equals("R"))
            return true;
        return false;
    }

    public int getUserSize() {
        return nowBridgeLength;
    }
}