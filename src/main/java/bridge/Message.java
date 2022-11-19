package bridge;

public enum Message {
    START("다리 건너기 게임을 시작합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
