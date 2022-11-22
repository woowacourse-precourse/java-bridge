package bridge.view;

import bridge.domain.BridgeSize;
import bridge.domain.MoveCommand;
import bridge.domain.ReGameCommand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "-1", "0", "999999999999"})
    @DisplayName("사용자가 다리길이에 잘못된 값을 입력하면 에러 발생")
    void readBridgeSize(String input) {
        Assertions.assertThatThrownBy(() -> new BridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "A", "B"})
    @DisplayName("사용자가 움직일 위치를 잘못된 값을 입력하면 에러 발생")
    void readMoving(String input) {
        Assertions.assertThatThrownBy(() -> new MoveCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "A", "B"})
    @DisplayName("사용자가 게임 실패시 재시작 또는 종료 값을 잘못 입력하면 에러 발생")
    void readGameCommand(String input) {
        Assertions.assertThatThrownBy(() -> new ReGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
