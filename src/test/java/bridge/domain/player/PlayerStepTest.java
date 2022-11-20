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
    @DisplayName("getMovableLog 메소드는")
    class DescribeGetMovableLogMethodTest {

        @Nested
        @DisplayName("만약 BridgeTile이 주어지면")
        class ContextWithoutParameterTest {

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
            void it_returns_moveHistory(boolean result, BridgeTile bridgeTile, String expected) {
                PlayerStep playerStep = new PlayerStep(BridgeTile.UP, result);

                String actual = playerStep.getMovableLog(bridgeTile);

                assertThat(actual).isEqualTo(expected);
            }
        }
    }

    @Nested
    @DisplayName("isMovable 메소드는")
    class DescribeIsMovableMethodTest {

        @Nested
        @DisplayName("만약 호출되면")
        class ContextWithoutParameterTest {

            @ParameterizedTest
            @ValueSource(booleans = {true, false})
            @DisplayName("플레이어가 입력한 칸으로 움직였는지 여부를 반환한다")
            void it_returns_movable(boolean expected) {
                PlayerStep playerStep = new PlayerStep(BridgeTile.UP, expected);

                boolean actual = playerStep.isMovable();

                assertThat(actual).isSameAs(expected);
            }
        }
    }
}
