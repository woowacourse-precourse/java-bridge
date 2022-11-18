package view;

public enum InputMessage {
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요.") {
        @Override
        public void eachValidation(String input) {
            if (Integer.parseInt(input) < 3 || Integer.parseInt(input) > 20) {
                throw new IllegalArgumentException("다리의 길이는 3 이상 20 이하여야 합니다.");
            }
        }
    },
    INPUT_BRIDGE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)") {
        @Override
        public void eachValidation(String input) {
            if (!input.equals("U") && !input.equals("D")) {
                throw new IllegalArgumentException("이동할 칸의 입력은 'U' 또는 'D'가 되어야 합니다.");
            }
        }
    };

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    abstract public void eachValidation(String input);
}
