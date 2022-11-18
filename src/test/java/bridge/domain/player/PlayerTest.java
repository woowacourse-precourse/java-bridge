package bridge.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeNumberGenerator;
import bridge.domain.game.Bridge;
import bridge.domain.game.BridgeTile;
import bridge.helper.stub.StubBridgeNumberGenerator;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerTest {

    private Player player;

    @BeforeEach
    void initPlayer() {
        player = new Player();
    }

    @Nested
    @DisplayName("move 메소드는")
    class DescribeMoveMethodTest {

        @Nested
        @DisplayName("만약 전체 다리 정보와 플레이어가 이동할 다리 방향이 주어지면")
        class ContextWithBridgeAndPlayerStep {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "UP:false",
                        "DOWN:true"
                    },
                    delimiter = ':'
            )
            @DisplayName("이동 가능 여부를 반환한다")
            void itReturnsBoolean(BridgeTile playerStep, boolean expectedMoving) {
                BridgeNumberGenerator generator = new StubBridgeNumberGenerator(List.of(0, 0, 0));
                Bridge bridge = new Bridge(3, generator);

                boolean actualMoving = player.move(bridge, playerStep);
                assertThat(actualMoving).isSameAs(expectedMoving);
            }
        }
    }

    @Nested
    @DisplayName("getPlayerTargetTileHistory 메소드는")
    class DescribeGetPlayerTargetTileHistoryMethodTest {

        @Nested
        @DisplayName("만약 출력하고자 하는 BridgeTile이 주어지면")
        class ContextWithBridgeTile {

            @ParameterizedTest
            @MethodSource("bridge.domain.player.arguments.PlayerTestArguments#getPlayerTargetTileHistoryArgument")
            @DisplayName("해당 BridgeTile에 대한 플레이어의 이동 경로를 반환한다")
            void itReturnsString(List<BridgeTile> playerSteps, String expectedUpHistory, String expectedDownHistory) {
                BridgeNumberGenerator generator = new StubBridgeNumberGenerator(List.of(0, 0, 0));
                Bridge bridge = new Bridge(3, generator);

                playerSteps.forEach(step -> player.move(bridge, step));

                String upHistory = player.getPlayerTargetTileHistory(BridgeTile.UP);
                String downHistory = player.getPlayerTargetTileHistory(BridgeTile.DOWN);

                assertThat(upHistory).isEqualTo(expectedUpHistory);
                assertThat(downHistory).isEqualTo(expectedDownHistory);
            }
        }
    }

    @Nested
    @DisplayName("success 메소드는")
    class DescribeSuccessMethodTest {

        @Nested
        @DisplayName("만약 Bridge가 주어지면")
        class ContextWithBridge {

            @ParameterizedTest
            @MethodSource("bridge.domain.player.arguments.PlayerTestArguments#successHistoryArgument")
            @DisplayName("다리를 건너는 것을 성공했는지 유무를 반환한다")
            void itReturnsBoolean(List<BridgeTile> playerSteps, boolean expected) {
                BridgeNumberGenerator generator = new StubBridgeNumberGenerator(List.of(0, 0, 0));
                Bridge bridge = new Bridge(3, generator);

                playerSteps.forEach(step -> player.move(bridge, step));

                boolean actual = player.success(bridge);

                assertThat(actual).isSameAs(expected);
            }
        }
    }

    @Nested
    @DisplayName("clearPlayerInfo 메소드는")
    class DescribeClearPlayerInfoMethodTest {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameter {

            @Test
            @DisplayName("플레이어 관련 정보를 초기화한다")
            void itReturnsNothing() {
                BridgeNumberGenerator generator = new StubBridgeNumberGenerator(List.of(0, 0, 0));
                Bridge bridge = new Bridge(3, generator);

                IntStream.range(0, 3).forEach(i -> player.move(bridge, BridgeTile.DOWN));

                assertThat(player.success(bridge)).isTrue();

                player.clearPlayerInfo();

                assertThat(player.success(bridge)).isFalse();
            }
        }
    }
}