package bridge.model;

import java.util.List;

public class Bridges {
    public static final int BRIDGES_SIZE_LOWER_BOUNDS = 3;
    public static final int BRIDGES_SIZE_UPPER_BOUNDS = 20;
    public static final String ERR_BRIDGES_SIZE = "[ERROR] 다리 길이는 3 이상 20 이하의 자연수여야 합니다. 예시) 3(O), 18(O), 21(X)";
    private final List<Moving> bridges;

    public Bridges(List<Moving> bridges) {
        this.bridges = bridges;
        validate(bridges);
    }

    private void validate(List<Moving> bridges) {
        if (bridges.size() > BRIDGES_SIZE_UPPER_BOUNDS || bridges.size() < BRIDGES_SIZE_LOWER_BOUNDS) {
            throw new IllegalArgumentException(ERR_BRIDGES_SIZE);
        }
    }

    public PlayerStatus acceptPlayer(int location, Moving choice) {
        if (isCrossed(location)) {
            return PlayerStatus.CROSSED;
        }
        if (isSurviving(location, choice)) {
            return PlayerStatus.SURVIVING;
        }
        return PlayerStatus.DEAD;
    }

    private boolean isCrossed(int location) {
        return bridges.size() <= location;
    }

    private boolean isSurviving(int location, Moving choice) {
        return bridges.get(location) == choice;
    }
}
