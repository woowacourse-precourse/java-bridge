package controller;

public enum Message {
    START_GAME("다리 건너기 게임을 시작합니다.");

    private final String text;

    Message(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
