package bridge.domain.resources.bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.utils.parser.BridgeSizeInputParser;

import bridge.domain.exception.OutOfBridgeSizeBoundaryException;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeSizeTest {

    @Nested
    @DisplayName("BridgeSize Class")
    class BridgeSizeKoTest {

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("validation for right input of")
        class DescribeValidationRightInput {

            @DisplayName("inside the boundaries")
            @ParameterizedTest(name = "{0}")
            @MethodSource("validParameters")
            void InsideTheBoundaries(String input, int sizeOfBridge) {

                BridgeSize bridgeSize = BridgeSizeInputParser.parseBridgeSize(input);
                int size = bridgeSize.getSize();
                assertThat(size).isEqualTo(sizeOfBridge);

            }

            Stream<Arguments> validParameters() {
                return Stream.of(
                    Arguments.of("3", 3),
                    Arguments.of("4", 4),
                    Arguments.of("5", 5),
                    Arguments.of("6", 6),
                    Arguments.of("7", 7),
                    Arguments.of("8", 8),
                    Arguments.of("9", 9),
                    Arguments.of("10", 10),
                    Arguments.of("11", 11),
                    Arguments.of("12", 12),
                    Arguments.of("13", 13),
                    Arguments.of("14", 14),
                    Arguments.of("15", 15),
                    Arguments.of("16", 16),
                    Arguments.of("17", 17),
                    Arguments.of("18", 18),
                    Arguments.of("19", 19),
                    Arguments.of("20", 20)
                );
            }
        }

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("validation for wrong input of")
        class DescribeValidationWrongInput {

            @DisplayName("empty, null, isNumeric")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters1")
            void isNumericAndEmptyAndNull(String input, String message) {
                Assertions.assertThatThrownBy(() -> {

                    BridgeSize bridgeSize = BridgeSizeInputParser.parseBridgeSize(input);

                }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");

            }

            Stream<Arguments> invalidParameters1(){
                return Stream.of(
                    Arguments.of("ㄱㄴㄷㄹㅁㅂㅅㅇ", "korean1"),
                    Arguments.of("마지막 프로젝트", "korean2"),
                    Arguments.of("수 고 가 많 았 다", "korean3"),
                    Arguments.of("abcdef", "alphabet"),
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

            @DisplayName("ouf of bridge size boundary")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters2")
            void isNumeric(String input, String message) {
                Assertions.assertThatThrownBy(() -> {

                    BridgeSize bridgeSize = BridgeSizeInputParser.parseBridgeSize(input);

                }).isInstanceOf(OutOfBridgeSizeBoundaryException.class).hasMessageContaining("[ERROR]");

            }

            Stream<Arguments> invalidParameters2(){
                return Stream.of(
                    Arguments.of("0", "lower boundary1"),
                    Arguments.of("1", "lower boundary2"),
                    Arguments.of("2", "lower boundary3"),
                    Arguments.of("21", "upper boundary1"),
                    Arguments.of("40", "upper boundary2"),
                    Arguments.of("60", "upper boundary3"),
                    Arguments.of("80", "upper boundary4"),
                    Arguments.of("100", "upper boundary5")
                );
            }
        }
    }
}