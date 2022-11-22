package bridge.domain;

/**
 * 게임의 결과가 성공, 실패로 나뉘는 경우를 담당하는 클래스
 */
public enum GameResult {
    SUCCESS("성공"),
    FAILURE("실패");

    private final String resultMessage;

    GameResult(final String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public static GameResult from(final boolean success) {
        if (success) {
            return GameResult.SUCCESS;
        }
        return GameResult.FAILURE;
    }

    public String toResultMessage() {
        return resultMessage;
    }
}
