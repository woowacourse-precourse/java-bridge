package bridge.domain;

public enum Progress {
    SUCCESS("성공"),
    PROGRESSION("진행"),
    FAILURE("실패");

    protected final String stateMessage;

    Progress(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    public String getStateMessage() {
        return stateMessage;
    }
}
