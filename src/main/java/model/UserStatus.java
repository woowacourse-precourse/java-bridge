package model;

public enum UserStatus {
    PLAYING_STATUS("진행중"),
    WIN_STATUS("성공"),
    END_STATUS("실패");

    private String status;

    UserStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
