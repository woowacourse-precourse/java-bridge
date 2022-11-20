package bridge.game;


import java.util.Arrays;

public enum GameCommend {

    RESTART("R"),
    QUIT("Q"),
    ;

    private static final String WARM = "[ERROR]";
    private static final String WARM_RESTART_CHOICE = WARM + " 게임을 재시도 여부를 바르게 입력해주세요. (재시도: R, 종료: Q)";
    private final String stringIdentifier;

    GameCommend(String stringIdentifier) {
        this.stringIdentifier = stringIdentifier;
    }

    public String getStringIdentifier() {
        return stringIdentifier;
    }

    public static void validateInput(String input) {
        Arrays.stream(GameCommend.values())
                .filter(gameCommend -> gameCommend.stringIdentifier.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WARM_RESTART_CHOICE));
    }

    public static GameCommend generate(String stringIdentifier) {
        return Arrays.stream(GameCommend.values())
                .filter(gameCommend -> gameCommend.getStringIdentifier()
                        .equals(stringIdentifier))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WARM_RESTART_CHOICE));
    }

    public static boolean isRestart(GameCommend gameCommend) {
        if (gameCommend.equals(GameCommend.RESTART)) {
            return true;
        }
        return false;
    }
}
