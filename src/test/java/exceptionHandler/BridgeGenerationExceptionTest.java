package exceptionHandler;

import bridge.Bridge;
import enumCollections.AvailableInput;
import enumCollections.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGenerationExceptionTest {
    @ParameterizedTest
    @MethodSource("generateIncorrectCharacterMovable")
    @DisplayName("U 또는 D가 아닌 값 입력한 경우 예외 처리한다.")
    void 다리_생성_잘못된_값_입력_예외_테스트(List<String> movableSides) {
        assertThatThrownBy(() -> BridgeGenerationException.validate(movableSides))
                .hasMessage(ExceptionMessage.SELECT_SIDE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("generateMovableSmallerThanMinimum")
    @DisplayName("다리의 길이가 최소값보다 작은 경우 예외 처리한다.")
    void 최소값보다_작은_길이의_다리_생성_예외_테스트(List<String> movableSides) {
        assertThatThrownBy(() -> BridgeGenerationException.validate(movableSides))
                .hasMessage(ExceptionMessage.SMALLER_THAN_MINIMUM_BRIDGE_LENGTH.getMessage());
    }

    @ParameterizedTest
    @MethodSource("generateMovableBiggerThanMaximum")
    @DisplayName("다리의 길이가 최댓값보다 큰 경우 예외 처리한다.")
    void 최댓값보다_큰_길이의_다리_생성_예외_테스트(List<String> movableSides) {
        assertThatThrownBy(() -> BridgeGenerationException.validate(movableSides))
                .hasMessage(ExceptionMessage.BIGGER_THAN_MAXIMUM_BRIDGE_LENGTH.getMessage());
    }

    @ParameterizedTest
    @MethodSource("generateMovableSmallerThanMinimum")
    @DisplayName("다리의 길이가 최소값보다 작은 경우 예외 처리한다.")
    void 최댓값보다_작은_길이의_다리_생성_예외_테스트(List<String> movableSides) {
        assertThatThrownBy(() -> BridgeGenerationException.validate(movableSides))
                .hasMessage(ExceptionMessage.SMALLER_THAN_MINIMUM_BRIDGE_LENGTH.getMessage());
    }

    @Test
    @DisplayName("빈 문자열이 입력되었을 경우 예외 처리한다.")
    void 빈_문자열_예외_테스트() {
        assertThatThrownBy(() -> BridgeGenerationException.validate(List.of(" ")))
                .hasMessage(ExceptionMessage.EMPTY_STRING.getMessage());
    }

    static Stream<Arguments> generateIncorrectCharacterMovable() {
        return Stream.of(
                Arguments.of(Arrays.asList("a", "1", "Y")),
                Arguments.of(Arrays.asList("a", "a", "b")),
                Arguments.of(Arrays.asList("u", "U", "U")),
                Arguments.of(Arrays.asList("D", "D", "d")),
                Arguments.of(Arrays.asList("U", "U", "UU")),
                Arguments.of(Arrays.asList("U", "U", "DD")),
                Arguments.of(Arrays.asList("U", "U", "U", "D ")),
                Arguments.of(Arrays.asList(" U", "D ", "U")),
                Arguments.of(Arrays.asList("U.", "D ", "U"))
        );
    }

    static Stream<Arguments> generateMovableSmallerThanMinimum() {
        return Stream.of(
                Arguments.of(Arrays.asList("")),
                Arguments.of(Arrays.asList("U")),
                Arguments.of(Arrays.asList("U", "U"))
        );
    }

    static Stream<Arguments> generateMovableBiggerThanMaximum() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        "U", "U", "U", "U", "U", "U", "U", "U", "U", "U",
                        "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U"
                )),
                Arguments.of(Arrays.asList(
                        "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U",
                        "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U",
                        "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U"
                ))
        );
    }
}