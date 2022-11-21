package bridge.domain;

import bridge.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserBridgeTest {

    @DisplayName("플레이어가 올바른 방향을 입력시 정상적으로 동작한다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void createRightInput(String input) {
        UserBridge userBridge = new UserBridge(input);
        assertThat(userBridge.getUserInput()).isEqualTo(input);
    }

    @DisplayName("플레이어가 빈 값 입력 시 에러가 발생한다.")
    @Test
    void createNullInput() {
        assertThatThrownBy(() -> new UserBridge(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SPACE_TYPE.getMessage());
    }

    @DisplayName("플레이어가 U와 D 외 문자 입력 시 에러가 발생한다.")
    @ValueSource(strings = {"A", "u", "d", "UA", "DB"})
    @ParameterizedTest
    void createInputNotInType(String input) {
        assertThatThrownBy(() -> new UserBridge(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SPACE_TYPE.getMessage());
    }

    @DisplayName("플레이어가 U와 D를 같이 입력 시 에러가 발생한다.")
    @ValueSource(strings = {"UD", "DU", "DUU", "UU", "DD"})
    @ParameterizedTest
    void createTogetherInput(String input) {
        assertThatThrownBy(() -> new UserBridge(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SPACE_TYPE.getMessage());
    }
}
