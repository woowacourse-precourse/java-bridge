package bridge.Domain;


import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    private Player player;
    private int bridgeSize;

    @BeforeEach
    void beforeEach() {
        List<String> bridge = List.of("U", "D", "D", "D", "U", "U", "D", "U", "D");
        this.player = new Player(new Bridge(bridge));
        this.bridgeSize = 9;
    }

    @Nested
    @DisplayName("movePlayer 메소드 테스트")
    class TestMovePlayer {

        @Test
        @DisplayName("메소드 실행 시 distance 값 +1 증가")
        void movePlayer_IncreaseDistanceByOne() {
            player.movePlayer();
            int expect = 0;
            assertThat(player).extracting("distance").isEqualTo(expect);
        }
    }

    @Nested
    @DisplayName("initPosition 메소드 테스트")
    class TestInitPosition {

        @Test
        @DisplayName("메소드 실행 시 distance 값 -1로 초기화")
        void initDistance_initDistanceByMinusOne() {
            player.initDistance();
            int expect = -1;
            assertThat(player).extracting("distance").isEqualTo(expect);
        }
    }

    @Nested
    @DisplayName("isplayerMoveSuccess 메소드 테스트")
    class TestIsPlayerMoveSuccess {

        @Test
        @DisplayName("플레이어가 건널 수 있는 칸으로 이동한 경우 true 리턴")
        void isPlayerMoveSuccess_playerMoveIsSuccess_returnTrue() {
            player.movePlayer();
            String position = "U";
            boolean result = player.isPlayerMoveSuccess(position);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("플레이어가 건널 수 없는 칸으로 이동한 경우 false 리턴")
        void isPlayerMoveSuccess_playerMoveIsFail_returnFalse() {
            player.movePlayer();
            String position = "D";
            boolean result = player.isPlayerMoveSuccess(position);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("isPlayerInEndOfBridge 메소드 테스트")
    class TestIsPlayerInEndOfBridge {

        @Test
        @DisplayName("플레이어가 다리 끝에 위치한 경우 true 리턴")
        void isPlayerInEndOfBridge_playerIsOntheEndOfBridge_returnTrue() {
            for(int i = 0; i < bridgeSize; i++) {
                player.movePlayer();
            }

            boolean result = player.isPlayerInEndOfBridge();
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("플레이어가 다리 끝이 아닌 곳에 위치하는 경우 false 리턴")
        void isPlayerInEndOfBridge_playerIsNotOntheEndOfBridge_returnFalse() {
            boolean result = player.isPlayerInEndOfBridge();
            assertThat(result).isFalse();
        }
    }
}