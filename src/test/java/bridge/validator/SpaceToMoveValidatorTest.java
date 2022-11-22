package bridge.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constants.ValidatorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SpaceToMoveValidatorTest {
    @DisplayName("입력이 U나 D가 아니라면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", " ", "u"})
    void createNotUorD(String input) {
        assertThatThrownBy(() ->SpaceToMoveValidator.validateSpaceToMove(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorMessage.NEXT_SPACE_IS_U_OR_D.toString());

    }
}