package bridge.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.game.BridgeTile;
import bridge.helper.common.CommonBridgeField;
import bridge.helper.stub.StubPlayerState;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerStateTest {

    @Nested
    @DisplayName("move 메소드는")
    class DescribeMoveMethodTest extends CommonNormalPlayerStateBeforeEach {

        @Nested
        @DisplayName("만약 플레이어가 움직였는지 여부가 주어지면")
        class ContextWithMovableTest extends CommonBridgeTilesField {

            @Test
            @DisplayName("플레이어의 position을 1 증가시킨다")
            void it_process_position() {
                playerState.move(false);
                BridgeTile actual = playerState.findPlayerPositionTile(bridgeTiles);
                assertThat(actual).isEqualTo(bridgeTiles.get(0));

                playerState.move(true);
                actual = playerState.findPlayerPositionTile(bridgeTiles);
                assertThat(actual).isEqualTo(bridgeTiles.get(1));
            }
        }
    }

    @Nested
    @DisplayName("preparedNextPlay 메소드는")
    class DescribePreparedNextPlayMethodTest extends CommonNormalPlayerStateBeforeEach {

        @Nested
        @DisplayName("만약 호출되면")
        class ContextWithoutParameterTest {

            @Test
            @DisplayName("플레이어의 position을 0으로 초기화시키고 tryCount를 1 증가시킨다")
            void it_process_next_play_settings() {
                long before = playerState.getTryCount();

                playerState.preparedNextPlay();

                long after = playerState.getTryCount();

                assertThat(after - before).isSameAs(1L);
            }
        }
    }

    @Nested
    @DisplayName("isSuccessful 메소드는")
    class DescribeIsSuccessfulMethodTest extends CommonBridgeField {

        @Nested
        @DisplayName("만약 Bridge가 주어지면")
        class ContextWithBridgeTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "1:false",
                        "2:false",
                        "3:true"
                    },
                    delimiter = ':'
            )
            @DisplayName("플레이어가 다리를 통과했는지 여부를 반환한다")
            void it_return_successful(int playerPosition, boolean expected) {
                PlayerState playerState = new StubPlayerState(playerPosition);

                boolean actual = playerState.isSuccessful(bridge);

                assertThat(actual).isSameAs(expected);
            }
        }
    }

    @Nested
    @DisplayName("findPlayerPositionTile 메소드는")
    class DescribeFindPlayerPositionTileMethodTest extends CommonBridgeField {

        @Nested
        @DisplayName("만약 brigeTiles가 주어지면")
        class ContextWithBridgeTilesFieldTest extends CommonBridgeTilesField {

            @ParameterizedTest
            @CsvSource(
                value = {
                    "0:DOWN",
                    "1:UP"
                },
                delimiter = ':'
            )
            @DisplayName("플레이어의 현재 위치에 해당하는 BridgeTile을 반환한다")
            void it_returns_bridgeTile(int playerPosition, BridgeTile expected) {
                PlayerState playerState = new StubPlayerState(playerPosition);

                BridgeTile actual = playerState.findPlayerPositionTile(bridgeTiles);

                assertThat(actual).isSameAs(expected);
            }
        }
    }

    @Nested
    @DisplayName("getTryCount 메소드는")
    class DescribeGetTryCountMethodTest extends CommonNormalPlayerStateBeforeEach {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            @Test
            @DisplayName("플레이어가 게임을 시도한 횟수를 반환한다")
            void it_returns_tryCount() {
                long actual = playerState.getTryCount();

                assertThat(actual).isSameAs(1L);
            }
        }
    }

    private abstract class CommonNormalPlayerStateBeforeEach {

        protected PlayerState playerState;

        @BeforeEach
        void initPlayerState() {
            playerState = new PlayerState();
        }
    }

    private abstract class CommonBridgeTilesField {

        protected final List<BridgeTile> bridgeTiles = List.of(BridgeTile.DOWN, BridgeTile.UP);
    }
}