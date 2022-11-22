package bridge.domain;

/**
 * boolean 형태의 게임의 결과를 문자열로 맵핑하는 역할을 한다.
 */
public enum GameResult {

    FAILURE("실패"), SUCCESS("성공");

    private final String message;

    GameResult(String message) {
        this.message = message;
    }

    /**
     * boolean 값에 따라 성공과 실패를 한글 메세지로 반환한다.
     * @param isSuccess 게임의 성공 여부
     * @return 성공하면 "성공", 실패하면 "실패"
     */
    public static String valueOf(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS.message;
        }
        return FAILURE.message;
    }
}
