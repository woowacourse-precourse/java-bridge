package bridge.service;

import bridge.domain.User;
import bridge.domain.Map;

import java.util.List;

public class GameService {

    private final List<String> bridge;
    private final User user;
    private final Map map;

    public GameService(List<String> bridge, User user, Map map) {
        this.user = user;
        this.bridge = bridge;
        this.map = map;
    }

    public void move(String moveDirection) {
        user.inputMoveDirection(moveDirection);
        drawMap();
    }

    private boolean canMove() {
        int matchIndex = user.getCountInputMoveDirection() - 1;
        if (bridge.get(matchIndex).equals(user.getMoveDirection())) {
            return true;
        }
        return false;
    }

    private void drawMap() {
        map.drawMap(user.getMoveDirectionNumber(), canMove());
    }

    public List<List<String>> getMap(){
        return map.getMap();
    }

    public boolean CanKeepGoingGame() {
        if (user.getCountInputMoveDirection() == bridge.size() || !canMove()) {
            return false;
        }
        return true;
    }

    public boolean isNotPass() {
        if (!canMove()) {
            return true;
        }
        return false;
    }

    public boolean isLastMoveTry() {
        if (bridge.size() == user.getCountInputMoveDirection()) {
            return true;
        }
        return false;
    }

    public void retry() {
        map.retry();
        user.retry();
    }

    public int getTrialCount() {
        return user.getTrialCount();
    }


    public String getGameResult() {
        if (!isNotPass() && isLastMoveTry()) {
            return "성공";
        }
        return "실패";
    }
}
