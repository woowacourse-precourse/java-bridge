package data;

public enum OutputForm {
    START_MESSAGE("다리 건너기 게임을 시작합니다.");
    private final String message;

    OutputForm(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
