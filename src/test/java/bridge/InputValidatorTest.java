package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class InputValidatorTest {

    //TODO: 테스트 코드 중복 제거

    /*
     * 다리 길이 입력에 대한 예외 검사
     * */
    @DisplayName("잘못된 다리 길이를 입력 받으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"3j", "", "45", "0", "200000000000000000000000"})
    void invalidBridgeSizeInputTest(String input) {
        InputValidator inputValidator = new BridgeSizeValidator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    @DisplayName("올바른 다리 길이를 입력 받으면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    void validBridgeSizeInputTest(String input) {
        InputValidator inputValidator = new BridgeSizeValidator();
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    /*
     * 이동할 칸 입력에 대한 예외 검사
     * */
    @DisplayName("잘못된 이동할 칸을 입력 받으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", ""})
    void invalidMovingInputTest(String input) {
        InputValidator inputValidator = new MovingValidator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    @DisplayName("올바른 이동할 칸을 입력 받으면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validMovingInputTest(String input) {
        InputValidator inputValidator = new MovingValidator();
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    /*
     * 게임 재시작/종료 여부 입력에 대한 예외 검사
     * */
    @DisplayName("잘못된 게임 재시작/종료 여부를 입력 받으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", ""})
    void invalidGameCommandInputTest(String input) {
        InputValidator inputValidator = new GameCommandValidator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    @DisplayName("올바른 게임 재시작/종료 여부를 입력 받으면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void validGameCommandInputTest(String input) {
        InputValidator inputValidator = new GameCommandValidator();
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }
}
