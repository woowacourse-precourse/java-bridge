package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Bridge bridge = new Bridge(List.of(Moving.U, Moving.U, Moving.D));
    Player player;

    @BeforeEach
    void beforeEach() {
        player = new Player();
    }

    @ParameterizedTest(name = "이동한 칸: {0}, 플레이어 상태: {1}")
    @CsvSource({"U,SURVIVING", "D,DEAD"})
    void move_메서드는_이동할_칸을_입력받고_PlayerStatus를_반환한다(Moving moving, PlayerStatus expected) {
        assertThat(player.move(moving, bridge)).isEqualTo(expected);
    }

    @DisplayName("마지막 칸까지 맞추면 플레이어 상태: CROSSED")
    @Test
    void move_메서드는_마지막_칸을_맞추면_CROSSED를_반환한다() {
        player.move(Moving.U, bridge);
        player.move(Moving.U, bridge);
        assertThat(player.move(Moving.D, bridge)).isEqualTo(PlayerStatus.CROSSED);
    }
}