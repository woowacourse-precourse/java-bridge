package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {

    BridgeGame game;

    @BeforeEach
    void init() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        game = new BridgeGame(bridge);
    }

    @DisplayName("다음 위치로 움직일 수 있는지 확인후 이동한다.")
    @Test
    void move() {
        assertThat(game.move(BridgeCell.UP)).isTrue();
        assertThat(game.move(BridgeCell.DOWN)).isTrue();
        assertThat(game.move(BridgeCell.UP)).isFalse();
        assertThat(game.move(BridgeCell.DOWN)).isTrue();
    }

    @DisplayName("다리를 넘어서 움직이려하면 예외가 발생한다.")
    @Test
    void moveOver() {
        assertThat(game.move(BridgeCell.UP)).isTrue();
        assertThat(game.move(BridgeCell.DOWN)).isTrue();
        assertThat(game.move(BridgeCell.UP)).isFalse();
        assertThat(game.move(BridgeCell.DOWN)).isTrue();

        assertThatThrownBy(() -> game.move(BridgeCell.DOWN))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }
}
