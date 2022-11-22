package view.input;

import bridge.validation.Validation;

public enum InputMessage {
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요.") {
        @Override
        public void validation(String input) {
            validation.validateBridgeSizeFormat(input);
            validation.validateBridgeSizeRange(input);
        }
    },
    INPUT_BRIDGE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)") {
        @Override
        public void validation(String input) {
            validation.validateMoving(input);
        }
    },
    INPUT_RESTART_CODE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)") {
        @Override
        public void validation(String input) {
            validation.validateRetryCode(input);
        }
    };

    private static final Validation validation = new Validation();
    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    abstract public void validation(String input);
}
