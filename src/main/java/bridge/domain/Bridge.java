package bridge.domain;

import static exception.ExceptionMessage.DOES_NOT_EXIST_UP_DOWN;

import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge(List<String> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    private void validate(List<String> bridge) {
        boolean isValidate = bridge.stream()
                .allMatch(position -> position.equals(Move.DOWN.getCommand()) || position.equals(Move.UP.getCommand()));
        if (!isValidate) {
            throw new IllegalArgumentException(DOES_NOT_EXIST_UP_DOWN);
        }
    }

}
