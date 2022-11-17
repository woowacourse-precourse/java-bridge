package bridge.domain;

import java.util.List;

public class Bridge {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String BRIDGE_ELEMENT_INVALID_ERROR = "다리의 구성 요소가 올바르지 않습니다.";
    private final List<String> elements;
//    private final int size;

    public Bridge(List<String> elements) {
        validate(elements);
        this.elements = elements;
//        this.size = elements.size();
    }

    private void validate(List<String> elements) {
        checkComponent(elements);
    }

    // Bridge (정답) 과 input 을 비교해 O 또는 X 를 반환
    public String compare(Position position) {
        if (elements.get(position.getIndex()).equals(position.getElementIndex())) {
            return "O";
        }
        return "X";
    }

    private void checkComponent(List<String> elements) {
        boolean isValid = elements.stream()
                .filter(element -> element.equals(UP) || element.equals(DOWN))
                .count() == elements.size();
        if (!isValid) {
            throw new IllegalArgumentException(BRIDGE_ELEMENT_INVALID_ERROR); // TODO: exception 타입
        }
    }

    public List<String> getElements() {
        return elements;
    }
}
