package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @ParameterizedTest(name = "명령어 입력 예외 검증 테스트")
    @MethodSource("명령어_입력_검증_예외_데이터")
    void 명령어_입력_검증_예외(List<String>commands, String command) {
        assertThatThrownBy(() -> Validator.checkConsoleCommandIsCorrect(commands, command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> 명령어_입력_검증_예외_데이터() {
        return Stream.of(
                Arguments.of(List.of("U"), "u"),
                Arguments.of(List.of("U", "D"), "K"),
                Arguments.of(List.of("U", "D"), "1"),
                Arguments.of(List.of("U", "D"), "가")
        );
    }

    @ParameterizedTest(name = "명령어 입력 검증 테스트")
    @MethodSource("명령어_입력_검증_데이터")
    void 명령어_입력_검증(List<String>commands, String command) {
        assertDoesNotThrow(() -> Validator.checkConsoleCommandIsCorrect(commands, command));
    }

    static Stream<Arguments> 명령어_입력_검증_데이터() {
        return Stream.of(
                Arguments.of(List.of("U"), "U"),
                Arguments.of(List.of("U", "D"), "D"),
                Arguments.of(List.of("R", "Q"), "R")
        );
    }
}