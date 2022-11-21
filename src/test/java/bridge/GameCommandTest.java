package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.exception.InvalidGameCommandException;
import bridge.domain.resources.GameCommand;
import bridge.utils.parser.GameCommandInputParser;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameCommandTest {

    @Nested
    @DisplayName("GameCommand Class")
    class GameCommandKoTest {

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("validation for right input of")
        class DescribeValidationRightInput {

            @DisplayName("retry or quit")
            @ParameterizedTest(name = "{1}")
            @MethodSource("validParameters")
            void retryOrQuit(String input, String message) {

                GameCommand gameCommand = GameCommandInputParser.parseGameCommand(input);
                String gameCommandString = gameCommand.getGameCommand();
                assertThat(gameCommandString).containsAnyOf("R", "Q");

            }

            Stream<Arguments> validParameters() {
                return Stream.of(
                    Arguments.of("R", "Retry"),
                    Arguments.of("Q", "Quit")
                );
            }
        }

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("validation for wrong input of")
        class DescribeValidationWrongInput {

            @DisplayName("not alphabet")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters1")
            void notAlphabet(String input, String message) {
                Assertions.assertThatThrownBy(() -> {

                    GameCommand gameCommand = GameCommandInputParser.parseGameCommand(input);

                }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
            }

            Stream<Arguments> invalidParameters1() {
                return Stream.of(
                    Arguments.of("ㄱㄴㄷㄹㅁㅂㅅㅇ", "korean1"),
                    Arguments.of("마지막 프로젝트", "korean2"),
                    Arguments.of("수 고 가 많 았 다", "korean3"),
                    Arguments.of("!@#$%^", "special"),
                    Arguments.of("abc!@#", "alphabet and special"),
                    Arguments.of("ㅣ!@#ㄱ30ㄴ0ㅣ ㄷ ㄹ  %^ㅣ", "mixed1"),
                    Arguments.of("!  @#30  %  60 00    %^", "mixed2"),
                    Arguments.of("[]3[]4[]6[]7[]9[]1[]0[]", "mixed3"),
                    Arguments.of("!@  #<>{}[]<>{???1234%^", "mixed4"),
                    Arguments.of("--12---12", "number with minus1"),
                    Arguments.of("-------12", "number with minus2"),
                    Arguments.of("12-------", "number with minus3"),
                    Arguments.of("-120", "negative number1"),
                    Arguments.of("-12", "negative number2"),
                    Arguments.of("-1", "negative number3"),
                    Arguments.of("         ", "whiteSpace"),
                    Arguments.of("", "empty"),
                    Arguments.of(null, "NULL")
                );
            }
            @DisplayName("not up and down")
            @ParameterizedTest(name = "{0}")
            @MethodSource("invalidParameters2")
            void NotUpAndDown(String input) {
                Assertions.assertThatThrownBy(() -> {

                    GameCommand gameCommand = GameCommandInputParser.parseGameCommand(input);

                }).isInstanceOf(InvalidGameCommandException.class).hasMessageContaining("[ERROR]");
            }

            Stream<Arguments> invalidParameters2() {
                return Stream.of(
                    Arguments.of("A"),
                    Arguments.of("B"),
                    Arguments.of("C"),
                    Arguments.of("ABC"),
                    Arguments.of("ABCEFG")
                );
            }
        }
    }

}