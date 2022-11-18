package view.validation.exception;

public enum IllegalArgument {

    NOT_BRIDGE_INPUT("다리의 길이는 3 ~ 20 사이의 숫자중 하나를 입력해야 합니다."),
    NOT_MOVING_INPUT("이동할 방향은 U, D중에서 하나를 입력해야 합니다."),
    NOT_COMMAND_INPUT("진행 여부는 R, Q중에서 하나를 입력해야 합니다.");



    private final String message;

    IllegalArgument(String message) {
        this.message = "[ERROR] " + message;
    }

    public static void handleException(String message){
        throw new IllegalArgumentException(message);
    }

    public String getMessage() {
        return message;
    }
}
