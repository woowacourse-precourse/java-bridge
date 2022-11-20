package bridge.Domain;


import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    private Player player;

    @BeforeEach
    void beforeEach() {
        final int bridgeSize = 10;
        this.player = new Player(new Bridge(bridgeSize));
    }

    @Nested
    @DisplayName("movePlayer 메소드 테스트")
    class TestMovePlayer {

        @Test
        void testMovePlayer() {
            player.movePlayer();
            int expect = 0;
            assertThat(player).extracting("distance").isEqualTo(expect);
        }
    }

    @Nested
    @DisplayName("initPosition 메소드 테스트")
    class TestInitPosition {

        @Test
        void testInitPosition() {
            player.initPosition();
            int expect = -1;
            assertThat(player).extracting("distance").isEqualTo(expect);
        }
    }

}