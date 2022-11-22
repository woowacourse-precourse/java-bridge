package bridge.domain;

import bridge.BridgeMaker;
import bridge.MockBridgeNumberGenerator;
import bridge.command.BridgeSizeCommand;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Visited 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class VisitedTest {
    private static final Bridge bridge = Bridge.from(
            new BridgeMaker(new MockBridgeNumberGenerator()), new BridgeSizeCommand("3"));
    private static final Visited visited1 = new Visited();
    private static final Visited visited2 = new Visited();
    private static final Visited visited3 = new Visited();
    private static final Visited visited4 = new Visited();

    @BeforeAll
    public static void setUp() {
        visited1.move(Position.UP, bridge);
        visited2.move(Position.UP, bridge);
        visited2.move(Position.UP, bridge);
        visited3.move(Position.UP, bridge);
        visited3.move(Position.UP, bridge);
        visited3.move(Position.DOWN, bridge);

        visited4.move(Position.UP, bridge);
        visited4.move(Position.UP, bridge);
        visited4.move(Position.UP, bridge);
    }

    @Test
    void toPrintableLog_메서드는_플레이_결과를_출력_가능한_형태로_만들어준다() {
        assertThat(visited1.toPrintableLog()).isEqualTo("[ O ]\n[   ]");
        assertThat(visited2.toPrintableLog()).isEqualTo("[ O | O ]\n[   |   ]");
        assertThat(visited3.toPrintableLog()).isEqualTo("[ O | O |   ]\n[   |   | X ]");
        assertThat(visited4.toPrintableLog()).isEqualTo("[ O | O | O ]\n[   |   |   ]");
    }

    @Test
    void isRemained_메서드는_게임이_더_진행될_수_있는지_여부를_반환한다() {
        assertTrue(visited1.isRemained(bridge));
        assertTrue(visited2.isRemained(bridge));
        assertFalse(visited3.isRemained(bridge));
        assertFalse(visited4.isRemained(bridge));
    }

    @Test
    void result_메서드는_게임_성공_실패_여부를_반환한다() {
        assertThat(visited1.result(bridge)).isEqualTo(GameResult.FAILURE);
        assertThat(visited2.result(bridge)).isEqualTo(GameResult.FAILURE);
        assertThat(visited3.result(bridge)).isEqualTo(GameResult.FAILURE);
        assertThat(visited4.result(bridge)).isEqualTo(GameResult.SUCCESS);
    }
}
