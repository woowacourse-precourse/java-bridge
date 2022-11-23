package bridge.domain;

import java.util.function.BiConsumer;

public enum BridgeGameState {
    NORMAL((BridgeMap bridgemap, Moving moving)
            -> moving.marking(bridgemap, Constants.SUCCESS)),
    GAME_CLEAR(((BridgeMap bridgemap, Moving moving)
            -> {
    })),
    GAME_OVER((BridgeMap bridgemap, Moving moving)
            -> moving.marking(bridgemap, Constants.FAIL));

    private final BiConsumer<BridgeMap, Moving> marking;

    BridgeGameState(BiConsumer<BridgeMap, Moving> marking) {
        this.marking = marking;
    }

    public void marking(BridgeMap bridgeMap, Moving moving) {
        marking.accept(bridgeMap, moving);
    }

    private static class Constants {
        public static final String SUCCESS = "O";
        public static final String FAIL = "X";
    }
}
