package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> userMoves = new ArrayList<>();

    public void move(String moveInput) {
        userMoves.add(moveInput);
    }

    public int getMoveCount() {
        return userMoves.size();
    }

    public void clearUserMove() {
        userMoves = new ArrayList<>();
    }
}
