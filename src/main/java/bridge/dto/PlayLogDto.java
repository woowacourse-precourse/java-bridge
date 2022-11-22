package bridge.dto;

/**
 * 게임 결과 출력에 사용되는 로그름 담고 있는 클래스
 */
public final class PlayLogDto {
    private static final String NULL_MESSAGE = "로그에는 null 이 들어오면 안됩니다";
    private final String log;

    public PlayLogDto(final String log) {
        validateLog(log);
        this.log = log;
    }

    private void validateLog(final String log) {
        if (log == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    public String getLog() {
        return log;
    }
}
