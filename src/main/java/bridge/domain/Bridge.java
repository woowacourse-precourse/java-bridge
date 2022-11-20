package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> movableSpaces;
    public Bridge(List<String> movableSpaces) {
        validate(movableSpaces);
        this.movableSpaces = movableSpaces;
    }

    private void validate(List<String> movableSpaces) {
        for (String space : movableSpaces) {
            if (!space.equals("U") && !space.equals("D")) {
                throw new IllegalStateException("[ERROR] 생성된 다리가 유효하지 않습니다");
            }
        }
    }

    public List<String> getMovableSpaces() {
        return movableSpaces;
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
