package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameRuleTest {

    @DisplayName("다리 길이가 지정된 범위 밖이면, 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 21, 0, -1})
    void validateBridgeSizeErrorTest(int size) {
        assertThatThrownBy(() -> GameRule.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동하려는 다리의 기호가 없으면, 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"K", "u", "d", "UP_BRIDGE"})
    void validateMovingInputErrorTest(String input) {
        assertThatThrownBy(() -> GameRule.validateMovingInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("명령이 게임룰 상수에 없으면, 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"K", "q", "Quit", "Restart"})
    void validateCommandErrorTest(String input) {
        assertThatThrownBy(() -> GameRule.validateCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 명령이 들어왔을 때, 예외발생하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"q,k,h"})
    void getCommandErrorTest(String command) {
        assertThatThrownBy(() -> GameRule.getCommand(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 명령이 들어왔을 때, 예외발생 메시지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"q,k,h"})
    void getCommandErrorMessageTest(String command) {
        try {
            GameRule.getCommand(command);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).contains("[ERROR]");
        }
    }
}
