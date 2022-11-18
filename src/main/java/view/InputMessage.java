package view;

public enum InputMessage {
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요.") {
        @Override
        public void eachValidation(String input) {
            if (Integer.parseInt(input) < 3 || Integer.parseInt(input) > 20) {
                throw new IllegalArgumentException("다리의 길이는 3 이상 20 이하여야 합니다.");
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
