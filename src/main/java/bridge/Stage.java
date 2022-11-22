package bridge;

import java.util.Arrays;

public enum Stage {
    D(0),
    U(1);

    private int level;
    Stage(int level) {
        this.level=level;
    }

    public static Stage getStage(int level) {
        return Arrays.stream(Stage.values())
                .filter(x->x.level==level)
                .findAny()
                .orElse(D);
    }

}
