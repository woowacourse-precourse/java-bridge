package bridge;

import static bridge.view.Validator.validateInputSizeException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class ValidatorTest {

    @DisplayName("다리 길이 생성 시 숫자 범위 테스트")
    @ValueSource(strings = {"1", "0", "-1", "46"})
    @ParameterizedTest
    void validateInputSizeTest(String input) {
        assertThatThrownBy(() -> validateInputSizeException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 값 Null 테스트")
    @Test
    void validateInputSizeNullTest() {

    }

    @DisplayName("U,D 외의 문자를 입력했다면 ERROR 출력")
    @Test
    void validateInputDirectionTest() {

    }

    @DisplayName("U, D를 대문자로 입력했는지 테스트")
    @Test
    void validateInputDirectionLowerCaseTest() {

    }

    @DisplayName("이동 입력 값 Null 테스트")
    @Test
    void validateInputDirectionNullTest() {

    }

    @DisplayName("재시작, 종료 시 R 또는 Q외의 문자를 선택했다면 ERROR 출력")
    @Test
    void validateInputGameRestartTest() {

    }

    @DisplayName("재시작, 종료 시 R 또는 Q외의 문자를 선택했다면 ERROR 출력")
    @Test
    void validateInputGameRestartLowerCaseTest() {

    }

    @DisplayName("재시작, 종료 시 R 또는 Q외의 문자를 선택했다면 ERROR 출력")
    @Test
    void validateInputGameRestartNullTest() {

    }
}
