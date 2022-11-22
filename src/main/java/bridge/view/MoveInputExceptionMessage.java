package bridge.view;

public enum MoveInputExceptionMessage {

    SMALL_LETTER_EXCEPTION_MESSAGE("[ERROR] 대문자만 입력가능합니다."),
    NOT_SUITABLE_ALPHABET_EXCEPTION_MESSAGE("[ERROR] U와 D만 입력가능합니다.");

    private String moveInputExceptionMessage;

    MoveInputExceptionMessage(String moveInputExceptionMessage) {
        this.moveInputExceptionMessage = moveInputExceptionMessage;
    }

    public String getMoveInputExceptionMessage() {
        return moveInputExceptionMessage;
    }
}
