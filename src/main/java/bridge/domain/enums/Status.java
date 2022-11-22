package bridge.domain.enums;

public enum Status {

    PROGRESS_STATUS("진행중"),
    FAIL_STATUS("실패"),
    SUCCESS_STATUS("성공");

    private String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
