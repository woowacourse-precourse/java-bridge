package bridge.domain.game;

public enum CrossOver {
    SUCCESS("O"),
    FAIL("X");

    String value;

    CrossOver(String crossover) {
        this.value = crossover;
    }


}
