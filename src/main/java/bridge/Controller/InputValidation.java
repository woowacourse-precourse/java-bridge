package bridge.Controller;

import bridge.View.Message;

public class InputValidation {
    /**
     * 입력받은 다리 길이 값 검증
     **/
    public void validateSize(int bridgeSize) {
        if (!(bridgeSize >= 3 && bridgeSize <= 20)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력받은 이동 값 검증
     **/
    public void validateMove(String moving) {
        if (!(moving.matches("[U,D]"))) {
            throw new IllegalArgumentException(Message.ERROR_MOVE.getView());
        }
    }

    /**
     * 입력받은 재시작 값 검증
     **/
    public void validateCommand(String retry) {
        if (!(retry.matches("[R,Q]"))) {
            throw new IllegalArgumentException(Message.ERROR_MOVE.getView());
        }
    }
}
