package bridge.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.exception.domain.WrongGeneratorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTileTest {

    @Nested
    @DisplayName("findTile 메소드는")
    class DescribeFindTileMethodTest {

        @Nested
        @DisplayName("만약 이동할 칸에 대한 커맨드가 주어진다면")
        class ContextWithCommand {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "D:DOWN",
                        "U:UP"
                    },
                    delimiter = ':'
            )
            @DisplayName("커맨드가 일치하는 BridgeTile을 반환한다")
            void itReturnsBridgeTile(String command, BridgeTile expectedTile) {
                BridgeTile actualTile = BridgeTile.findTile(command);

                assertThat(actualTile).isSameAs(expectedTile);
            }
        }
    }

    @Nested
    @DisplayName("mapToCommand 커맨드는")
    class DescribeMapToCommand {

        @Nested
        @DisplayName("만약 다리의 칸에 해당하는 값이 주어지면")
        class ContextWithValidValue {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "0:D",
                        "1:U"
                    },
                    delimiter = ':'
            )
            @DisplayName("다리의 칸에 해당하는 커맨드를 반환한다")
            void itReturnsCommand(int validValue, String expectedCommand) {
                String actualCommand = BridgeTile.mapToCommand(validValue);

                assertThat(actualCommand).isEqualTo(expectedCommand);
            }
        }

        @Nested
        @DisplayName("만약 다리의 칸에 해당하지 않는 값이 주어지면")
        class ContextWithInvalidValue {

            @ParameterizedTest
            @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9, 10})
            @DisplayName("WrongGeneratorException 예외가 발생한다.")
            void itThrowsException(int invalidValue) {
                assertThatThrownBy(() -> BridgeTile.mapToCommand(invalidValue))
                        .isInstanceOf(WrongGeneratorException.class);
            }
        }
    }
}