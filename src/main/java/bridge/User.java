package bridge;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> userMovingRecord;

    public void resetUserMoving() {
        userMovingRecord = new ArrayList<>();
    }

    public List<String> recordUserMoving(String moving) {
        userMovingRecord.add(moving);

        return userMovingRecord;
    }
}
