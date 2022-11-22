package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.utils.UserInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputExceptionTest {

    @DisplayName("다리 길이가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void inputSizeByNotNumber() {
        assertThatThrownBy(() -> UserInputException.isNumber("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 3이상 20이하가 아닌 경우 예외가 발생한다.")
    @Test
    void inputSizeByInvalidRange() {
        assertThatThrownBy(() -> UserInputException.isValidRange("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸 입력 시 U 또는 D 가 아닌 경우 경우 예외가 발생한다.")
    @Test
    void inputMovingCommandByInvalidValue() {
        assertThatThrownBy(() -> UserInputException.isCorrectMovingCommand("Q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 여부 입력 시 R 또는 Q가 아닌 경우 예외가 발생한다.")
    @Test
    void inputGameCommandByInvalidValue() {
        assertThatThrownBy(() -> UserInputException.isCorrectGameCommand("U"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
