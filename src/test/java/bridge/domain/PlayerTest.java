package bridge.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사용자 도메인 및 사용자 상태 도메인 로직 테스트")
public class PlayerTest {
    private Player player;

    @BeforeEach
    void initPlayer() {
        player = new Player();
        player.init();
    }

    @DisplayName("사용자의 위치가 제대로 증가하는지 확인한다.")
    @Test
    void checkPlayerPositionAfterMove() {
        PlayerStatus status = player.getStatus();
        int beforeTryCount = status.getTryCount();
        status.addTryCount();
        int afterTryCount = status.getTryCount();
        assertThat(beforeTryCount).isLessThan(afterTryCount);
    }

    @DisplayName("사용자 위치와 상태가 제대로 초기화가 되는지 확인한다.")
    @Test
    void checkPlayerAfterInit() {
        player.success();
        player.fail();

        player.init();

        assertThat(player.getNextPosition()).isEqualTo(0);
        assertThat(player.getStatus()).isEqualTo(PlayerStatus.PLAYING);
    }
}
