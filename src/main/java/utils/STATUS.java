package utils;

public enum STATUS {
    RUNNING("실패"),
    END_WITH_SUCCESS("성공"),
    END_WITH_FAILURE("실패");

    private final String success;

    STATUS(String success) {
        this.success = success;
    }

    public String getSuccess(){
        return success;
    }
}
