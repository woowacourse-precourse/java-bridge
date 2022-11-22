package bridge.utils.message;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExceptionMessageUtilsTest {

    @Nested
    @DisplayName("getMessage 메소드는")
    class DescribeGetMessageMethodTest {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextGetMessageMethodTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "WRONG_BRIDGE_SIZE:3:20",
                        "WRONG_PLAYER_MOVE:U:D",
                        "WRONG_GAME_COMMAND:R:Q",
                        "WRONG_GENERATOR:0:1"
                    },
                    delimiter = ':'
            )
            @DisplayName("호출한 예외 메세지를 상수와 조합해 반환한다")
            void it_returns_exceptionMessage(ExceptionMessageUtils utils,
                String expectedConst1, String expectedConst2) {
                String actualMessage = utils.getMessage();

                assertThat(actualMessage)
                        .contains(expectedConst1)
                        .contains(expectedConst2);
            }
        }
    }
}
