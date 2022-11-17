package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Position {

    private static final int INDEX_INDEX = 0;
    private static final int ELEMENT_INDEX = 1; // up or down
    private static final int UP = 1;
    private static final int DOWN = 0;

    private final List<Integer> position = new ArrayList<>();

    public Position() {
        resetPosition();
    }

    public void updatePosition(String input) {
        position.add(INDEX_INDEX, position.get(INDEX_INDEX) + 1);
        if (input.equals("U")) {
            position.add(ELEMENT_INDEX, UP);
        }
        if (input.equals("D")) {
            position.add(ELEMENT_INDEX, DOWN);
        }
    }

    public void resetPosition() {
        position.add(INDEX_INDEX, -1);
    }

    public String getElementIndex() { // TODO: getter 사용 자제... 메시지를 보내기
        int elementIndex = position.get(ELEMENT_INDEX);
        if (elementIndex == UP) {
            return "U";
        }
        return "D";
    }

    public int getIndex() { // TODO: getter 사용 자제... 메시지를 보내기
        return position.get(INDEX_INDEX);
    }
}
