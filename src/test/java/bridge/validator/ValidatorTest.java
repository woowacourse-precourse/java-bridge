package bridge.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @ParameterizedTest
    @CsvSource({"3,true", "20,true"})
    @DisplayName("다리 길이 입력 유효성 검사 기능 성공 테스트")
    void isValidBridgeSize(int input, boolean expected) {
        boolean actual = validator.isValidBridgeSize(input);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"2,[ERROR] 범위를 벗어난 길이입니다.", "21,[ERROR] 범위를 벗어난 길이입니다."})
    @DisplayName("다리 길이 입력 유효성 검사 기능 실패 테스트")
    void isValidBridgeSize(int input, String expected) {
        assertThatThrownBy(() -> validator.isValidBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }

    @ParameterizedTest
    @CsvSource({"U,true", "D,true"})
    @DisplayName("다리 이동 입력 유효성 검사 기능 성공 테스트")
    void isValidMoving(String input, boolean expected) {
        boolean actual = validator.isValidMoving(input);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"u,[ERROR] 이동은 U(위)/D(아래)로만 할 수 있습니다.", "d,[ERROR] 이동은 U(위)/D(아래)로만 할 수 있습니다."})
    @DisplayName("다리 이동 입력 유효성 검사 기능 실패 테스트")
    void isValidMoving(String input, String expected) {
        assertThatThrownBy(() -> validator.isValidMoving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }

    @ParameterizedTest
    @CsvSource({"R,true", "Q,true"})
    @DisplayName("게임 재시작 혹은 종료 입력 유효성 검사 기능 성공 테스트")
    void isValidGameCommand(String input, boolean expected) {
        boolean actual = validator.isValidGameCommand(input);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"r,[ERROR] 명령은 R(재시작)/Q(종료)로만 할 수 있습니다.", "q,[ERROR] 명령은 R(재시작)/Q(종료)로만 할 수 있습니다."})
    @DisplayName("게임 재시작 혹은 종료 입력 유효성 검사 기능 실패 테스트")
    void isValidGameCommand(String input, String expected) {
        assertThatThrownBy(() -> validator.isValidGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }
}