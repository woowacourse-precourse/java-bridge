package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("다리 게임 기능 검증")
class BridgeGameTest {
    private static BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "U", "D")));
    }

    @DisplayName("다리 한칸을 정상적으로 건넌 경우")
    @Test
    void 다리를_건널수_있는경우() {
        bridgeGame.move(0, "U");
        Assertions.assertThat(bridgeGame.getTop().get(0)).isEqualTo("O");
        Assertions.assertThat(bridgeGame.getBottom().get(0)).isEqualTo(" ");
    }

    @DisplayName("다리 한칸을 정상적으로 건너지 못한 경우")
    @Test
    void 다리를_건널수_없는경우() {
        bridgeGame.move(0, "D");
        Assertions.assertThat(bridgeGame.getTop().get(0)).isEqualTo(" ");
        Assertions.assertThat(bridgeGame.getBottom().get(0)).isEqualTo("X");
    }

    @DisplayName("재시도가 정상 동작하는 지(시도 횟수 증가 등)")
    @Test
    void 재시도_하는_경우() {
        bridgeGame.retry("R");
        Assertions.assertThat(bridgeGame.getPlayCount()).isEqualTo(1);
        Assertions.assertThat(bridgeGame.getTop().size()).isEqualTo(0);
        bridgeGame.retry("R");
        Assertions.assertThat(bridgeGame.getPlayCount()).isEqualTo(2);
    }

    @DisplayName("정상적으로 클리어 한 경우")
    @Test
    void 클리어_한_경우() {
        bridgeGame.move(0, "U");
        bridgeGame.move(1, "D");
        bridgeGame.move(2, "U");
        bridgeGame.move(3, "D");
        Assertions.assertThat(bridgeGame.isClear()).isEqualTo(true);
    }

    @DisplayName("정상적으로 클리어 하지 못한 경우")
    @Test
    void 클리어_못한_경우() {
        bridgeGame.move(0, "D");
        Assertions.assertThat(bridgeGame.isClear()).isEqualTo(false);

    }
}