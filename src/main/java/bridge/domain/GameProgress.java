package bridge.domain;

public enum GameProgress {
    FAILURE("실패"), SUCCESS("성공"), PLAYING("진행중");
    private String progress;

    GameProgress(String progress) {
        this.progress = progress;
    }

    public String getProgress() {
        return progress;
    }
}
