package bridge.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

class BridgeVisitedTest {
    private static final Bridge bridge = Bridge.of(List.of("U", "U", "U"));
    private static final BridgeVisited visited1 = new BridgeVisited();
    private static final BridgeVisited visited2 = new BridgeVisited();
    private static final BridgeVisited visited3 = new BridgeVisited();

    @BeforeAll
    public static void setUp() {
        visited1.move(BridgeGamePosition.UP, bridge);
        visited2.move(BridgeGamePosition.UP, bridge);
        visited2.move(BridgeGamePosition.UP, bridge);
        visited3.move(BridgeGamePosition.UP, bridge);
        visited3.move(BridgeGamePosition.UP, bridge);
        visited3.move(BridgeGamePosition.DOWN, bridge);
    }

    @Test
    void toPrintableLog_메서드는_플레이_결과를_출력_가능한_형태로_만들어준다() {
        assertThat(visited1.printMoveInfo()).isEqualTo("[ O ]\n[   ]");
        assertThat(visited2.printMoveInfo()).isEqualTo("[ O | O ]\n[   |   ]");
        assertThat(visited3.printMoveInfo()).isEqualTo("[ O | O |   ]\n[   |   | X ]");
    }
}