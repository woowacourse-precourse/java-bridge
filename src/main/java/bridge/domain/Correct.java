package bridge.domain;

import java.util.Arrays;

public enum Correct {
    CORRECT("O", true),
    WRONG("X", false);
    private String symbol;
    private boolean isCorrect;

    Correct(String symbol, boolean isCorrect) {
        this.symbol = symbol;
        this.isCorrect = isCorrect;
    }


    public String getSymbol() {
        return this.symbol;
    }

    public static Correct getByCorrect(boolean isCorrect) {
        return Arrays.stream(values())
                .filter(Correct -> Correct.isCorrect == isCorrect)
                .findFirst()
                .orElseThrow();
    }
}
