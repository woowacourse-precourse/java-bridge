package bridge.domain.user;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<MoveType> moveTypes = new ArrayList<>();
    private final List<UserPath> userPaths = new ArrayList<>();
    private int tryCount = 0;

    public User() {
    }

    public void saveMove(String moveType) {
        if (MoveType.UP_TYPE.compareTo(moveType)) {
            moveTypes.add(MoveType.UP_TYPE);
        }

        if (MoveType.DOWN_TYPE.compareTo(moveType)) {
            moveTypes.add(MoveType.DOWN_TYPE);
        }
    }

    public void addPath(boolean isCorrect) {
        if (isCorrect) {
            userPaths.add(UserPath.CORRECT_PATH);
        }

        if (!isCorrect) {
            userPaths.add(UserPath.WRONG_PATH);
        }
    }

    public void addEmptyPath() {
        userPaths.add(UserPath.EMPTY_PATH);
    }
}
