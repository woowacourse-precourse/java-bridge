package bridge;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> userMoveChoice;

    public User() {
        userMoveChoice = new ArrayList<>();
    }

    public void saveChoice(String move) {
        userMoveChoice.add(move);
    }

    public List<String> getUserMoveChoice() {
        return userMoveChoice;
    }
}
