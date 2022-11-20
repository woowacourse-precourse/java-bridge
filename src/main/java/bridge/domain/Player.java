package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<String> movingList;

    public Player() {
        movingList = new ArrayList<>();
    }

    public void move(String moving) {
        movingList.add(moving);
    }

    public String getLatestMoving() {
        if (movingList.size() == 0) {
            throw new IllegalStateException("아직 이동하지 않았습니다. 한번 이상은 이동 해야 합니다.");
        }

        return movingList.get(getPosition());
    }

    public int getPosition() {
        return movingList.size() - 1;
    }

    public void reset() {
        movingList.clear();
    }
}
