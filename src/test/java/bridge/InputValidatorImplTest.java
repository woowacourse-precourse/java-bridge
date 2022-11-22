package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorImplTest {

    private final InputValidator inputValidator = new InputValidatorImpl();

    @DisplayName("입력된 다리 크기가 정수형으로 변환 가능하지 않을때의 예외")
    @ParameterizedTest
    @ValueSource(strings = {"j", "-", "\n", " ", "\\"})
    void bridgeSizeDataType(String inputBridgeSize) {
        assertThatThrownBy(() -> inputValidator.bridgeSizeDataType(inputBridgeSize))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("입력된 다리 크기가 3 이상이 아니고, 20 이하가 아닐때의 예외")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 21, 22})
    void bridgeSizeRange(int inputBridgeSize) {
        InputValidator inputValidator = new InputValidatorImpl();
        assertThatThrownBy(() -> inputValidator.bridgeSizeRange(inputBridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 이동 명령이 U, D 둘 중 하나에 해당하지 않을때의 예외")
    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "C", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
            "T", "V", "W", "X", "Y", "Z", "a", "b", "c", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", " ", "\n"
    })
    void moving(String inputMoving) {
        InputValidator inputValidator = new InputValidatorImpl();
        assertThatThrownBy(() -> inputValidator.moving(inputMoving))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 게임 재시작 명령이 R, Q 둘 중 하나에 해당하지 않을때의 예외")
    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "S",
            "T", "V", "W", "X", "Y", "Z", "a", "b", "c", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
            "s", "t", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", " ", "\n"
    })
    void gameCommand(String inputGameCommand) {
        InputValidator inputValidator = new InputValidatorImpl();
        assertThatThrownBy(() -> inputValidator.gameCommand(inputGameCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }
}