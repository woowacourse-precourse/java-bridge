package bridge.ui.resource;

/**
 * 예외 상황 발생시 출력할 메시지를 저장하는 역할을 한다.
 */
public enum Exceptions {
    Blank("[ERROR]: 입력이 되지 않았습니다. 다시 입력해주세요."),
    NotInteger("[ERROR]: 숫자를 입력해주세요."),
    NotInRange("[ERROR]: 3이상 20이하의 숫자를 입력해주세요."),
    NotUorD("[ERROR]: U 혹은 D를 입력해주세요."),
    NotRorQ("[ERROR]: R 혹은 Q를 입력해주세요."),
    NotCorrectSize("[ERROR]: 한 개의 command를 입력해주세요.");
    private String message;

    Exceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
