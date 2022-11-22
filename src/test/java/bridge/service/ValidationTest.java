package bridge.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static bridge.utils.Validation.*;

class ValidationTest {

    @ParameterizedTest
    @DisplayName("isNumber 테스트")
    @CsvSource(value = {"1", "2"})
    void isNumberTest(String s) {
        isNumber(s);
    }

    @ParameterizedTest
    @DisplayName("isNumber 예외 테스트")
    @MethodSource("errorCase")
    void isNumberError(String s) {
        try {
            isNumber(s);
        } catch (Exception e) {
            assert e.getMessage().contains("[ERROR]");
        }
    }

    @ParameterizedTest
    @DisplayName("isUpOrDown 테스트")
    @CsvSource(value = {"U", "D"})
    void isUpOrDownTest(String s) {
        isContain("UD", s);
    }

    @ParameterizedTest
    @DisplayName("isUpOrDown 예외 테스트")
    @MethodSource("errorCase")
    void isUpOrDownError(String s) {
        try {
            isContain("UD", s);
        } catch (Exception e) {
            assert e.getMessage().contains("[ERROR]");
        }
    }

    @ParameterizedTest
    @DisplayName("isRestartOrQuit 테스트")
    @CsvSource(value = {"R", "Q"})
    void isRestartOrQuitTest(String s) {
        isContain("RQ", s);
    }

    @ParameterizedTest
    @DisplayName("isRestartOrQuit 예외 테스트")
    @MethodSource("errorCase")
    void isRestartOrQuitError(String s) {
        try {
            isContain("RQ", s);
        } catch (Exception e) {
            assert e.getMessage().contains("[ERROR]");
        }
    }

    static Stream<String> errorCase() {
        return Stream.of(
                "",
                "o",
                "hi",
                "-1",
                null
        );
    }
}