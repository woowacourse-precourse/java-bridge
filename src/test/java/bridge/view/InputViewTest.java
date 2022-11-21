package bridge.view;

import bridge.model.BridgeSize;
import bridge.model.GameCommand;
import bridge.model.Moving;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputViewTest {

    @DisplayName("다리길이에 범위를 넘거나, 숫자가 아닌 값이 들어왔을때 예외처리")
    @ValueSource(strings = {"999", "0", "2", "-123", "21", "", " ", "하하"})
    @ParameterizedTest
    void readBridgeSize(String input) {
        assertThatThrownBy(() -> new BridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리길이에 적정한 범위의 값이 들어왔을때는 예외가 발생하지 않는다")
    @ValueSource(strings = {"3", "10", "15", "20"})
    @ParameterizedTest
    void readBridgeSize2(String input) {
        assertThat(new BridgeSize(input))
                .isNotInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸에 U나 D이 아닌 값이 들어왔을때 예외처리")
    @ValueSource(strings = {"R", "0", "-123", "u", "", " ", "하하"})
    @ParameterizedTest
    void readMoving(String input) {
        assertThatThrownBy(() -> Moving.getMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸에 U나 D가 들어왔으면 예외가 발생하지 않는다")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void readMoving2(String input) {
        assertThat(Moving.getMoving(input))
                .isNotInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 여부에 R나 Q이 아닌 값이 들어왔을때 예외처리")
    @ValueSource(strings = {"U", "0", "-123", "q", "", " ", "하하"})
    @ParameterizedTest
    void readGameCommand(String input) {
        assertThatThrownBy(() -> GameCommand.getGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 여부에 R나 Q가 들어왔으면 예외가 발생하지 않는다")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void readGameCommand2(String input) {
        assertThat(GameCommand.getGameCommand(input))
                .isNotInstanceOf(IllegalArgumentException.class);
    }
}