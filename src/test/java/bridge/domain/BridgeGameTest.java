package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame(List.of("U", "D", "U"));
    }

    @DisplayName("다리를 이동하면 유저의 맵이 진행합니다.")
    @Test
    void 성공적인_이동() {
        bridgeGame.move("U");
        assertThat(bridgeGame.nowUserMapState().toString())
                .isEqualTo("[ O ]\n[   ]");
        bridgeGame.move("D");
        assertThat(bridgeGame.nowUserMapState().toString())
                .isEqualTo("[ O |   ]\n[   | O ]");
        bridgeGame.move("U");
        assertThat(bridgeGame.nowUserMapState().toString())
                .isEqualTo("[ O |   | O ]\n[   | O |   ]");

    }

    @DisplayName("실패 하면 스테이지(단계)가 올라가지 않습니다.")
    @Test
    void 실패이후_이동() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.nowUserMapState().toString())
                .isEqualTo("[ O | X | X ]\n[   |   |   ]");
    }

    @DisplayName("retry시 유저의 맵이 초기화 됩니다.")
    @Test
    void 다시시도_맵초기화() {
        bridgeGame.move("D");
        bridgeGame.retry();
        assertThat(bridgeGame.nowUserMapState().toString())
                .isEqualTo("[]\n[]");
    }

    @DisplayName("retry시 실패결과값이 초기화 됩니다.")
    @Test
    void 다시시도_실패초기화() {
        bridgeGame.move("D");
        assertThat(bridgeGame.isFail()).isTrue();
        bridgeGame.retry();
        assertThat(bridgeGame.isFail()).isFalse();
    }
}