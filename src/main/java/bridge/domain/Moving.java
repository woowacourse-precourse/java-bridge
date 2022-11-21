package bridge.domain;

import java.util.Arrays;
import java.util.function.BiConsumer;

public enum Moving {
    UP("U", (BridgeMap bridgeMap, String mark) -> {
        bridgeMap.addUpperRow(mark);
        bridgeMap.addLowerRow(" ");
    }),
    DOWN("D", (BridgeMap bridgeMap, String mark) -> {
        bridgeMap.addUpperRow(" ");
        bridgeMap.addLowerRow(mark);
    });

    private static final String ENTER_U_OR_D = "위(U) 또는 아래(D)만 선택할 수 있습니다.";
    private final String symbol;
    private final BiConsumer<BridgeMap, String> marking;

    Moving(String symbol, BiConsumer<BridgeMap, String> addSuccess) {
        this.symbol = symbol;
        this.marking = addSuccess;
    }

    public static Moving findBySymbol(String symbol) {
        return Arrays.stream(Moving.values())
                .filter(moving -> moving.symbol.equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ENTER_U_OR_D));
    }

    public boolean immovable(String movableDirection) {
        return !symbol.equals(movableDirection);
    }

    public void marking(BridgeMap bridgeMap, String mark) {
        marking.accept(bridgeMap, mark);
    }
}
