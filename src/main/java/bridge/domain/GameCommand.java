package bridge.domain;

public enum GameCommand {
    QUIT,
    RETRY;

    public static GameCommand makeGameCommand(String gameCommandText) {
        if(gameCommandText.equals("Q")) {
            return QUIT;
        }
        if(gameCommandText.equals("R")) {
            return RETRY;
        }
        throw new IllegalArgumentException("게임 재시도 여부를 입력할 때는 Q 또는 R중 하나를 이용해 생성합니다.");
    }
}