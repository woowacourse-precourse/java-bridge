package bridge.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @ParameterizedTest(name = "사용자 입력: {0}이면 형식에 맞다")
    @ValueSource(strings = {"U", "D"})
    void validateMoving_메서드는_사용자_입력을_받아_형식에_맞는지_확인한다(String moving) {
        assertThatNoException().isThrownBy(() -> {
            InputValidator.validateMoving(moving);
        });
    }

    @ParameterizedTest(name = "사용자 입력: {0}이면 예외 던진다")
    @ValueSource(strings = {"u", "d", "UD", "DU", " U", "D ", " ", "", "R", "Q"})
    void validateMoving_메서드는_사용자_입력을_받아_형식에_안맞으면_예외_던진다(String moving) {
        assertThatThrownBy(() -> {
            InputValidator.validateMoving(moving);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "사용자 입력: {0}이면 0 이상의 정수이다")
    @ValueSource(strings = {"3", "20", "123"})
    void validateBridgeSize_메서드는_사용자_입력을_받아_0_이상의_정수가_맞는지_확인한다(String bridgeSize) {
        assertThatNoException().isThrownBy(() -> {
            InputValidator.validateBridgeSize(bridgeSize);
        });
    }

    @ParameterizedTest(name = "사용자 입력: {0}이면 0 이상의 정수가 아니다")
    @ValueSource(strings = {" ", "-3", "", "5j", "a"})
    void validateBridgeSize_메서드는_사용자_입력을_받아_0_이상의_정수가_아니면_예외_던진다(String bridgeSize) {
        assertThatThrownBy(() -> {
            InputValidator.validateBridgeSize(bridgeSize);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "사용자 입력: {0}이면 형식에 맞다")
    @ValueSource(strings = {"R", "Q"})
    void validateGameCommand_메서드는_사용자_입력을_받아_형식에_맞는지_확인한다(String gameCommand) {
        assertThatNoException().isThrownBy(() -> {
            InputValidator.validateGameCommand(gameCommand);
        });
    }

    @ParameterizedTest(name = "사용자 입력: {0}이면 예외 던진다")
    @ValueSource(strings = {"r", "q", "RQ", "QR", " R", "Q ", " ", "", "U", "D"})
    void validateGameCommand_메서드는_사용자_입력을_받아_형식에_안맞으면_예외_던진다(String gameCommand) {
        assertThatThrownBy(() -> {
            InputValidator.validateGameCommand(gameCommand);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
