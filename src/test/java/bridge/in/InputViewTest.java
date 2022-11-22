package bridge.in;

import bridge.domain.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputViewTest {

    InputView inputView;

    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    @ParameterizedTest
    @DisplayName("다리 사이즈 예외 테스트")
    @ValueSource(strings = {"22", "-1", "0", "A", "\n", " ", "\\"})
    void validateBridgeSizeInputTest(String inputSize) {
        assertThatThrownBy(() -> inputView.validateBridgeSizeInput(inputSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("칸 이동 입력 받을 시 예외 테스트")
    @ValueSource(strings = {"Q", "u", "up", "d", "\n", " ", "\\"})
    void validateCommandMoveTest(String inputCommand) {
        List<Command> commands = List.of(Command.UP, Command.DOWN);
        final int size = 1;

        assertThatThrownBy(() -> inputView.validateCommand(commands, inputCommand, size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("재시작 혹은 종료 입력 받을 시 예외 테스트")
    @ValueSource(strings = {"U", "q", "r", "d", "\n", " ", "\\"})
    void validateCommandRetryTest(String inputCommand) {
        List<Command> commands = List.of(Command.RETRY, Command.EXIT);
        final int size = 1;

        assertThatThrownBy(() -> inputView.validateCommand(commands, inputCommand, size))
                .isInstanceOf(IllegalArgumentException.class);
    }

}