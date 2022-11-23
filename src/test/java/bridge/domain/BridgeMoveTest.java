package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMoveTest {

    @ParameterizedTest(name = "U나 D를 입력하면 해당하는 BridgeMove 객체를 반환한다")
    @ValueSource(strings = {"U", "D"})
    void getBridgeMoveByMoveCommand(String command) {
        BridgeMove actual = BridgeMove.getBridgeMoveByMoveCommand(command);
        assertThat(actual.getMoveCommand()).isEqualTo(command);
    }

    @ParameterizedTest(name = "잘못된 움직임 명령어를 입력하면 예외가 발생한다")
    @ValueSource(strings = {"u", "d", "", " ", "u\\", "1"})
    void getBridgeMoveByMoveCommandThrowsError(String command) {
        assertThatThrownBy(() -> BridgeMove.getBridgeMoveByMoveCommand(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("U 또는 D를 입력해주세요.");

    }

    @ParameterizedTest(name = "잘못된 숫자를 입력하면 예외가 발생한다")
    @ValueSource(ints = {2, 3, -1, 100})
    void getBridgeMoveByMoveCodeThrowsError(int code) {
        assertThatThrownBy(() -> BridgeMove.getBridgeMoveByMoveCode
                (code))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 또는 1를 입력해주세요.");

    }

    @ParameterizedTest(name = "1이나 0를 입력하면 해당하는 BridgeMove 객체를 반환한다")
    @ValueSource(ints = {1, 0})
    void getBridgeMoveByMoveCode(int code) {
        BridgeMove actual = BridgeMove.getBridgeMoveByMoveCode(code);
        assertThat(actual.getMoveCode()).isEqualTo(code);
    }
}