package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<String> movingMap;

    public Player() {
        movingMap = new ArrayList<>();
    }

    public void move(String position) {
        movingMap.add(position);
    }

    public List<String> getMovingMap() {
        return movingMap;
    }

    public String getLatestMoving() {
        if (movingMap.size() == 0) {
            throw new IllegalStateException("아직 이동하지 않았습니다. 한번 이상은 이동 해야 합니다.");
        }

        int latestIdx = movingMap.size() - 1;
        return movingMap.get(latestIdx);
    }
}
