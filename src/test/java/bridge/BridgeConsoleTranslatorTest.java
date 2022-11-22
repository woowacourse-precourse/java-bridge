package bridge;

import bridge.domain.model.Direction;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.BridgeConsoleTranslator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeConsoleTranslatorTest {

    @DisplayName("지금까지 칸을 건너는데 성공한 상태일 때 출력 테스트")
    @Test
    public void excludeFailMovesTest() {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "U", "U")));
        bridgeGame.move(Direction.UP);
        bridgeGame.move(Direction.DOWN);
        assertThat(bridgeGame.getPrintable(new BridgeConsoleTranslator()))
                .contains(
                        "[ O |   ]",
                        "[   | O ]"
                );
    }

    @DisplayName("최근 이동에서 다리를 건너는데 실패한 상태일 때 출력 테스트")
    @Test
    public void includeFailMovesTest() {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "U", "U")));
        bridgeGame.move(Direction.UP);
        bridgeGame.move(Direction.DOWN);
        bridgeGame.move(Direction.DOWN);
        assertThat(bridgeGame.getPrintable(new BridgeConsoleTranslator()))
                .contains(
                        "[ O |   |   ]",
                        "[   | O | X ]"
                );
    }

    @DisplayName("다리의 모든 칸을 성공적으로 건넌 후의 출력 테스트")
    @Test
    public void successAllMovesTest() {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "U", "U")));
        List<Direction> dirs = List.of(Direction.UP, Direction.DOWN, Direction.UP, Direction.UP);
        dirs.forEach(bridgeGame::move);

        assertThat(bridgeGame.getPrintable(new BridgeConsoleTranslator()))
                .contains(
                        "[ O |   | O | O ]",
                        "[   | O |   |   ]"
                );
    }

}
