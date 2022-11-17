package bridge.domain;

import java.util.List;

public class Bridge {

    private static final int UP = 1;
    private static final int DOWN = 0;
    private static final String BRIDGE_ELEMENT_INVALID_ERROR = "다리의 구성 요소가 올바르지 않습니다.";
    private final List<Integer> elements;

    public Bridge(List<Integer> elements) {
        validate(elements);
        this.elements = elements;
    }

    private void validate(List<Integer> elements) {
        checkComponent(elements);
    }

    // Bridge (정답) 과 input 을 비교해 O 또는 X 를 반환
    public String compare(Position position) {
        if (elements.get(position.getIndex()) == position.getElementIndex()) {
            return "O";
        }
        return "X";
    }

    private void checkComponent(List<Integer> elements) {
        boolean isValid = elements.stream()
                .filter(element -> element == UP || element == DOWN)
                .count() == elements.size();
        if (!isValid) {
            throw new IllegalArgumentException(BRIDGE_ELEMENT_INVALID_ERROR); // TODO: exception 타입
        }
    }

    public List<Integer> getElements() {
        return elements;
    }
}
