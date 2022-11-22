package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private static final BridgeGame bridgeGame = new BridgeGame();

    @BeforeEach
    void initEach() {
        bridgeGame.init(3);
    }

    @DisplayName("init 메서드가 초기 필드를 올바르게 초기화하는지 확인한다.")
    @Test
    void init_초기화_테스트() {
        assertThat(bridgeGame.bridge.size()).isEqualTo(3);
        assertThat(bridgeGame.attempts).isEqualTo(0);
        assertThat(bridgeGame.nextLocation).isEqualTo(0);
        assertThat(bridgeGame.type).isEqualTo(BridgeGame.GameStatus.PROGRESS);
    }

    @DisplayName("toString 메서드가 게임 상황을 올바른 문자열로 변환하는지 확인한다.")
    @Test
    void isMovable_동작_테스트() {
        assertThat(bridgeGame.isMovable("U")).isEqualTo("U".equals(bridgeGame.bridge.get(0)));
    }

    @DisplayName("move 메서드가 올바른 값이 주어졌을때 nextLocation값과 상태를 확인한다.")
    @Test
    void move_인자가_실제값과_일치할때_동작_테스트() {
        bridgeGame.init(1);
        bridgeGame.move(bridgeGame.bridge.get(0));
        assertThat(bridgeGame.nextLocation).isEqualTo(1);
        assertThat(bridgeGame.type).isEqualTo(BridgeGame.GameStatus.SUCCESS);
    }

    @DisplayName("move 메서드에 올바르지 않은 값이 주어졌을때 nextLocation값과 상태를 확인한다.")
    @Test
    void move_인자가_실제값과_일치하지_않을때_동작_테스트() {
        bridgeGame.init(1);
        if (bridgeGame.bridge.get(0).equals("U")) {
            bridgeGame.move("D");
        }
        if (bridgeGame.bridge.get(0).equals("D")) {
            bridgeGame.move("U");
        }
        assertThat(bridgeGame.type).isEqualTo(BridgeGame.GameStatus.FAIL);
    }

    @DisplayName("renderUpperRow, renderLowerRow 메서드가 다리의 상태를 문자열로 올바르게 반환하는지 확인한다.")
    @Test
    void renderUpperRow와_renderLowerRow의_반환값이_실제와_같은지_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U", "U", "D", "D", "U"));
        assertThat(bridgeGame.renderUpperRow(bridge, 5)).isEqualTo("[ O | O |   |   | O ]");
        assertThat(bridgeGame.renderLowerRow(bridge, 5)).isEqualTo("[   |   | O | O |   ]");
    }

    @DisplayName("retry 메서드가 초기 필드를 올바르게 초기화하는지 확인한다.")
    @Test
    void retry_테스트() {
        bridgeGame.retry();
        assertThat(bridgeGame.attempts).isEqualTo(1);
        assertThat(bridgeGame.nextLocation).isEqualTo(0);
        assertThat(bridgeGame.type).isEqualTo(BridgeGame.GameStatus.PROGRESS);
    }
}
