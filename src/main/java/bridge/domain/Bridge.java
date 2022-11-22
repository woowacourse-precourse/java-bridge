package bridge.domain;

import static exception.ExceptionMessage.DOES_NOT_EXIST_UP_DOWN;

import exception.ExceptionMessage;
import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge(List<String> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    public Result distinguish(int index, Move move) {
        String position = bridge.get(index);
        return Result.getResultBySuccess(position.equals(move.getCommand()));
    }

    private void validate(List<String> bridge) {
        boolean isValidate = bridge.stream()
                .allMatch(position -> position.equals(Move.DOWN.getCommand()) || position.equals(Move.UP.getCommand()));
        if (!isValidate) {
            throw new IllegalArgumentException(ExceptionMessage.DOES_NOT_EXIST_UP_DOWN);
        }
    }

    public boolean isSame(List<String> userBridge) {
        return bridge.equals(userBridge);
    }

}
