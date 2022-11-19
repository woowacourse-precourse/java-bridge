package bridge;

import java.util.Arrays;

public enum GameResultCondition {
    PASS("O"),
    FAIL("X");

    private String result;

    GameResultCondition(String result) {
        this.result = result;
    }

    static GameResultCondition of(String commande){
        return Arrays.stream(values())
                .filter(v -> commande.equals(v.result))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("[ERROR]"));
    }
}
