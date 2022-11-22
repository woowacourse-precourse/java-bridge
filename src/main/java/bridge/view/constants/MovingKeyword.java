package bridge.view.constants;

import bridge.model.domains.constants.Step;

/**
 * 이동할 칸 위치를 결정하는 키워드를 저장하고 맞는 값인지 확인해주는 상수 클래스
 */
public enum MovingKeyword implements Keyword {

    UP("U", Step.UP.getValue()),
    DOWN("D", Step.DOWN.getValue());

    private final String key;
    private final String value;

    MovingKeyword(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getValue() {
        return value;
    }

    public boolean isSameStepMoving(String moving) {
        return value.equals(moving);
    }
}
