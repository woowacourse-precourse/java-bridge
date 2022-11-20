package bridge.domain;

public enum RestartInfo {
    QUIT,
    RETRY;

    public static RestartInfo makeRestartInfo(String restartInfoText) {
        if(restartInfoText.equals("Q")) {
            return QUIT;
        }
        if(restartInfoText.equals("R")) {
            return RETRY;
        }
        throw new IllegalArgumentException("게임 재시도 여부를 입력할 때는 Q 또는 R중 하나를 이용해 생성합니다.");
    }
}