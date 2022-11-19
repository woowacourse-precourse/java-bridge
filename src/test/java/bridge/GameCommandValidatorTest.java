package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class GameCommandValidatorTest {

    private static final InputValidator inputValidator = new GameCommandValidator();

    @DisplayName("잘못된 게임 재시작/종료 여부를 입력 받으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", ""})
    void invalidGameCommandInputTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    @DisplayName("올바른 게임 재시작/종료 여부를 입력 받으면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void validGameCommandInputTest(String input) {
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }
}
