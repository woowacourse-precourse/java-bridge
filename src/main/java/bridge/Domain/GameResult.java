package bridge.Domain;

import bridge.Utils.GameStatus;
import bridge.Utils.Message;
import bridge.Utils.MoveType;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<String> upBridge;
    private List<String> downBridge;
    private GameStatus gameStatus;

    public GameResult() {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
        gameStatus = GameStatus.PROGRESS;
    }

    public void setUpBridge(String userChoice, boolean checkIsWrong) {
        if (userChoice.equals(MoveType.UP.getStrValue())) {
            upBridge.add(getResultMessage(checkIsWrong));
            return;
        }
        upBridge.add(Message.PASS);
    }

    public void setDownBridge(String userChoice, boolean checkIsWrong) {
        if (userChoice.equals(MoveType.DOWN.getStrValue())) {
            downBridge.add(getResultMessage(checkIsWrong));
            return;
        }
        downBridge.add(Message.PASS);
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String getResultMessage(boolean checkIsWrong) {
        if (checkIsWrong) {
            return Message.WRONG;
        }
        return Message.CORRECT;
    }
}
