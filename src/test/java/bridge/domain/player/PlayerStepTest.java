package bridge.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.game.BridgeTile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerStepTest {

    @Nested
    @DisplayName("getMoveResultLog 메소드는")
    class DescribeGetMoveResultLogMethodTest {

        @Nested
        @DisplayName("만약 BridgeTile이 주어지면")
        class ContextWithoutParameter {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "true:DOWN:' '",
                        "true:UP:O",
                        "false:UP:X"
                    },
                    delimiter = ':'
            )
            @DisplayName("PlayerStep에 저장된 BridgeTile과 비교해 이동 결과를 정해진 규칙대로 반환한다")
            void itReturnsBoolean(boolean result, BridgeTile bridgeTile, String expectedLog) {
                PlayerStep playerStep = new PlayerStep(BridgeTile.UP, result);

                String actualLog = playerStep.getMoveResultLog(bridgeTile);

                assertThat(actualLog).isEqualTo(expectedLog);
            }
        }
    }

    @Nested
    @DisplayName("isMoving 메소드는")
    class DescribeIsMovingMethodTest {

        @Nested
        @DisplayName("만약 호출되면")
        class ContextWithoutParameter {

            @ParameterizedTest
            @ValueSource(booleans = {true, false})
            @DisplayName("플레이어가 입력한 칸으로 움직였는지 여부를 반환한다")
            void itReturnsMovingResult(boolean expectedMoving) {
                PlayerStep playerStep = new PlayerStep(BridgeTile.UP, expectedMoving);

                boolean actualMoving = playerStep.isMoving();

                assertThat(actualMoving).isSameAs(expectedMoving);
            }
        }
    }
}