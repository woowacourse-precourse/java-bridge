package response;

public enum ErrorResponse {
    INPUT_BRIDE_SIZE_RANGE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ;

    private String errorMessage;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
