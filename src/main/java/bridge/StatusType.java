package bridge;

public enum StatusType {
    PLAY("진행", true),
    SUCCESS("성공", false),
    FAIL("실패", false);

    private String status;
    private boolean isPlaying;

    StatusType(String status, boolean isPlaying) {
        this.status = status;
        this.isPlaying = isPlaying;
    }

    public String getStatus() {
        return status;
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
