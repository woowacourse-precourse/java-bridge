package bridge.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.game.BridgeTile;
import bridge.helper.common.CommonBridgeField;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    private final int defaultBridgeSize = 3;

    @Nested
    @DisplayName("int size를 매개변수로 받는 생성자는")
    class DescribeIntConstructorTest {

        @Nested
        @DisplayName("만약 유효한 다리의 크기가 주어지면")
        class ContextWithValidSizeTest {

            @ParameterizedTest
            @ValueSource(ints = {3, 4, 5, 20})
            @DisplayName("플레이어 이동경로 저장 ArrayList를 생성해 초기화하고 Player를 반환한다")
            void it_returns_player(int input) {
                assertThatCode(() -> new Player(input)).doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("만약 유효하지 않은 다리의 크기가 주어지면")
        class ContextWithInvalidSizeTest {

            @ParameterizedTest
            @ValueSource(ints = {-1, 0, 1, 2, 21})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void it_throws_exception(int invalidInput) {
                assertThatThrownBy(() -> new Player(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("move 메소드는")
    class DescribeMoveMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 전체 다리 정보와 플레이어가 이동할 다리 방향이 주어지면")
        class ContextWithBridgeAndPlayerStepTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "UP:false",
                        "DOWN:true"
                    },
                    delimiter = ':'
            )
            @DisplayName("이동 가능 여부를 반환한다")
            void it_returns_movable(BridgeTile playerStep, boolean expected) {
                boolean actual = player.move(bridge, playerStep);

                assertThat(actual).isSameAs(expected);
            }
        }
    }

    @Nested
    @DisplayName("getPlayerTargetTileHistory 메소드는")
    class DescribeGetPlayerTargetTileHistoryMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 다리와 출력하고자 하는 BridgeTile이 주어지면")
        class ContextWithBridgeTileTest {

            @ParameterizedTest
            @MethodSource("bridge.domain.player.arguments.PlayerTestArguments#getPlayerTargetTileHistoryArgument")
            @DisplayName("해당 BridgeTile에 대한 플레이어의 이동 경로를 반환한다")
            void it_returns_movableHistory(List<BridgeTile> playerSteps,
                    String expectedUpHistory, String expectedDownHistory) {
                playerSteps.forEach(step -> player.move(bridge, step));

                String upHistory = player.getPlayerTargetTileHistory(BridgeTile.UP);
                String downHistory = player.getPlayerTargetTileHistory(BridgeTile.DOWN);

                assertThat(upHistory).isEqualTo(expectedUpHistory);
                assertThat(downHistory).isEqualTo(expectedDownHistory);
            }
        }
    }

    @Nested
    @DisplayName("isSuccessful 메소드는")
    class DescribeIsSuccessfulMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 Bridge가 주어지면")
        class ContextWithBridge {

            @ParameterizedTest
            @MethodSource("bridge.domain.player.arguments.PlayerTestArguments#successHistoryArgument")
            @DisplayName("다리를 건너는 것을 성공했는지 유무를 반환한다")
            void itReturnsBoolean(List<BridgeTile> playerSteps, boolean expected) {
                playerSteps.forEach(step -> player.move(bridge, step));

                boolean actual = player.isSuccessful(bridge);

                assertThat(actual).isSameAs(expected);
            }
        }
    }

    @Nested
    @DisplayName("clearPlayerInfo 메소드는")
    class DescribeClearPlayerInfoMethodTest extends CommonBridgeField {

        private Player player;

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            @BeforeEach
            void initPlayer() {
                player = new Player(defaultBridgeSize);
                IntStream.range(0, defaultBridgeSize)
                        .forEach(i -> player.move(bridge, BridgeTile.DOWN));
            }

            @Test
            @DisplayName("플레이어 관련 정보를 초기화하고 tryCount를 증가시킨다")
            void it_process_clear() {
                assertThat(player.isSuccessful(bridge)).isTrue();

                long beforeTryCount = player.getTryCount();
                player.preparedNextPlay();
                long afterTryCount = player.getTryCount();

                assertThat(player.isSuccessful(bridge)).isFalse();
                assertThat(afterTryCount - beforeTryCount).isSameAs(1L);
            }
        }
    }

    @Nested
    @DisplayName("getTryCount 메소드는")
    class DescribeGetTryCountMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            @Test
            @DisplayName("플레이어의 현재 게임 시도 횟수를 반환한다")
            void it_returns_tryCount() {
                long actual = player.getTryCount();

                assertThat(actual).isSameAs(1L);
            }
        }
    }

    private abstract class CommonBeforeEach extends CommonBridgeField {

        protected Player player;

        @BeforeEach
        void initPlayer() {
            player = new Player(defaultBridgeSize);
        }
    }
}
