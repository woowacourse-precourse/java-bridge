package bridge.domain;

import java.util.List;

import static bridge.util.constants.MovableSpace.UP_SPACE;
import static bridge.util.constants.MovableSpace.DOWN_SPACE;

public class Bridge {
    private final List<String> movableSpaces;
    public Bridge(List<String> movableSpaces) {
        validate(movableSpaces);
        this.movableSpaces = movableSpaces;
    }

    private void validate(List<String> movableSpaces) {
        for (String space : movableSpaces) {
            if (!space.equals(UP_SPACE.getValue()) && !space.equals(DOWN_SPACE.getValue())) {
                throw new IllegalStateException("[ERROR] 생성된 다리가 유효하지 않습니다");
            }
        }
    }

    public int size() {
        return movableSpaces.size();
    }

    private String get(int index) {
        if (index < 1 || size() < index) {
            throw new IllegalStateException("[ERROR] 음..");
        }
        return movableSpaces.get(index - 1);
    }

    public boolean isBroken(int index, String spaceToMove) {
        if (get(index).equals(spaceToMove)) {
            return false;
        }
        return true;
    }
}
