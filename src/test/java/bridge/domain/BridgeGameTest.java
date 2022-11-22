package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame bridgeGame;
    @BeforeEach
    void beforeEach() {
        this.bridgeGame = new BridgeGame();
    }
    @Test
    void move_틀린_답() {
        Assertions.assertThat(bridgeGame.move("U", "D"))
                .isFalse();
    }

    @Test
    void move_정답() {
        Assertions.assertThat(bridgeGame.move("U", "U"))
                .isTrue();
    }

    @Test
    void move_잘못된_값_입력_문자() {
        Assertions.assertThatThrownBy(() -> bridgeGame.move("a", "U"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void move_잘못된_값_입력_숫자() {
        Assertions.assertThatThrownBy(() -> bridgeGame.move("1", "U"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void retry_잘못된_값_입력_문자() {
        Assertions.assertThatThrownBy(() -> bridgeGame.retry("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void retry_잘못된_값_입력_숫자() {
        Assertions.assertThatThrownBy(() -> bridgeGame.retry("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void retry_재시작_입력() {
        Assertions.assertThat(bridgeGame.retry("R"))
                .isTrue();
    }
    @Test
    void retry_종료_입력() {
        Assertions.assertThat(bridgeGame.retry("Q"))
                .isFalse();
    }
}