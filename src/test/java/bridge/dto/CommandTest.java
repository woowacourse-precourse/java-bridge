package bridge.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CommandTest {
    @DisplayName("게임 재시작/종료 여부 정상 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    public void createCommand(String input) {
        assertThat(new Command(input)).isInstanceOf(Command.class);
    }

    @DisplayName("입력 가능한 값 외의 잘못된 값 입력에 대한 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {" R", "r", "q", "Q ", "RQ", "1"})
    public void validateByValue(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Command(input));
    }

    @DisplayName("입력을 안한 경우에 대한 예외 처리")
    @Test
    public void validateByBlank() {
        String input = "";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Command(input));
    }
}