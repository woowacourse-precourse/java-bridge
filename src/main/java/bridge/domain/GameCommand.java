package bridge.domain;

import java.util.Arrays;

public enum GameCommand {
    RETRY("R"), QUIT("Q");

    private static final String ENTER_R_OR_Q = "재시도(R) 또는 종료(Q)만 선택할 수 있습니다.";
    private final String symbol;

    GameCommand(String symbol) {
        this.symbol = symbol;
    }

    public static GameCommand findBySymbol(String symbol) {
        return Arrays.stream(GameCommand.values())
                .filter(moving -> moving.symbol.equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ENTER_R_OR_Q));
    }
}
